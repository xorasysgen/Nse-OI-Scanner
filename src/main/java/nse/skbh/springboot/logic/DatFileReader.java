package nse.skbh.springboot.logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import nse.skbh.springboot.pojo.ParentSecurityVaR;
import nse.skbh.springboot.pojo.SecurityVaR;

public class DatFileReader {

	public ParentSecurityVaR getSecurityVar() {
		String DDMMYYYY = Utils.getDateBasedOnNSEVaRFile();
		String fileName = "C_VAR1_" + DDMMYYYY + "_1.DAT";

		try {
			String myUrl = "https://www.nseindia.com/archives/nsccl/var/" + fileName;
			// if your url can contain weird characters you will want to
			// encode it here, something like this:
			// myUrl = URLEncoder.encode(myUrl, "UTF-8");

			ParentSecurityVaR results = doHttpUrlConnectionAction(myUrl);
			// System.out.println(new Gson().toJson(results));
			return results;
		} catch (Exception e) {
			return null;
		}

	}

	/**
	 * Returns the output from the given URL.
	 * 
	 * I tried to hide some of the ugliness of the exception-handling in this
	 * method, and just return a high level Exception from here. Modify this
	 * behavior as desired.
	 * 
	 * @param desiredUrl
	 * @return
	 * @throws Exception
	 */
	private ParentSecurityVaR doHttpUrlConnectionAction(String desiredUrl) throws Exception {
		URL url = null;
		BufferedReader reader = null;

		try {
			// create the HttpURLConnection
			url = new URL(desiredUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			// just want to do an HTTP GET here
			connection.setRequestMethod("GET");

			// uncomment this if you want to write output to this url
			// connection.setDoOutput(true);

			// give it 15 seconds to respond
			connection.setReadTimeout(15 * 1000);
			connection.connect();

			// read the output from the server
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			ParentSecurityVaR parentSecurityVaR = new ParentSecurityVaR();
			List<SecurityVaR> data = new LinkedList<SecurityVaR>();
			String line = null;
			while ((line = reader.readLine()) != null) {

				if (line.contains("EQ")) {
					SecurityVaR securityVar = new SecurityVaR();
					String values[] = line.split("\\,");
					securityVar.setSymbol(values[1]);
					securityVar.setSeries(values[2]);

					securityVar.setSecurityVaR(values[4]);
					securityVar.setIndexVaR(values[5]);
					securityVar.setVaRMargin(values[6]);
					securityVar.setExtremeLossRate(values[7]);
					securityVar.setAdhocMargin(values[8]);
					securityVar.setApplicableMarginRate(values[9]);

					String temp = securityVar.getSecurityVaR();
					if (temp != null && temp.length() > 0) {
						Double tempSecurityVar = Double.parseDouble(temp.trim());
						if (tempSecurityVar <= 7.7)
							securityVar.setSafeOrUnsafe("Safe");
						else if (tempSecurityVar >= 7.8 && tempSecurityVar <= 12)
							securityVar.setSafeOrUnsafe("Risky");
						else
							securityVar.setSafeOrUnsafe("Very Risky");
					}
					data.add(securityVar);
				}

			}
			parentSecurityVaR.setData(data);
			return parentSecurityVaR;
		} catch (Exception e) {
			e.printStackTrace();
			return null;

		} finally {
			// close the reader; this can throw an exception too, so
			// wrap it in another try/catch block.
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
			}
		}
	}
}