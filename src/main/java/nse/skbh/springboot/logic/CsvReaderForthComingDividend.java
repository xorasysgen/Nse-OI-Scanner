package nse.skbh.springboot.logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.GZIPInputStream;

import nse.skbh.springboot.pojo.ForthComingDividend;
import nse.skbh.springboot.pojo.ForthComingDividendRows;

public class CsvReaderForthComingDividend {

	public ForthComingDividend getForthComingDividendFromNSEOnline() {
		try {
			//String myUrl = "https://www.nseindia.com/corporates/datafiles/CA_ALL_FORTHCOMING_DIVIDEND.csv";
			String myUrl = "https://www1.nseindia.com/corporates/datafiles/CA_ALL_FORTHCOMING.csv";
			// if your url can contain weird characters you will want to
			// encode it here, something like this:
			// myUrl = URLEncoder.encode(myUrl, "UTF-8");

			ForthComingDividend results = doHttpUrlConnectionAction(myUrl);
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
	private ForthComingDividend doHttpUrlConnectionAction(String desiredUrl) throws Exception {
		URL url = null;
		BufferedReader reader = null;

		try {
			// create the HttpURLConnection
			url = new URL(desiredUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			// just want to do an HTTP GET here
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Accept-Encoding", "gzip,deflate");
			connection.setRequestProperty("Accept", "*/*");
			connection.setRequestProperty("Host", "www1.nseindia.com");
			connection.setRequestProperty("User-Agent", "Mozilla/5.0");
			connection.setRequestProperty("Connection", "Keep-Alive");

			// uncomment this if you want to write output to this url
			// connection.setDoOutput(true);

			// give it 15 seconds to respond
			connection.setReadTimeout(15 * 1000);
			connection.connect();

			// read the output from the server
			GZIPInputStream gzip = new GZIPInputStream(connection.getInputStream());
			reader = new BufferedReader(new InputStreamReader(gzip));			
			ForthComingDividend parentsForthComingDividend = new ForthComingDividend();
			List<ForthComingDividendRows> data = new LinkedList<ForthComingDividendRows>();
			String line = null;
			int i=0;
			while ((line = reader.readLine()) != null) {
					i++;
					if(i==1) {
					continue;//to skip header
					}
					//System.out.println(line);
					ForthComingDividendRows forthComingDividendRows = new ForthComingDividendRows();
					String values[] = line.split("\\,");
					forthComingDividendRows.setSymbol(values[0]!=null?values[0].replaceAll("\"", "").replaceAll("\"", "").trim():"");
					forthComingDividendRows.setCompany(values[1]!=null?values[1].replaceAll("\"", "").trim():"");
					forthComingDividendRows.setFaceValue(values[4]!=null?values[4].replaceAll("\"", "").trim():"");
					forthComingDividendRows.setPurpose(values[5]!=null?values[5].replaceAll("\"", "").trim():"");
					forthComingDividendRows.setExDate(values[6]!=null ? values[6].replaceAll("\"", "").trim(): "");
					forthComingDividendRows.setRecordDate(values[7]!=null ? values[7].replaceAll("\"", "").trim(): "");
					forthComingDividendRows.setBcStartDate(values[8]!=null? values[8].replaceAll("\"", "").trim(): "");
					forthComingDividendRows.setBcEndDate(values[9]!=null?values[9].replaceAll("\"", "").trim() : "");
					data.add(forthComingDividendRows);
				}
			parentsForthComingDividend.setData(data);
			return parentsForthComingDividend;
		} catch (Exception e) {
			e.printStackTrace();
			return new ForthComingDividend();

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