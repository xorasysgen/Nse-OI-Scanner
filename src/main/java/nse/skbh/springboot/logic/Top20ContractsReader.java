package nse.skbh.springboot.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import nse.skbh.springboot.pojo.ParentTop20Contract;
import nse.skbh.springboot.pojo.Top20Contract;




class Top20ContractsReaderComparator implements Comparator<Top20Contract>{
	
	@Override
	public int compare(Top20Contract o1, Top20Contract o2) {
		// TODO Auto-generated method stub
		boolean t=Float.parseFloat(o1.getPremiumTurnoverLacs().replace(",", ""))<Float.parseFloat(o2.getPremiumTurnoverLacs().replace(",", ""));
		if(t) {
		return 1;
		}
		else
			return -1;
	}
}


public class Top20ContractsReader {

	@SuppressWarnings("unused")
	public static ParentTop20Contract getTop20ContractsNSE() {
		String url = "https://www1.nseindia.com/live_market/dynaContent/live_watch/fomktwtch_top20Contrct.htm";
		Document doc = null;
		ParentTop20Contract parentTop20Contract=new ParentTop20Contract();
		List<Top20Contract> data=new ArrayList<Top20Contract>();
		try {
			doc = Jsoup.connect(url).userAgent("Mozilla/5.0").get();
			Element content = doc.getElementById("myTable");
			/*System.out.println(content.getAllElements().size());*/
	
			for (Element table : doc.select("table")) { //this will work if your doc contains only one table element
				Elements row = table.select("tr");
			for (int i = 1; i < row.size()-1; i++) {
				String rowValues=row.get(i).text();
				if(rowValues.contains("-")) {
					//System.out.println(rowValues);
					continue;
				}
					else {
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
			}
			return parentTop20Contract;
		} catch (Exception e) {
			e.printStackTrace();
			return new ParentTop20Contract();
		}

	}
	
	private static String convertOptionType(String target) {
		if(target.equalsIgnoreCase("PE"))
			return "CE";
		else if(target.equalsIgnoreCase("CE"))
			return "PE";
		return "";
		
	}
	
	public static Map<String,String> bankNiftyOptionFinder(){
		Map<String,String> filter=new LinkedHashMap<>();
		List<Top20Contract> t=Top20ContractsReader.getTop20ContractsNSE().getData();
		
		if(t!=null) {
			String optionType=convertOptionType(t.get(0).getOptionType());
			String strikePrice=t.get(0).getStrikePrice().replaceAll("\\,", "").split("\\.")[0];
			filter.put("1", strikePrice.concat("-").concat(optionType));
			}
			if(t!=null) {
				String optionType=convertOptionType(t.get(1).getOptionType());
				String strikePrice=t.get(1).getStrikePrice().replaceAll("\\,", "").split("\\.")[0];
				filter.put("2", strikePrice.concat("-").concat(optionType));
			}
			if(t!=null) {
				String optionType=convertOptionType(t.get(2).getOptionType());
				String strikePrice=t.get(2).getStrikePrice().replaceAll("\\,", "").split("\\.")[0];
				filter.put("3", strikePrice.concat("-").concat(optionType));
			}
			if(t!=null) {
				String optionType=convertOptionType(t.get(3).getOptionType());
				String strikePrice=t.get(3).getStrikePrice().replaceAll("\\,", "").split("\\.")[0];
				filter.put("4	", strikePrice.concat("-").concat(optionType));
			}
		
		return filter;
		
	}
	
	public static Map<String,String> bankNiftyOptionFinderNonExpiryDay(){
		Map<String,String> filter=new LinkedHashMap<>();
		ParentTop20Contract parentTop20Contract=Top20ContractsReader.getTop20ContractsNSE();
		List<Top20Contract> data=parentTop20Contract.getData();
		Collections.sort(data, new Top20ContractsReaderComparator());
		parentTop20Contract.setData(data);
		
		List<Top20Contract> t=data;
		
		if(t!=null) {
			String optionType=t.get(0).getOptionType();
			String strikePrice=t.get(0).getStrikePrice().replaceAll("\\,", "").split("\\.")[0];
			filter.put("1", strikePrice.concat("-").concat(optionType));
			}
			if(t!=null) {
				String optionType=t.get(1).getOptionType();
				String strikePrice=t.get(1).getStrikePrice().replaceAll("\\,", "").split("\\.")[0];
				filter.put("2", strikePrice.concat("-").concat(optionType));
			}
			if(t!=null) {
				String optionType=t.get(2).getOptionType();
				String strikePrice=t.get(2).getStrikePrice().replaceAll("\\,", "").split("\\.")[0];
				filter.put("3", strikePrice.concat("-").concat(optionType));
			}
			if(t!=null) {
				String optionType=t.get(3).getOptionType();
				String strikePrice=t.get(3).getStrikePrice().replaceAll("\\,", "").split("\\.")[0];
				filter.put("4	", strikePrice.concat("-").concat(optionType));
			}
		
		return filter;
		
	}
	
	
	public static Map<String,String> bankNiftyOptionaAggressiveFinder(){
		Map<String,String> filter=new LinkedHashMap<>();
		List<Top20Contract> t=Top20ContractsReader.getTop20ContractsNSE().getData();
		
		if(t!=null) {
			String optionType=(t.get(0).getOptionType());
			String strikePrice=t.get(0).getStrikePrice().replaceAll("\\,", "").split("\\.")[0];
			filter.put("1", strikePrice.concat("-").concat(optionType));
			}
			if(t!=null) {
				String optionType=(t.get(1).getOptionType());
				String strikePrice=t.get(1).getStrikePrice().replaceAll("\\,", "").split("\\.")[0];
				filter.put("2", strikePrice.concat("-").concat(optionType));
			}
			if(t!=null) {
				String optionType=(t.get(2).getOptionType());
				String strikePrice=t.get(2).getStrikePrice().replaceAll("\\,", "").split("\\.")[0];
				filter.put("3", strikePrice.concat("-").concat(optionType));
			}
			if(t!=null) {
				String optionType=(t.get(3).getOptionType());
				String strikePrice=t.get(3).getStrikePrice().replaceAll("\\,", "").split("\\.")[0];
				filter.put("4	", strikePrice.concat("-").concat(optionType));
			}
		
		return filter;
		
	}
public static void main(String[] args) {
	System.out.println(bankNiftyOptionaAggressiveFinder());
}
		
}
