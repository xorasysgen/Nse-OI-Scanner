package nse.skbh.springboot.logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import nse.skbh.springboot.pojo.CurrencyFutureLive;

public class CsvReaderToGetCurrencyLive {

	public CurrencyFutureLive getCsvReaderToGetCurrencyLive() {
		try {
			String myUrl = "https://www1.nseindia.com/marketinfo/fxTracker/priceWatchData.jsp?instrument=FUTCUR&currency=USDINR";
			CurrencyFutureLive results = doHttpUrlConnectionAction(myUrl);
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
	private CurrencyFutureLive doHttpUrlConnectionAction(String desiredUrl) throws Exception {
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
			String parentsString = new String();
			String line = null;
			CurrencyFutureLive currencyFutureLive=new CurrencyFutureLive();
			while ((line = reader.readLine()) != null) {
					if(line.length()>1) {
						parentsString=line.split("~")[0];
						//System.out.println(parentsString);
						currencyFutureLive.setExpiryDate(parentsString.split(":")[3]);
						currencyFutureLive.setLtp(parentsString.split(":")[10]);
						currencyFutureLive.setChange(parentsString.split(":")[15]);
						currencyFutureLive.setChangePercentage(parentsString.split(":")[16]);
						currencyFutureLive.setTodayDate(parentsString.split(":")[17]);
						
					}
				}
			return currencyFutureLive;
		} catch (Exception e) {
			e.printStackTrace();
			return new CurrencyFutureLive();

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