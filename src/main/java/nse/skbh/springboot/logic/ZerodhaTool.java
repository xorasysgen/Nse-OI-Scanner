package nse.skbh.springboot.logic;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ZerodhaTool {

	public static String getZerodhaFuturesURL() {
		String url = "https://zerodha.com/margin-calculator/Futures/";
		Document doc = null;
		try {
			doc = Jsoup.connect(url).userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/40.0.2214.38 Safari/537.36").timeout(10*1000).get();
			Elements content = doc.getElementsByClass("text-small");
			if(content!=null) {
				String s=content.get(0).toString().concat("<br>").concat(content.get(1).toString());
				if(s.length()>10)
					return new StringBuilder(s).insert(s.indexOf("More information")-1, " target=\"_blank\"").toString();
				}
				return "Contact Developer Team";
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}
	
	/*public static void main(String[] args) {
		String s=ZerodhaTool.getZerodhaFuturesURL();
		if(s.length()>10) {
		new StringBuilder(s).insert(s.indexOf("More information")-1, " target=\"_blank\"").toString();
		}
	}*/
}