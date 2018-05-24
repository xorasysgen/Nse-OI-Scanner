package nse.skbh.springboot.logic;

import java.io.IOException;
import java.text.DecimalFormat;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import nse.skbh.springboot.pojo.Pcr;

public class OptionChainReader {

	public static Pcr getOptionDataPCR() {
		String url = "https://www.nseindia.com/live_market/dynaContent/live_watch/option_chain/optionKeys.jsp?symbol=NIFTY&instrument=-&date=-";
		Document doc = null;
		try {
			doc = Jsoup.connect(url).get();
			Elements content = doc.getElementsByClass("nobg");
			if (content != null && content.size() > 0) {
				Integer lastIndex = content.size() - 1;
				String oi_puts = (content.get(lastIndex - 0).text());
				String puts_volume = (content.get(lastIndex - 1).text());
				String calls_volume = (content.get(lastIndex - 2).text());
				String oi_calls = (content.get(lastIndex - 3).text());

				oi_puts = oi_puts != null ? oi_puts.replace(",", "") : "0";
				puts_volume = puts_volume != null ? puts_volume.replace(",", "") : "0";
				calls_volume = calls_volume != null ? calls_volume.replace(",", "") : "0";
				oi_calls = oi_calls != null ? oi_calls.replace(",", "") : "0";

				DecimalFormat df = new DecimalFormat("#.##");
				Pcr pcr = new Pcr();
				pcr.setPuts(oi_puts);
				pcr.setPutsVolume(puts_volume);
				pcr.setCallsVolume(calls_volume);
				pcr.setCalls(oi_calls);
				pcr.setPcrOI(df.format(Double.parseDouble(oi_puts) / Double.parseDouble(oi_calls)));
				pcr.setPcrVolume(df.format(Double.parseDouble(puts_volume) / Double.parseDouble(calls_volume)));
				return pcr;
			}
		} catch (IOException e) {
			e.printStackTrace();
			return new Pcr();
		}
		return null;

	}
}
