package nse.skbh.springboot.logic;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.gson.Gson;

import nse.skbh.springboot.pojo.DataPoints;
import nse.skbh.springboot.pojo.ParentsDataPoints;

public class NiftyAndBankNiftySupportResistance {
	private static DataPoints getNiftyAndBankNiftySupportResistance(String url) {
		Document doc = null;
		DataPoints dataPoints=new DataPoints();
		HashMap<String,Float> map=new HashMap<String,Float>();
		try {
			doc = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(10*1000).get();
				Element ltdElement = doc.getElementById("last_last");
				String ltp=ltdElement.html();
				ltp=ltp.replaceAll(",", "");
				Float ltp_float=Float.parseFloat(ltp);
				Element content = doc.getElementById("curr_table");
				Elements row =content.getAllElements();
				//System.out.println(row.text());
				String values=row.text();
				if(values!=null && values.length()>0) {
					int beginIndex=values.indexOf("Fibonacci");
					int endIndex=values.indexOf("Camarilla");
					String substr=values.substring(beginIndex, endIndex);
					dataPoints.setLtp(ltp);
					dataPoints.setName(substr.split("\\s+")[0]);
					dataPoints.setS3(substr.split("\\s+")[1]);
					dataPoints.setS2(substr.split("\\s+")[2]);
					dataPoints.setS1(substr.split("\\s+")[3]);
					dataPoints.setPivotPoints(substr.split("\\s+")[4]);
					dataPoints.setR1(substr.split("\\s+")[5]);
					dataPoints.setR2(substr.split("\\s+")[6]);
					dataPoints.setR3(substr.split("\\s+")[7]);
					map.put("s1", Math.abs(Float.parseFloat(dataPoints.getS1())-ltp_float));
					map.put("s2", Math.abs(Float.parseFloat(dataPoints.getS2())-ltp_float));
					map.put("s3", Math.abs(Float.parseFloat(dataPoints.getS3())-ltp_float));
					map.put("pivotPoints", Math.abs(Float.parseFloat(dataPoints.getPivotPoints())-ltp_float));
					map.put("r1", Math.abs(Float.parseFloat(dataPoints.getR1())-ltp_float));
					map.put("r2", Math.abs(Float.parseFloat(dataPoints.getR2())-ltp_float));
					map.put("r3", Math.abs(Float.parseFloat(dataPoints.getR3())-ltp_float));
					 Map<Object, Object> sortedMap= Utils.sortTwoStringKeyValueHashMapByValues(map);
					 Map.Entry<Object,Object> entry = sortedMap.entrySet().iterator().next();
					 String key = entry.getKey().toString();
					 dataPoints.setLtpDataPointcordinate(key);
					 //System.out.println("sorted" + sortedMap);
				}
				
			return dataPoints;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}
		
	
	
	
	private static Map<String, DataPoints> callWebserviceConcurrently(FutureTask<DataPoints>futureTask_Nifty, FutureTask<DataPoints> futureTask_BankNifty) {

		   ExecutorService executor = Executors.newCachedThreadPool();
		   Map<String,DataPoints> mapToBeRetruned=new HashMap<String,DataPoints>();
		   DataPoints _nifty = null,_bank = null;
		   try {
		   executor.execute(futureTask_Nifty);
		   executor.execute(futureTask_BankNifty);
		    while (true) {//let the Thread to continue operation and break when complete
				if (futureTask_Nifty.isDone() && futureTask_BankNifty.isDone()){ 
					try {
						_nifty = futureTask_Nifty.get();
								if(_nifty!=null)
									_nifty.setSymbol("Nifty50");
										else {
									_nifty=new DataPoints();
									_nifty.setSymbol("Nifty50");
								}
						_bank = futureTask_BankNifty.get();
								if(_bank!=null)
									_bank.setSymbol("BankNifty");
										else {
									_bank=new DataPoints();
									_bank.setSymbol("BankNifty");
								}
						
					} catch (InterruptedException | ExecutionException exceptionDataPoints) {
						// TODO Auto-generated catch block
						executor.shutdown();//shutdown the thread
						exceptionDataPoints.printStackTrace();
					}
					break;//breaking after completion
					
				}//checking the status of
		    }//End loop
		   }
		   finally {
			   if(!executor.isShutdown()) {
			   executor.shutdown();//shutdown the thread
			   }
		   }
		    mapToBeRetruned.put("_nifty", _nifty);	//Please don't change anything over here
		    mapToBeRetruned.put("_bank", _bank);	//Please don't change anything over here
		    
			return mapToBeRetruned;
	}

	
	
	
	private static Map<String,DataPoints> prepareParallelProcessFetchNiftyPivotPoints(String bankNifty,String nifty) {
		/**********************************Don't change anything below***************************************************************/
		/*begin Preparing operation  to start threading*/
		FutureTask<DataPoints> futureTask_Nifty = new FutureTask<DataPoints>(new Callable<DataPoints>(){
	  	    public DataPoints call() throws Exception {
	  	    	/*if (logger.isDebugEnabled()) {
					logger.info("Asynchronous ESIC Service call Attempt Thread started: thread size=6");
				}*/
	  	    	return NiftyAndBankNiftySupportResistance.getNiftyAndBankNiftySupportResistance(nifty);
	  	    }
	  	});
	     
	     FutureTask<DataPoints> futureTask_BankNifty = new FutureTask<DataPoints>(new Callable<DataPoints>(){
	  	    public DataPoints call() throws Exception {
	  	    	/*if (logger.isDebugEnabled()) {
					logger.info("Asynchronous EPFO Service call Attempt Thread started: thread size=6");
				}*/
	  	    	return NiftyAndBankNiftySupportResistance.getNiftyAndBankNiftySupportResistance(bankNifty);
	  	    }
	  	});
	     
	     Map<String,DataPoints> webServiceThreadResponse=callWebserviceConcurrently(futureTask_Nifty, futureTask_BankNifty);//Service calling in parallel
	     if(webServiceThreadResponse!=null)
	    	 return webServiceThreadResponse;
	     return null;
	} 
	
	
	public static ParentsDataPoints excuteParallelProcess() {
		String bankNifty = "https://www.investing.com/indices/bank-nifty-technical";
		String nifty = "https://www.investing.com/indices/s-p-cnx-nifty-technical";
		ParentsDataPoints parentsDataPoints=new ParentsDataPoints();
		Map<String,DataPoints> temp=prepareParallelProcessFetchNiftyPivotPoints(bankNifty,nifty);
		List<DataPoints> data=new LinkedList<>();
		if(temp!=null) {
			data.add(temp.get("_nifty"));
			data.add(temp.get("_bank"));
		}
		parentsDataPoints.setData(data);
		return parentsDataPoints;
	}
	
	public static void main(String[] args) {
		System.out.println(new Gson().toJson(NiftyAndBankNiftySupportResistance.excuteParallelProcess()));
	}
}
