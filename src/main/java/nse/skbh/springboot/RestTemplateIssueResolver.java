package nse.skbh.springboot;

import java.io.IOException;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

@Component
public class RestTemplateIssueResolver {

	public String CommonHttpDataFetcher(String uri) {
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

}
