package nse.skbh.springboot.logic;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import nse.skbh.springboot.pojo.OI;
import nse.skbh.springboot.pojo.ParentsOI;
import nse.skbh.springboot.pojo.Pcr;

public class BankNiftyOptionChainReader {

	public static ParentsOI getBankNiftyOptionChain() {
		String url = "https://www.nseindia.com/live_market/dynaContent/live_watch/option_chain/optionKeys.jsp?symbol=BANKNIFTY&instrument=-&date=-";
		Document doc = null;
		ParentsOI parentsOI=new ParentsOI();
		List<OI> data=new ArrayList<OI>();
		try {
			doc = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(10*1000).get();
			for (Element table : doc.select("table")) { //this will work if your doc contains only one table element
				Elements row = table.select("tr");
						for (int i = 10; i < row.size()-1; i++) {
							String rowValues=row.get(i).text();
							//System.out.println(rowValues);
							OI oi=new OI();
							String dataValue[]=rowValues.split("\\s+");
									 oi.setOi_call(dataValue[0]);
									 oi.setChng_in_oi_call(dataValue[1]);
									 oi.setVolume_call(dataValue[2]);
									 oi.setIv_call(dataValue[3]);
									 oi.setLtp_call(dataValue[4]);
									 oi.setNet_chng_call(dataValue[5]);
									 oi.setBid_qty_call(dataValue[6]);
									 oi.setBid_price_call(dataValue[7]);
									 oi.setAsk_price_call(dataValue[8]);
									 oi.setAsk_qty_call(dataValue[9]);
									 oi.setStrikePrice(dataValue[10]);
									 oi.setBid_qty_put(dataValue[11]);
									 oi.setBid_price_put(dataValue[12]);
									 oi.setAsk_price_put(dataValue[13]);
									 oi.setAsk_qty_put(dataValue[14]);
									 oi.setNet_chng_put(dataValue[15]);
									 oi.setLtp_put(dataValue[16]);
									 oi.setIv_put(dataValue[17]);
									 oi.setVolume_put(dataValue[18]);
									 oi.setChng_in_oi_put(dataValue[19]);
									 oi.setOi_put(dataValue[20]);
									 data.add(oi);
						}//Elements row end
			
			parentsOI.setData(data);
				  
			}
			return parentsOI;
		} catch (IOException e) {
			e.printStackTrace();
			return new ParentsOI();
		}

	}
	
	public static Pcr getBankNiftyOptionDataPCR() {
		String url = "https://www.nseindia.com/live_market/dynaContent/live_watch/option_chain/optionKeys.jsp?symbol=BANKNIFTY&instrument=-&date=-";
		Document doc = null;
		try {
			doc = Jsoup.connect(url).
					userAgent("Mozilla/5.0").get();
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

				try{
				DecimalFormat df = new DecimalFormat("#.##");
				
				Pcr pcr = new Pcr();
				pcr.setPuts(oi_puts);
				pcr.setPutsVolume(puts_volume);
				pcr.setCallsVolume(calls_volume);
				pcr.setCalls(oi_calls);
				pcr.setPcrOI(df.format(Double.parseDouble(oi_puts) / Double.parseDouble(oi_calls)));
				pcr.setPcrVolume(df.format(Double.parseDouble(puts_volume) / Double.parseDouble(calls_volume)));
				return pcr;
				}catch(RuntimeException e) {
					 return new Pcr();
					}
				}
		} catch (IOException e) {
			e.printStackTrace();
			return new Pcr();
		}
		return null;

	}
}
