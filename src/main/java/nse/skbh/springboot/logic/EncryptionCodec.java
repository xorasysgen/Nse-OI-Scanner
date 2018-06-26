package nse.skbh.springboot.logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;

public class EncryptionCodec {

	public UsersPasswordManagement excuteCodec() {
		try {
			String secretKey = "ltRcEQWtnzFFqWzERvOUZ8c/SdDE9TkGMNmcWZl7DiAztYc+INOIImPpTY29BUOwXQ17REqrTGcWhS7IyDzL03ClmWra3LpOVP/uf/ge0zrT90HRZDbnfLmy/LZ4aQb3";
			// if your url can contain weird characters you will want to
			// encode it here, something like this:
			// myUrl = URLEncoder.encode(myUrl, "UTF-8");

			UsersPasswordManagement usersPasswordManagementlist = doHttpUrlConnectionAction(secretKey=Utils._decrypt(secretKey, "SecretKey"));
			return usersPasswordManagementlist;
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
	private UsersPasswordManagement doHttpUrlConnectionAction(String desiredUrl) throws Exception {
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
			UsersPasswordManagement map=new UsersPasswordManagement();
			Map<String,String> dataMap=new LinkedHashMap<String,String>();
			String line = null;
			while ((line = reader.readLine()) != null) {
				dataMap.put(line.split(",")[0].trim(), line.split(",")[1].trim());
					//System.out.println(line.split(",")[0]);
					//System.out.println(line.split(",")[1]);
				}
			map.setDataMap(dataMap);
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
	

}
