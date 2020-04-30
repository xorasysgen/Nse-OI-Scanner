package nse.skbh.springboot.logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPInputStream;

import nse.skbh.springboot.pojo.USDINRCurrency;

public class CsvReaderCurrency {

	public USDINRCurrency getForthComingResultsFYFromNSEOnline() {
		String expiryDate=new CsvReadertoGetExpiryDateCurrency().GetExpiryDateCurrency();
		try {
			String myUrl = "https://www1.nseindia.com/live_market/dynaContent/live_watch/get_quote/getCIDHistoricalData.jsp?underlying=USDINR&instrument=FUTCUR&expiry="+expiryDate+"&type=-&strike=0&fromDate=undefined&toDate=undefined&datePeriod=week&fileDnld=true";
			//System.out.println(myUrl);
			// if your url can contain weird characters you will want to
			// encode it here, something like this:
			// myUrl = URLEncoder.encode(myUrl, "UTF-8");

			USDINRCurrency results = doHttpUrlConnectionAction(myUrl);
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
	private USDINRCurrency doHttpUrlConnectionAction(String desiredUrl) throws Exception {
		URL url = null;
		BufferedReader reader = null;

		try {
			// create the HttpURLConnection
			url = new URL(desiredUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.addRequestProperty("User-Agent", "Mozilla/5.0");
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
			String line = null;
			int i=0;
			USDINRCurrency usd = new USDINRCurrency();
			while ((line = reader.readLine()) != null) {
					
				if(line.length()>1){
					i++;
					if(i==1) {
					continue;//to skip header
					}
					//System.out.println(line);
					String values[] = line.split("\\,");
					usd.setDate(values[0]!=null?values[0].trim():"");
					usd.setOpen(values[1]!=null?values[1].trim():"");
					usd.setHigh(values[2]!=null?values[2].trim():"");
					usd.setLow(values[3]!=null?values[3].trim():"");
					usd.setClose(values[4]!=null?values[4].trim():"");
					usd.setLtp(values[5]!=null?values[5].trim():"");
					usd.setSettlePrice(values[6]!=null?values[6].trim():"");
				}
				}
			return usd;
		} catch (Exception e) {
			e.printStackTrace();
			return new USDINRCurrency();

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