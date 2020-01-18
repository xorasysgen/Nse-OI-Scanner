package nse.skbh.springboot.logic;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.google.gson.Gson;

import nse.skbh.springboot.pojo.ParentBankNiftyFuture;


public class BankNiftyFutureOIReader {

	
	public static ParentBankNiftyFuture getNiftyFutureOIReader() {
		String expiryMonth=LastThursdayOfEveryMonth.getNextExpiryOfEveryMonth().get(0);
		if(Utils.compareDates(expiryMonth)==1) {
			expiryMonth=LastThursdayOfEveryMonth.getNextExpiryOfEveryMonth().get(1);
		}
		String url = "https://www.nseindia.com/live_market/dynaContent/live_watch/get_quote/GetQuoteFO.jsp?underlying=NIFTY&instrument=FUTIDX&type=-&strike=-&expiry="+expiryMonth;
		Document doc = null;
		try {
			doc = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(20*1000).get();
			Element content = doc.getElementById("responseDiv");
			String jsonCont=content.html();
			//System.out.println(jsonCont);
			ParentBankNiftyFuture parentBankNiftyFuture=new Gson().fromJson(jsonCont, ParentBankNiftyFuture.class);
			
			return parentBankNiftyFuture;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}
	
	public static ParentBankNiftyFuture getBankNiftyFutureOIReader() {
		String expiryMonth=LastThursdayOfEveryMonth.getNextExpiryOfEveryMonth().get(0);
		if(Utils.compareDates(expiryMonth)==1) {
			expiryMonth=LastThursdayOfEveryMonth.getNextExpiryOfEveryMonth().get(1);
			
		}
		//System.out.println(expiryMonth);
		String url = "https://www.nseindia.com/live_market/dynaContent/live_watch/get_quote/GetQuoteFO.jsp?underlying=BANKNIFTY&instrument=FUTIDX&type=-&strike=-&expiry="+expiryMonth;
		Document doc = null;
		try {
			doc = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(20*1000).get();
			Element content = doc.getElementById("responseDiv");
			String jsonCont=content.html();
			//System.out.println(jsonCont);
			ParentBankNiftyFuture parentBankNiftyFuture=new Gson().fromJson(jsonCont, ParentBankNiftyFuture.class);
			
			return parentBankNiftyFuture;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}
	
	
	
	
	
	public static ParentBankNiftyFuture getAllFutureStockReaderNSE(String url) {
		String expiryMonth=LastThursdayOfEveryMonth.getNextExpiryOfEveryMonth().get(0);
		if(Utils.compareDates(expiryMonth)==1) {
			expiryMonth=LastThursdayOfEveryMonth.getNextExpiryOfEveryMonth().get(1);
		}
		url = url+expiryMonth;
		Document doc = null;
		try {
			doc = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(20*1000).get();
			Element content = doc.getElementById("responseDiv");
			String jsonCont=content.html();
			//System.out.println(jsonCont);
			ParentBankNiftyFuture parentBankNiftyFuture=new Gson().fromJson(jsonCont, ParentBankNiftyFuture.class);
			
			return parentBankNiftyFuture;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}
		
	public static void main(String[] args) {
		System.out.println(new Gson().toJson(BankNiftyFutureOIReader.getBankNiftyFutureOIReader()));
		System.out.println(new Gson().toJson(BankNiftyFutureOIReader.getNiftyFutureOIReader()));
	}
}