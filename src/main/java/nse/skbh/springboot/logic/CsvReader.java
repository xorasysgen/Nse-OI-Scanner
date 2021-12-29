package nse.skbh.springboot.logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.GZIPInputStream;

import nse.skbh.springboot.pojo.DeliveryBhavData;
import nse.skbh.springboot.pojo.ParentDeliveryBhavData;

public class CsvReader {

	public ParentDeliveryBhavData getBhavCopyFromNSEOnline() {
		try {
			String myUrl = "https://www1.nseindia.com/products/content/sec_bhavdata_full.csv";
			// if your url can contain weird characters you will want to
			// encode it here, something like this:
			// myUrl = URLEncoder.encode(myUrl, "UTF-8");

			ParentDeliveryBhavData results = doHttpUrlConnectionAction(myUrl);
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
	private ParentDeliveryBhavData doHttpUrlConnectionAction(String desiredUrl) throws Exception {
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
			ParentDeliveryBhavData parentDeliveryBhavData = new ParentDeliveryBhavData();
			List<DeliveryBhavData> data = new LinkedList<DeliveryBhavData>();
			String line = null;
			while ((line = reader.readLine()) != null) {
				if (line.contains("EQ")) {
					DeliveryBhavData deliveryBhavData = new DeliveryBhavData();
					String values[] = line.split("\\,");
					
					deliveryBhavData.setSymbol(values[0]);
					deliveryBhavData.setSeries(values[1]);
					deliveryBhavData.setDate(values[2]);
					deliveryBhavData.setPreClose(values[3]);
					deliveryBhavData.setOpenPrice(values[4]);
					
					deliveryBhavData.setHighPrice(values[5]);
					deliveryBhavData.setLowPrice(values[6]);
					deliveryBhavData.setLastPrice(values[7]);
					deliveryBhavData.setClosePrice(values[8]);
					deliveryBhavData.setAvgPrice(values[9]);
					String temp123 = values[5];
					deliveryBhavData.setTotalTradedQnty(values[10]);
					
					deliveryBhavData.setTurnOvrLac(values[11]);
					deliveryBhavData.setNoOfTrades(values[12]);
					deliveryBhavData.setDelivQnty(values[13]);
					deliveryBhavData.setDelivPer(values[14]);
					String temp = values[13];
					if (temp != null && temp.length() > 0) {
						Long delivQntyFilter = Long.parseLong(temp.trim());
						if (delivQntyFilter > 10000)
							data.add(deliveryBhavData);
					}
				}
			}
			parentDeliveryBhavData.setData(data);
			return parentDeliveryBhavData;
		} catch (Exception e) {
			e.printStackTrace();
			return new ParentDeliveryBhavData();

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
