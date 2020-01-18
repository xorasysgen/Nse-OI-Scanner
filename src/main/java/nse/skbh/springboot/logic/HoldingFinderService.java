package nse.skbh.springboot.logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import nse.skbh.springboot.logic.RestTemplateProvider;
import nse.skbh.springboot.logic.Utils;
import nse.skbh.springboot.pojo.Holdings;
import nse.skbh.springboot.pojo.IndicesData;
import nse.skbh.springboot.pojo.ParentIndicesData;
import nse.skbh.springboot.pojo.ParentsHoldings;

public class HoldingFinderService {

	
	public ParentsHoldings getNIFTY50Top10HoldingsDateFile() {
		String dateForFile=Utils.getNIFTY50Top10HoldingsDateFormatddMMyy();
		try {
			String myUrl = "https://www1.nseindia.com/content/indices/top10nifty50_" + dateForFile +".csv";
			// if your url can contain weird characters you will want to
			// encode it here, something like this:
			// myUrl = URLEncoder.encode(myUrl, "UTF-8");

			ParentsHoldings results = doHttpUrlConnectionAction(myUrl);
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
	private ParentsHoldings doHttpUrlConnectionAction(String desiredUrl) throws Exception {
		URL url = null;
		BufferedReader reader = null;

		try {
			// create the HttpURLConnection
			url = new URL(desiredUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.addRequestProperty("User-Agent", "Mozilla/5.0");
			// just want to do an HTTP GET here
			connection.setRequestMethod("GET");

			// uncomment this if you want to write output to this url
			// connection.setDoOutput(true);

			// give it 15 seconds to respond
			connection.setReadTimeout(15 * 1000);
			connection.connect();

			// read the output from the server
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			ParentsHoldings parentsHoldings=new ParentsHoldings();
			List<Holdings> data = new LinkedList<Holdings>();
			String line = null;
			int i=0;
			while ((line = reader.readLine()) != null) {
				if (i++==0)
					continue;
					
					Holdings holdings = new Holdings();
					String values[] = line.split("\\,");
					holdings.setSymbol(values[0]);
					holdings.setSecurity(values[1]);
					holdings.setWeightage(values[2]);
					data.add(holdings);
				}
			parentsHoldings.setData(data);
			return parentsHoldings;
		} catch (Exception e) {
			e.printStackTrace();
			return new ParentsHoldings();

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
	
	
	
	public Map<String,String> getTempCalulationNIFTY50Top10HoldingsDateFile() {
		String dateForFile=Utils.getNIFTY50Top10HoldingsDateFormatddMMyy();
		try {
			String myUrl = "https://www1.nseindia.com/content/indices/top10nifty50_" + dateForFile +".csv";
			// if your url can contain weird characters you will want to
			// encode it here, something like this:
			// myUrl = URLEncoder.encode(myUrl, "UTF-8");

			Map<String,String> results = doHttpUrlConnection(myUrl);
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
	private Map<String,String> doHttpUrlConnection(String desiredUrl) throws Exception {
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
			String line = null;
			Map<String,String> map=new LinkedHashMap<String,String>();
			int i=0;
			while ((line = reader.readLine()) != null) {
				if (i++==0)
					continue;
					String values[] = line.split("\\,");
					map.put(values[0], values[2]);
				}
			return map;
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
	
	
	
	public static void main(String[] args) {
		//System.out.println(new Gson().toJson(new ServiceTest().getNIFTY50Top10HoldingsDateFile()));
		Map<String,String> map=new HoldingFinderService().getTempCalulationNIFTY50Top10HoldingsDateFile();
		RestTemplate restTemplate = new RestTemplateProvider().getRestTemplate();
		ResponseEntity<ParentIndicesData> response = restTemplate.getForEntity(
				"https://www1.nseindia.com/live_market/dynaContent/live_watch/stock_watch/niftyStockWatch.json",
				ParentIndicesData.class);
		
		
		
		ParentIndicesData parentIndicesData = response.getBody();
		List<IndicesData> data=parentIndicesData.getData();
		List<IndicesData> newData=new ArrayList<IndicesData>();
		for (Iterator<IndicesData> iterator = data.iterator(); iterator.hasNext();) {
			IndicesData indicesData = (IndicesData) iterator.next();
			String w=map.get(indicesData.getSymbol());
			if(w!=null) {
				indicesData.setWeightage(w.trim());
				newData.add(indicesData);
			}
			
		}
		parentIndicesData.setData(newData);
		System.out.println(new Gson().toJson(parentIndicesData));
	}

	
}
