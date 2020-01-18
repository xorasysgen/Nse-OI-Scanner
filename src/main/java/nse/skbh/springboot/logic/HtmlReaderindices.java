package nse.skbh.springboot.logic;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import nse.skbh.springboot.pojo.ParentWorldFutureIndex;
import nse.skbh.springboot.pojo.WorldFutureIndex;


public class HtmlReaderindices {

	public static ParentWorldFutureIndex getParentWorldFutureIndex() {
		//https://in.investing.com/currencies/service/Price?pairid=0&sid=0.8126635976255954&smlID=1053843&category=Price&download=true&sort_col=&sort_ord=a
		//https://in.investing.com/indices/service/PriceFutures?pairid=0&sid=0.2825943290018995&smlID=70&category=Price&download=true&sort_col=&sort_ord=a
		String url = "https://www.investing.com/indices/indices-futures";
		Document doc = null;
		ParentWorldFutureIndex parentWorldFutureIndex=new ParentWorldFutureIndex();
		List<WorldFutureIndex> data=new LinkedList<WorldFutureIndex>();
		try {
			doc = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(20*1000).get();
			@SuppressWarnings("unused")
			Element content = doc.getElementById("cross_rate_1");
			//System.out.println(content.getAllElements().size());
		Elements table = doc.select("table");  //this will work if your doc contains only one table element
				Elements row = table.select("tr");
			for (int i = 1; i < row.size()-1; i++) {
				WorldFutureIndex wfi = new WorldFutureIndex();
				if(i==38)
					break;
			/*	if(rowValues.contains("US Dollar Index")) {System.out.println(rowValues);}
				if(rowValues.contains("USD/INR")) {System.out.println(rowValues);}
				if(rowValues.contains("Brent Oil")) {System.out.println(rowValues);}*/
				
				String rowValues=row.get(i).text();
					if(rowValues.contains("Dow") || 
					rowValues.contains("DAX") ||
					rowValues.contains("CAC 40") ||
					rowValues.contains("FTSE 100") ||
					rowValues.contains("Nikkei") ||
					rowValues.contains("Hang") ||
					rowValues.contains("Nifty") ||
					rowValues.contains("Bank") ||
					rowValues.contains("Euro Stoxx"))
						
				//System.out.println(i + "#" +rowValues);
					if(i==1 || i==2 || i==8 || i==9 || i==24 || i==22 || i==30 || i==31) {
				String dataValue[]=rowValues.split("\\s+");
		/*		System.out.println(dataValue[0]);
				System.out.println(dataValue[1]);
				System.out.println(dataValue[2]);
				System.out.println(dataValue[3]);
				System.out.println(dataValue[4]);
				System.out.println(dataValue[5]);
				System.out.println(dataValue[6]);
				System.out.println(dataValue[7]);
				System.out.println(dataValue[8]);
				System.out.println(dataValue[9]);*/
				
				wfi.setIndex(dataValue[0] + dataValue[1]);
				wfi.setMonth(dataValue[2] + dataValue[3]);
				wfi.setLtp(dataValue[4]);
				wfi.setHigh(dataValue[5]);
				wfi.setLow(dataValue[6]);
				wfi.setChg(dataValue[7]);
				wfi.setChgPer(dataValue[8]);
				wfi.setTime(dataValue[9]);
				data.add(wfi);
					}else if(i==10){
						String dataValue[]=rowValues.split("\\s+");
						//System.out.println("error" + rowValues);
						wfi.setIndex(dataValue[0] + dataValue[1] + dataValue[2]);
						wfi.setMonth(dataValue[3] + dataValue[4]);
						wfi.setLtp(dataValue[4]);
						wfi.setHigh(dataValue[5]);
						wfi.setLow(dataValue[6]);
						wfi.setChg(dataValue[7]);
						wfi.setChgPer(dataValue[8]);
						wfi.setTime(dataValue[9]);
						data.add(wfi);
					}else if(i==7 || i==6){
						String dataValue[]=rowValues.split("\\s+");
						wfi.setIndex(dataValue[0]);
						wfi.setMonth(dataValue[1] + dataValue[2]);
						wfi.setLtp(dataValue[3]);
						wfi.setHigh(dataValue[4]);
						wfi.setLow(dataValue[5]);
						wfi.setChg(dataValue[6]);
						wfi.setChgPer(dataValue[7]);
						wfi.setTime(dataValue[8]);
						data.add(wfi);
					}
				
			}
			parentWorldFutureIndex.setData(data);
			
			return parentWorldFutureIndex;
		} catch (IOException e) {
			e.printStackTrace();
			return new ParentWorldFutureIndex();
		}

	}
		
	/*public static void main(String[] args) {
	System.out.println(new Gson().toJson(HtmlReaderindices.getParentWorldFutureIndex()));	
	}*/

}