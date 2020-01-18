package nse.skbh.springboot.logic;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import nse.skbh.springboot.pojo.OI;
import nse.skbh.springboot.pojo.ParentPcr;
import nse.skbh.springboot.pojo.ParentsOI;
import nse.skbh.springboot.pojo.ParentsStocksOI;
import nse.skbh.springboot.pojo.Pcr;
import nse.skbh.springboot.pojo.PcrDetail;

public class OptionChainReader {

	public static ParentsOI getNiftyOptionChain() {
		String url = "https://www1.nseindia.com/live_market/dynaContent/live_watch/option_chain/optionKeys.jsp?symbol=NIFTY&instrument=-&date=-";
		Document doc = null;
		ParentsOI parentsOI=new ParentsOI();
		List<OI> data=new ArrayList<OI>();
		try {
			doc = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(10*1000).get();
			for (Element table : doc.select("table")) { //this will work if your doc contains only one table element
				Elements row = table.select("tr");
						for (int i = 2; i < row.size()-1; i++) { // set 2 to start from default
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
	
	public static Pcr getOptionDataPCR() {
		String url = "https://www1.nseindia.com/live_market/dynaContent/live_watch/option_chain/optionKeys.jsp?symbol=NIFTY&instrument=-&date=-";
		Document doc = null;
		try {
			doc = Jsoup.connect(url).userAgent("Mozilla/5.0").get();
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
	
	public static ParentPcr getThreeMonthOptionDataPCR() {
		List<String> listOfDate= LastThursdayOfEveryMonth.getNextExpiryOfEveryMonth();
		String firstMonth=listOfDate.get(0);
		String secondMonth=listOfDate.get(1);
		String thirdMonth=listOfDate.get(2);
		
		List<PcrDetail> pcrList=new LinkedList<PcrDetail>();
		String url1 = "https://www1.nseindia.com/live_market/dynaContent/live_watch/option_chain/optionKeys.jsp?segmentLink=17&instrument=OPTIDX&symbol=NIFTY&date=" +firstMonth;
		Document doc = null;
		try {
			doc = Jsoup.connect(url1).get();
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
				
				PcrDetail pcr = new PcrDetail();
				pcr.setMonth(firstMonth);
				pcr.setPuts(oi_puts);
				pcr.setPutsVolume(puts_volume);
				pcr.setCallsVolume(calls_volume);
				pcr.setCalls(oi_calls);
				pcr.setPcrOI(df.format(Double.parseDouble(oi_puts) / Double.parseDouble(oi_calls)));
				pcr.setPcrVolume(df.format(Double.parseDouble(puts_volume) / Double.parseDouble(calls_volume)));
				pcrList.add(pcr);
				}catch(RuntimeException e) {
					 return null;
					}
				}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
		
		String url2 = "https://www1.nseindia.com/live_market/dynaContent/live_watch/option_chain/optionKeys.jsp?segmentLink=17&instrument=OPTIDX&symbol=NIFTY&date="+secondMonth;
		try {
			doc = Jsoup.connect(url2).get();
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
				
				PcrDetail pcr = new PcrDetail();
				pcr.setMonth(secondMonth);
				pcr.setPuts(oi_puts);
				pcr.setPutsVolume(puts_volume);
				pcr.setCallsVolume(calls_volume);
				pcr.setCalls(oi_calls);
				pcr.setPcrOI(df.format(Double.parseDouble(oi_puts) / Double.parseDouble(oi_calls)));
				pcr.setPcrVolume(df.format(Double.parseDouble(puts_volume) / Double.parseDouble(calls_volume)));
				pcrList.add(pcr);
				}catch(RuntimeException e) {
					 return null;
					}
				}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
		
		String url3 = "https://www1.nseindia.com/live_market/dynaContent/live_watch/option_chain/optionKeys.jsp?segmentLink=17&instrument=OPTIDX&symbol=NIFTY&date=" + thirdMonth;
		try {
			doc = Jsoup.connect(url3).get();
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
				
				PcrDetail pcr = new PcrDetail();
				pcr.setMonth(thirdMonth);
				pcr.setPuts(oi_puts);
				pcr.setPutsVolume(puts_volume);
				pcr.setCallsVolume(calls_volume);
				pcr.setCalls(oi_calls);
				pcr.setPcrOI(df.format(Double.parseDouble(oi_puts) / Double.parseDouble(oi_calls)));
				pcr.setPcrVolume(df.format(Double.parseDouble(puts_volume) / Double.parseDouble(calls_volume)));
				pcrList.add(pcr);
				}catch(RuntimeException e) {
					 return null;
					}
				}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		Long calls=new Long(0);
		Long puts=new Long(0);
		Long callsVolume=new Long(0);
		Long putsVolume=new Long(0);
		
		for (PcrDetail pcr : pcrList) {
			calls=Long.parseLong(pcr!=null? pcr.getCalls(): "0") + calls;
			puts=Long.parseLong(pcr!=null?pcr.getPuts():"0") + puts;
			callsVolume=Long.parseLong(pcr!=null?pcr.getCallsVolume():"0") + callsVolume;
			putsVolume=Long.parseLong(pcr!=null?pcr.getPutsVolume():"0") + putsVolume;
		}
		DecimalFormat df = new DecimalFormat("#.##");
		Double d=Double.parseDouble(puts.toString()) / Double.parseDouble(calls.toString());
		String allPcr=d!=null? (d.toString().substring(0, 4)):"";
		PcrDetail pcr = new PcrDetail();
		pcr.setMonth("Combined Months");
		pcr.setPuts(puts.toString());
		pcr.setPutsVolume(putsVolume.toString());
		pcr.setCallsVolume(callsVolume.toString());
		pcr.setCalls(calls.toString());
		pcr.setPcrOI(allPcr);
		pcr.setPcrVolume(df.format(Double.parseDouble(putsVolume.toString()) / Double.parseDouble(callsVolume.toString())));
		pcrList.add(pcr);
		ParentPcr parentPcr=new ParentPcr();
		parentPcr.setData(pcrList);
		parentPcr.setOverAllPcr(allPcr);
		return parentPcr;

	}
	
	
	
	
	public static ParentsStocksOI getStockOptionChain(String name) {
		String url = "https://www1.nseindia.com/live_market/dynaContent/live_watch/option_chain/optionKeys.jsp?symbolCode=&symbol="
				+name + "&symbol="+name+"&instrument=-&date=-&segmentLink=17&symbolCount=2&segmentLink=17";
		Document doc = null;
		ParentsStocksOI parentsStocksOI=new ParentsStocksOI();
		List<OI> data=new ArrayList<OI>();
		try {
			doc = Jsoup.connect(url).userAgent("Mozilla/5.0").get();
			for (Element table : doc.select("table")) { //this will work if your doc contains only one table element
				Elements row = table.select("tr");
				int i=3;
						for (; i < row.size()-1; i++) {
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
				
						parentsStocksOI.setData(data);
			}
			try {
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
					
					PcrDetail pcr = new PcrDetail();
					pcr.setMonth("Current");
					pcr.setPuts(oi_puts);
					pcr.setPutsVolume(puts_volume);
					pcr.setCallsVolume(calls_volume);
					pcr.setCalls(oi_calls);
					pcr.setPcrOI(df.format(Double.parseDouble(oi_puts) / Double.parseDouble(oi_calls)));
					pcr.setPcrVolume(df.format(Double.parseDouble(puts_volume) / Double.parseDouble(calls_volume)));
					//System.out.println(pcr);
					parentsStocksOI.setPcr(pcr);//setting PCR
					}catch(RuntimeException e) {
						 return null;
						}
					}
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			return parentsStocksOI;
		} catch (IOException e) {
			e.printStackTrace();
			return new ParentsStocksOI();
		}

	}
	
	
	
	public static ParentsStocksOI getNiftyWeeklyOptionChain(String date) {
		//https://www.nseindia.com/live_market/dynaContent/live_watch/option_chain/optionKeys.jsp?segmentLink=17&instrument=OPTIDX&symbol=NIFTY&date=14FEB2019
		String url = "https://www1.nseindia.com/live_market/dynaContent/live_watch/option_chain/optionKeys.jsp?"
				+ "segmentLink=17&instrument=OPTIDX&symbol=NIFTY&date="+date;
		Document doc = null;
		ParentsStocksOI parentsStocksOI=new ParentsStocksOI();
		List<OI> data=new ArrayList<OI>();
		try {
			doc = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(10*1000).get();
			for (Element table : doc.select("table")) { //this will work if your doc contains only one table element
				Elements row = table.select("tr");
				int i=3;
						for (; i < row.size()-1; i++) {
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
				
						parentsStocksOI.setData(data);
			}
			try {
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
					
					PcrDetail pcr = new PcrDetail();
					pcr.setMonth("Current");
					pcr.setPuts(oi_puts);
					pcr.setPutsVolume(puts_volume);
					pcr.setCallsVolume(calls_volume);
					pcr.setCalls(oi_calls);
					pcr.setPcrOI(df.format(Double.parseDouble(oi_puts) / Double.parseDouble(oi_calls)));
					pcr.setPcrVolume(df.format(Double.parseDouble(puts_volume) / Double.parseDouble(calls_volume)));
					//System.out.println(pcr);
					parentsStocksOI.setPcr(pcr);//setting PCR
					}catch(RuntimeException e) {
						 return null;
						}
					}
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			return parentsStocksOI;
		} catch (IOException e) {
			e.printStackTrace();
			return new ParentsStocksOI();
		}

	}
	
	
	


	public static ParentsStocksOI getBankNiftyWeeklyOptionChain(String date) {
		//https://www.nseindia.com/live_market/dynaContent/live_watch/option_chain/optionKeys.jsp?segmentLink=17&instrument=OPTIDX&symbol=NIFTY&date=14FEB2019
				String url = "https://www1.nseindia.com/live_market/dynaContent/live_watch/option_chain/optionKeys.jsp?"
						+ "segmentLink=17&instrument=OPTIDX&symbol=BANKNIFTY&date="+date;
				Document doc = null;
				ParentsStocksOI parentsStocksOI=new ParentsStocksOI();
				List<OI> data=new ArrayList<OI>();
				try {
					doc = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(10*1000).get();
					for (Element table : doc.select("table")) { //this will work if your doc contains only one table element
						Elements row = table.select("tr");
						int i=3;
								for (; i < row.size()-1; i++) {
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
						
								parentsStocksOI.setData(data);
					}
					try {
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
							
							PcrDetail pcr = new PcrDetail();
							pcr.setMonth("Current");
							pcr.setPuts(oi_puts);
							pcr.setPutsVolume(puts_volume);
							pcr.setCallsVolume(calls_volume);
							pcr.setCalls(oi_calls);
							pcr.setPcrOI(df.format(Double.parseDouble(oi_puts) / Double.parseDouble(oi_calls)));
							pcr.setPcrVolume(df.format(Double.parseDouble(puts_volume) / Double.parseDouble(calls_volume)));
							//System.out.println(pcr);
							parentsStocksOI.setPcr(pcr);//setting PCR
							}catch(RuntimeException e) {
								 return null;
								}
							}
					} catch (Exception e) {
						e.printStackTrace();
						return null;
					}
					return parentsStocksOI;
				} catch (IOException e) {
					e.printStackTrace();
					return new ParentsStocksOI();
				}

	}
	
	
	public static ParentsStocksOI getCurrencyWeeklyOptionChain(String date) {
		//https://www.nseindia.com/live_market/dynaContent/live_watch/fxTracker/optChainDataByExpDates.jsp?symbol=USDINR&instrument=OPTCUR&expiryDt=15FEB2019
				String url = "https://www1.nseindia.com/live_market/dynaContent/live_watch/fxTracker/optChainDataByExpDates.jsp?"
						+ "symbol=USDINR&instrument=OPTCUR&expiryDt="+date;
				Document doc = null;
				ParentsStocksOI parentsStocksOI=new ParentsStocksOI();
				List<OI> data=new ArrayList<OI>();
				try {
					doc = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(10*1000).get();
					for (Element table : doc.select("table#octable")) { //this will work if your doc contains only one table element
						Elements row = table.select("tr");
						//System.out.println(row.size());
						int i=2;
								for (; i < row.size()-1; i++) {
									String rowValues=row.get(i).text();
									//System.out.println(rowValues);
									OI oi=new OI();
									String dataValue[]=rowValues.split("\\s+");
											 oi.setOi_call(dataValue[0]);
											 oi.setChng_in_oi_call(dataValue[1]);
											 oi.setVolume_call(dataValue[2]);
											 oi.setIv_call(dataValue[3]);
											 oi.setLtp_call(dataValue[4]);
											 oi.setNet_chng_call("-");
											 oi.setBid_qty_call(dataValue[5]);
											 oi.setBid_price_call(dataValue[6]);
											 oi.setAsk_price_call(dataValue[7]);
											 oi.setAsk_qty_call(dataValue[8]);
											 oi.setStrikePrice(dataValue[9]);
											 oi.setBid_qty_put(dataValue[10]);
											 oi.setBid_price_put(dataValue[11]);
											 oi.setAsk_price_put(dataValue[12]);
											 oi.setAsk_qty_put(dataValue[13]);
											 oi.setLtp_put(dataValue[14]);
											 oi.setIv_put(dataValue[15]);
											 oi.setVolume_put(dataValue[16]);
											 oi.setChng_in_oi_put(dataValue[17]);
											 oi.setOi_put(dataValue[18]);
											 oi.setNet_chng_put("-");
											 data.add(oi);
								}//Elements row end
						
								parentsStocksOI.setData(data);
					}
					try {
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
							
							PcrDetail pcr = new PcrDetail();
							pcr.setMonth("Current");
							pcr.setPuts(oi_puts);
							pcr.setPutsVolume(puts_volume);
							pcr.setCallsVolume(calls_volume);
							pcr.setCalls(oi_calls);
							pcr.setPcrOI(df.format(Double.parseDouble(oi_puts) / Double.parseDouble(oi_calls)));
							pcr.setPcrVolume(df.format(Double.parseDouble(puts_volume) / Double.parseDouble(calls_volume)));
							//System.out.println(pcr);
							parentsStocksOI.setPcr(pcr);//setting PCR
							}catch(RuntimeException e) {
								 return null;
								}
							}
					} catch (Exception e) {
						e.printStackTrace();
						return null;
					}
					return parentsStocksOI;
				} catch (IOException e) {
					e.printStackTrace();
					return new ParentsStocksOI();
				}

	}
	public static void main(String[] args) {
		OptionChainReader.getCurrencyWeeklyOptionChain("22FEB2019");
	}
}
