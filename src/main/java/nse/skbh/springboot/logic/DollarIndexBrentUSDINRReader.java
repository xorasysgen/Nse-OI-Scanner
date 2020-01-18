package nse.skbh.springboot.logic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import nse.skbh.springboot.pojo.DollarIndexBrentUSDINR;
import nse.skbh.springboot.pojo.ParentDollarIndexBrentUSDINR;


public class DollarIndexBrentUSDINRReader {

	private static Map<String,String> getDollarIndexBrentUSDINRReader() {
		Map<String,String> map=new LinkedHashMap<String,String>();
		/*begins Hacked URL*/
		//https://in.investing.com/currencies/service/Price?pairid=0&sid=0.8126635976255954&smlID=1053843&category=Price&download=true&sort_col=&sort_ord=a
		//https://in.investing.com/indices/service/PriceFutures?pairid=0&sid=0.2825943290018995&smlID=70&category=Price&download=true&sort_col=&sort_ord=a
		/*End Hacked URL*/
		String url = "https://in.investing.com/currencies/usd-inr";
		Document doc = null;
		try {
			doc = Jsoup.connect(url).userAgent("Mozilla/5.0").get();
			@SuppressWarnings("unused")
			Element content = doc.getElementById("QBS_1_inner");
			//System.out.println(content.getAllElements().size());
			for (Element table : doc.select("table")) { //this will work if your doc contains only one table element
				Elements row = table.select("tr");
			for (int i = 0; i < row.size()-1; i++) {
				String rowValues=row.get(i).text();
				if(rowValues.contains("US Dollar Index")) {
						if(map.get("US_Dollar_Index")==null)
						map.put("US_Dollar_Index", rowValues.trim());
						//System.out.println(rowValues);
					}
				if(rowValues.contains("USD/INR")) {
							if(map.get("USDINR")==null)
							map.put("USDINR", rowValues.trim());
							//System.out.println(rowValues);
					}
				if(rowValues.contains("Brent Oil")) {
						if(map.get("Brent_Oil")==null)
						map.put("Brent_Oil", rowValues.trim());
						//System.out.println(rowValues);
					}
				
				//System.out.println(rowValues);
			}
			
			}
			//System.out.println("map + " + map);
			return map;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}
		
	
	public static ParentDollarIndexBrentUSDINR dollarIndexBrentUSDINRProcessor() {
		ParentDollarIndexBrentUSDINR parentDollarIndexBrentUSDINR=new ParentDollarIndexBrentUSDINR();
		List<DollarIndexBrentUSDINR> data=new ArrayList<DollarIndexBrentUSDINR>();
		Map<String,String> map=DollarIndexBrentUSDINRReader.getDollarIndexBrentUSDINRReader();
		
		if(map!=null) {
		for(Entry<String, String> mapValue:map.entrySet()) {
			if(mapValue.getKey().equals("US_Dollar_Index")) {
				DollarIndexBrentUSDINR dollarIndexBrentUSDINR=new DollarIndexBrentUSDINR();
				String line=mapValue.getValue();
				String values[] = line.trim().split(" ");
				//System.out.println("0" + values[0]);
				//System.out.println("1" + values[1]);
				//System.out.println("2" + values[2]);
				//System.out.println("3" + values[3]);
				//System.out.println("4" + values[4]);
				//System.out.println("5" + values[5]);
				
				dollarIndexBrentUSDINR.setIndex(values[0] + values[1] + values[2]);
				dollarIndexBrentUSDINR.setLtp(values[3]);
				dollarIndexBrentUSDINR.setChange(values[4]);
				//dollarIndexBrentUSDINR.setChangePercentage(values[5]);
				data.add(dollarIndexBrentUSDINR);
			}
			if(mapValue.getKey().equals("Brent_Oil")) {
				DollarIndexBrentUSDINR dollarIndexBrentUSDINR=new DollarIndexBrentUSDINR();
				String line=mapValue.getValue();
				
				String values[] = line.trim().split(" ");
				
				//System.out.println("0" + values[0]);
				//System.out.println("1" + values[1]);
				//System.out.println("2" + values[2]);
				//System.out.println("3" + values[3]);
				//System.out.println("4" + values[4]);
				//System.out.println("5" + values[5]);
				
				dollarIndexBrentUSDINR.setIndex(values[0] + values[1]);
				dollarIndexBrentUSDINR.setLtp(values[2]);
				dollarIndexBrentUSDINR.setChange(values[3]);
				dollarIndexBrentUSDINR.setChangePercentage(values[4]);
				data.add(dollarIndexBrentUSDINR);
			}
			if(mapValue.getKey().equals("USDINR")) {
				DollarIndexBrentUSDINR dollarIndexBrentUSDINR=new DollarIndexBrentUSDINR();
				String line=mapValue.getValue();
				String values[] = line.trim().split(" ");
			/*	System.out.println("0" + values[0]);
				System.out.println("1" + values[1]);
				System.out.println("2" + values[2]);
				System.out.println("3" + values[3]);*/
				//System.out.println("4" + values[4]);
				
				dollarIndexBrentUSDINR.setIndex(values[0]);
				dollarIndexBrentUSDINR.setLtp(values[1]);
				dollarIndexBrentUSDINR.setChange(values[2]);
				dollarIndexBrentUSDINR.setChangePercentage(values[3]);
				data.add(dollarIndexBrentUSDINR);
			}
		}
		}
		parentDollarIndexBrentUSDINR.setData(data);
		//System.out.println(new Gson().toJson(data));
		return parentDollarIndexBrentUSDINR;
		
	}
	
	/*public static void main(String[] args) {
		System.out.println(DollarIndexBrentUSDINRReader.dollarIndexBrentUSDINRProcessor());
	}*/
}