package nse.skbh.springboot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPInputStream;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

@Component
public class RestTemplateIssueResolver {

	public String CommonHttpDataFetcher(String uri) {
		String jsonCont=commonHttpConnectionDataFetcher(uri);
		return jsonCont;

	}
	
	public String commonHttpDataFetcherOld(String uri) {
		Document doc = null;
		try {
			Response response = Jsoup.connect(uri).
					ignoreContentType(true)
					.userAgent("Mozilla/5.0")
					.referrer("https://www1.nseindia.com")
					.timeout(15_000)
					.followRedirects(true)
					.execute();
			// TODO: verify Response status code here!
			doc = response.parse();
			String jsonCont = doc.text();
			return jsonCont;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}
	/*----------------------------------------------------------------------------------------
	public static void main(String[] args) {
		String uri="https://www1.nseindia.com//live_market/dynaContent/live_analysis/most_active/allBankNiftyVolume.json";
		System.out.println(new RestTemplateIssueResolver().commonHttpConnectionDataFetcher(uri));
	}
	
	*/
	
	public String commonHttpConnectionDataFetcher(String desiredUrl) {

		URL url = null;
		BufferedReader reader = null;
		HttpURLConnection connection=null;
		String line = null;
		try {
			// create the HttpURLConnection
			url = new URL(desiredUrl);
			 connection = (HttpURLConnection) url.openConnection();


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
			connection.setReadTimeout(30 * 1000);
			connection.connect();

			// read the output from the server
			GZIPInputStream gzip = new GZIPInputStream(connection.getInputStream());
			reader = new BufferedReader(new InputStreamReader(gzip));
			while ((line = reader.readLine()) != null) {
				if(line!=null && !line.isEmpty()) {
				break;
				}
			}
				//System.out.println("line" + line);
					if(line.length()>0) {
						return line;
					}
				
		} catch (Exception e) {
			e.printStackTrace();
			return null;

		} finally {
			if(connection!=null) {
			     connection.disconnect();
			}
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
		return null;
	
	}

}
