package nse.skbh.springboot.logic;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import nse.skbh.springboot.pojo.ParentTop20Contract;
import nse.skbh.springboot.pojo.Top20Contract;


public class Nifty50Options {

	@SuppressWarnings("unused")
	public static ParentTop20Contract getNifty50OOptionsContractsNSE() {
		String url = "https://www1.nseindia.com/live_market/dynaContent/live_watch/fomktwtch_OPTIDXNIFTY.htm";
		Document doc = null;
		ParentTop20Contract parentTop20Contract=new ParentTop20Contract();
		List<Top20Contract> data=new ArrayList<Top20Contract>();
		try {
			doc = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(10*1000).get();
			Element content = doc.getElementById("myTable");
			/*System.out.println(content.getAllElements().size());*/
	
			for (Element table : doc.select("table")) { //this will work if your doc contains only one table element
				Elements row = table.select("tr");
			for (int i = 1; i < row.size()-1; i++) {
				String rowValues=row.get(i).text();
				/*System.out.println(rowValues);*/
				Top20Contract oi=new Top20Contract();
				String dataValue[]=rowValues.split("\\s+");
						 oi.setInstrumentType(dataValue[0] + dataValue[1]);
						 oi.setUnderlying(dataValue[2]);
						 oi.setExpiryDate(dataValue[3]);
						 oi.setOptionType(dataValue[4]);
						 oi.setStrikePrice(dataValue[5]);
						 oi.setPrevClose(dataValue[6]);
						 oi.setOpenPrice(dataValue[7]);
						 oi.setHighPrice(dataValue[8]);
						 oi.setLowPrice(dataValue[9]);
						 oi.setLastPrice(dataValue[10]);
						 oi.setVolumeContracts(dataValue[11]);
						 oi.setTurnoverLacs(dataValue[12]);
						 oi.setPremiumTurnoverLacs(dataValue[13]);
						 oi.setUnderlyingValue(dataValue[14]);
						 data.add(oi);
			}
			
			parentTop20Contract.setData(data);
			}
			return parentTop20Contract;
		} catch (Exception e) {
			e.printStackTrace();
			return new ParentTop20Contract();
		}

	}
	
		
}
