package nse.skbh.springboot.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class NiftyExpiryDatesNewContracts {
	public  static List<String> getNiftyExpiryDates() {
		String url = "https://www.nseindia.com/live_market/dynaContent/live_watch/option_chain/optionKeys.jsp?symbolCode=-10006&symbol=NIFTY&symbol=NIFTY&instrument=-&date=-&segmentLink=17&symbolCount=2&segmentLink=17";
		Document doc = null;
		try {
			doc = Jsoup.connect(url).userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/40.0.2214.38 Safari/537.36").timeout(15*1000).get();
			Elements content = doc.getElementsByClass("goodTextBox");
			if(content!=null && content.size()>1) {
			List<String> list=content.eachText();
			String value=list.get(1).replaceAll("Select", "").trim();
			//System.out.println(value);
			String[] values=value.split("\\s+");
			return Arrays.asList(values);
			}
			else {
				List<String> list= new ArrayList<String>();
				list.add("Error While Loading...");
				return list;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			List<String> list= new ArrayList<String>();
			list.add("Read time out while Loading...");
			return list;
		}

	}
}
