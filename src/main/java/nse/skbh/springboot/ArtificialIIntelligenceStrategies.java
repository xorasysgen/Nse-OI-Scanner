package nse.skbh.springboot;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import nse.skbh.springboot.logic.GannRoadMap;
import nse.skbh.springboot.logic.NiftyAndBankNiftySupportResistance;
import nse.skbh.springboot.logic.RestTemplateProvider;
import nse.skbh.springboot.logic.Top20ContractsReader;
import nse.skbh.springboot.pojo.FOSecStockWatchData;
import nse.skbh.springboot.pojo.IndicesData;
import nse.skbh.springboot.pojo.IndicesDataOHL;
import nse.skbh.springboot.pojo.OptionSuggestion;
import nse.skbh.springboot.pojo.ParentFOSecStockWatchData;
import nse.skbh.springboot.pojo.ParentIndicesData;
import nse.skbh.springboot.pojo.ParentIndicesDataOHL;
import nse.skbh.springboot.pojo.ParentOptionSuggestion;
import nse.skbh.springboot.pojo.ParentsDataPoints;
import nse.skbh.springboot.pojo.PremiumDiscountNiftyBankNifty;
import nse.skbh.springboot.pojo.RoadMapDataPoints;

@RestController
@RequestMapping("/suggestions")
public class ArtificialIIntelligenceStrategies {
	
	@GetMapping("/bank_nifty_expiry_day_option_suggestion")
	@HystrixCommand(fallbackMethod = "suggestionsService", commandKey = "suggestionsServiceCommand" , groupKey = "suggestionsService")
	public ParentOptionSuggestion getbankNiftyOptionFinderExpiryDay() {
		Map<String,String> map=Top20ContractsReader.bankNiftyOptionFinder();
		ParentOptionSuggestion parentOptionSuggestion=new ParentOptionSuggestion();
		List<OptionSuggestion> data=null;
		if(map!=null) {
			data=new LinkedList<>();
			for(Map.Entry<String, String> temp:map.entrySet()) {
				OptionSuggestion optionSuggestion=new OptionSuggestion();
				optionSuggestion.setOptionTypeStrikePrice(temp.getValue());
				data.add(optionSuggestion);
			}
		}
		parentOptionSuggestion.setData(data);
		return parentOptionSuggestion;

	}
	
	
	public ParentOptionSuggestion suggestionsService() {
		return new ParentOptionSuggestion();

	}
	
	@GetMapping("/bank_nifty_expiry_day_option_suggestion/non_expiry_day")
	public ParentOptionSuggestion getbankNiftyOptionFinderNonExpiryDay() {
		Map<String,String> map=Top20ContractsReader.bankNiftyOptionFinderNonExpiryDay();
		ParentOptionSuggestion parentOptionSuggestion=new ParentOptionSuggestion();
		List<OptionSuggestion> data=new LinkedList<OptionSuggestion>();
		if(map!=null) {
			for(Map.Entry<String, String> temp:map.entrySet()) {
				OptionSuggestion optionSuggestion=new OptionSuggestion();
				optionSuggestion.setOptionTypeStrikePrice(temp.getValue());
				data.add(optionSuggestion);
			}
		}
		
		Map<String,String> maptemp=Top20ContractsReader.bankNiftyOptionaAggressiveFinder();
		if(maptemp!=null) {
			for(Map.Entry<String, String> temp:maptemp.entrySet()) {
				OptionSuggestion optionSuggestion=new OptionSuggestion();
				optionSuggestion.setOptionTypeStrikePrice(temp.getValue());
				data.add(optionSuggestion);
			}
		}
		parentOptionSuggestion.setData(data);
		return parentOptionSuggestion;

	}
	
	@GetMapping("/bank_nifty_expiry_day_option_suggestion/aggressive_calls")
	public ParentOptionSuggestion getbankNiftyOptionFinderAggressiveCalls() {
		Map<String,String> map=Top20ContractsReader.bankNiftyOptionaAggressiveFinder();
		ParentOptionSuggestion parentOptionSuggestion=new ParentOptionSuggestion();
		List<OptionSuggestion> data=null;
		if(map!=null) {
			data=new LinkedList<>();
			for(Map.Entry<String, String> temp:map.entrySet()) {
				OptionSuggestion optionSuggestion=new OptionSuggestion();
				optionSuggestion.setOptionTypeStrikePrice(temp.getValue());
				data.add(optionSuggestion);
			}
		}
		parentOptionSuggestion.setData(data);
		return parentOptionSuggestion;

	}
	
	
	@GetMapping("/banknifty_and_nifty_support_resistance")
	public ParentsDataPoints getDataPointsNiftyAndBankNifty() {
		return NiftyAndBankNiftySupportResistance.excuteParallelProcess();
	}
	
	@GetMapping("/nifty_roadMap")
	public RoadMapDataPoints getNiftyRoadMap() {
		RestTemplate restTemplate = new RestTemplateProvider().getRestTemplate();
		ResponseEntity<String> response = restTemplate
				.getForEntity(AppFeedsJsonApiController.URIHelper().concat("jsonapi/market/indices&ind_id=9"), String.class);
		String stringInJson = response.getBody();
		/*begins parse json data from response*/
		Object obj = new JsonParser().parse(stringInJson);
		JsonObject jsonObject = (JsonObject) obj;
		JsonObject jsonObjectChild =  jsonObject.getAsJsonObject("indices");
		String rawLastprice=jsonObjectChild.get("lastprice").getAsString();
		String ltp="0";
		if(rawLastprice!=null) {
			rawLastprice=rawLastprice.replaceAll(",", "");
			ltp=rawLastprice;
		}
		String rawPrevclose=jsonObjectChild.get("prevclose").getAsString();
		String close="0";
		if(rawPrevclose!=null) {
			rawPrevclose=rawPrevclose.replaceAll(",", "");
			close=rawPrevclose;
		}
		String rawOpen=jsonObjectChild.get("open").getAsString();
		String open="0";
		if(rawOpen!=null) {
			rawOpen=rawOpen.replaceAll(",", "");
			open=rawOpen;
		}
		
		String direction=jsonObjectChild.get("direction").getAsString();
		/*end parse json data from response*/
		String symbolName="NIFTY";
		RoadMapDataPoints roadMapDataPoints=GannRoadMap.roadMap(ltp,close,open,symbolName);
		roadMapDataPoints.setDirection(direction);
		//System.err.println(roadMapDataPoints);
		return roadMapDataPoints;
		
        

	}
	
	
	@GetMapping("/bank_nifty_roadMap")
	public RoadMapDataPoints getBankNiftyRoadMap() {
		RestTemplate restTemplate = new RestTemplateProvider().getRestTemplate();
		ResponseEntity<String> response = restTemplate
				.getForEntity(AppFeedsJsonApiController.URIHelper().concat("jsonapi/market/indices&ind_id=23"), String.class);
		String stringInJson = response.getBody();
		Object obj = new JsonParser().parse(stringInJson);
		JsonObject jsonObject = (JsonObject) obj;
		JsonObject jsonObjectChild =  jsonObject.getAsJsonObject("indices");
		String rawLastprice=jsonObjectChild.get("lastprice").getAsString();
		String ltp="0";
		if(rawLastprice!=null) {
			rawLastprice=rawLastprice.replaceAll(",", "");
			ltp=rawLastprice;
		}
		String rawPrevclose=jsonObjectChild.get("prevclose").getAsString();
		String close="0";
		if(rawPrevclose!=null) {
			rawPrevclose=rawPrevclose.replaceAll(",", "");
			close=rawPrevclose;
		}
		String rawOpen=jsonObjectChild.get("open").getAsString();
		String open="0";
		if(rawOpen!=null) {
			rawOpen=rawOpen.replaceAll(",", "");
			open=rawOpen;
		}
		String direction=jsonObjectChild.get("direction").getAsString();
		String symbolName="BANKNIFTY";
		RoadMapDataPoints roadMapDataPoints=GannRoadMap.roadMap(ltp,close,open,symbolName);
		roadMapDataPoints.setDirection(direction);
		//System.err.println(roadMapDataPoints);
		return roadMapDataPoints;

	}
	
	@GetMapping("/premium_discount_nifty_banknifty")
	public  PremiumDiscountNiftyBankNifty getNiftyBankNiftyFuture() {
		String nifty="jsonapi/market/indices&ind_id=9";
		String niftyFuture="jsonapi/fno/overview&format=&inst_type=Futures&id=NIFTY&ExpiryDate=";
		String banknifty="jsonapi/market/indices&ind_id=23";
		String bankniftyFuture="jsonapi/fno/overview&format=&inst_type=Futures&id=BANKNIFTY&ExpiryDate=";
		nifty=ArtificialIIntelligenceStrategies.getlastPriceBasedonCashURI(nifty);
		banknifty=ArtificialIIntelligenceStrategies.getlastPriceBasedonCashURI(banknifty);
		niftyFuture=ArtificialIIntelligenceStrategies.getlastPriceBasedonFutureURI(niftyFuture);
		bankniftyFuture=ArtificialIIntelligenceStrategies.getlastPriceBasedonFutureURI(bankniftyFuture);
		nifty=nifty.replace(",", "");
		banknifty=banknifty.replace(",", "");
		niftyFuture=niftyFuture.replaceAll("\"", "");
		bankniftyFuture=bankniftyFuture.replaceAll("\"", "");
		Float premiumOrDiscountNifty=Float.parseFloat(niftyFuture)-Float.parseFloat(nifty);
		Float premiumOrDiscountNiftyBank=Float.parseFloat(bankniftyFuture)-Float.parseFloat(banknifty);
		PremiumDiscountNiftyBankNifty premiumDiscountNiftyBankNifty=new PremiumDiscountNiftyBankNifty();
		premiumDiscountNiftyBankNifty.setNifty(premiumOrDiscountNifty);
		premiumDiscountNiftyBankNifty.setBankNifty(premiumOrDiscountNiftyBank);
		return premiumDiscountNiftyBankNifty;

	}
	
	private static String getlastPriceBasedonCashURI(String uri) {
		RestTemplate restTemplate = new RestTemplateProvider().getRestTemplate();
		ResponseEntity<String> response = restTemplate
				.getForEntity(AppFeedsJsonApiController.URIHelper().concat(uri), String.class);
		String stringInJson = response.getBody();
		/*begins parse json data from response*/
		if(stringInJson!=null) {
			Object obj = new JsonParser().parse(stringInJson);
			JsonObject jsonObject = (JsonObject) obj;
			JsonObject jsonObjectChild =  jsonObject.getAsJsonObject("indices");
			String rawLastprice=jsonObjectChild.get("lastprice").getAsString();
			return rawLastprice;
		}
		return "0";
	}
	
	private static String getlastPriceBasedonFutureURI(String uri) {
		RestTemplate restTemplate = new RestTemplateProvider().getRestTemplate();
		ResponseEntity<String> response = restTemplate
				.getForEntity(AppFeedsJsonApiController.URIHelper().concat(uri), String.class);
		String stringInJson = response.getBody();
		/*begins parse json data from response*/
		if(stringInJson!=null) {
		Object obj = new JsonParser().parse(stringInJson);
		JsonObject jsonObject = (JsonObject) obj;
		JsonObject jsonlistObject =  jsonObject.getAsJsonObject("fno_list");
		JsonArray ja=jsonlistObject.getAsJsonArray("item");
		JsonObject jo=ja.get(0).getAsJsonObject();
		String lastprice=jo.get("lastprice").toString();
		return lastprice;
		}
		return "0";
	}
	
	
	@GetMapping("/nifty/ohl_strategy/fo")
	public ParentIndicesDataOHL FandONiftyOHL() {
		RestTemplate restTemplate = new RestTemplateProvider().getRestTemplate();
		ResponseEntity<ParentFOSecStockWatchData> response = restTemplate.getForEntity(
				"https://www.nseindia.com/live_market/dynaContent/live_watch/stock_watch/foSecStockWatch.json",
				ParentFOSecStockWatchData.class);
		ParentFOSecStockWatchData parentFOSecStockWatchData = response.getBody();
		
		List<FOSecStockWatchData> data=parentFOSecStockWatchData.getData();
		List<IndicesDataOHL> dataNew=new ArrayList<IndicesDataOHL>();
		ParentIndicesDataOHL parentIndicesDataOHL=new  ParentIndicesDataOHL();
		for (Iterator<FOSecStockWatchData> iterator = data.iterator(); iterator.hasNext();) {
			IndicesDataOHL indicesDataOHL=new IndicesDataOHL();
			FOSecStockWatchData indicesData = (FOSecStockWatchData) iterator.next();
				indicesDataOHL.setOpen(indicesData.getOpen());
				indicesDataOHL.setHigh(indicesData.getHigh());
				indicesDataOHL.setLow(indicesData.getLow());
				indicesDataOHL.setLtP(indicesData.getLtP());
				indicesDataOHL.setSymbol(indicesData.getSymbol());
				indicesDataOHL.setPer(indicesData.getPer());
				indicesDataOHL.setWkhi(indicesData.getWkhi());
				indicesDataOHL.setWklo(indicesData.getWklo());
				List<String> list=ArtificialIIntelligenceStrategies.calculateOHLBuySell(indicesData.getOpen(),
						indicesData.getHigh(),
						indicesData.getLow(),
						indicesData.getLtP());
				indicesDataOHL.setBuyPercentage(list.get(0));
				indicesDataOHL.setSellPercentage(list.get(1));
				indicesDataOHL.setBuySell(list.get(2));
				
			dataNew.add(indicesDataOHL);
		}
		parentIndicesDataOHL.setData(dataNew);
		return parentIndicesDataOHL;
	}
	
	
	
	@GetMapping("/nifty/ohl_strategy")
	public ParentIndicesDataOHL AdvancesDeclinesNifty() {
		RestTemplate restTemplate = new RestTemplateProvider().getRestTemplate();
		ResponseEntity<ParentIndicesData> response = restTemplate.getForEntity(
				"https://www.nseindia.com/live_market/dynaContent/live_watch/stock_watch/niftyStockWatch.json",
				ParentIndicesData.class);
		ParentIndicesData parentIndicesData = response.getBody();
		List<IndicesData> data=parentIndicesData.getData();
		List<IndicesDataOHL> dataNew=new ArrayList<IndicesDataOHL>();
		ParentIndicesDataOHL parentIndicesDataOHL=new  ParentIndicesDataOHL();
		for (Iterator<IndicesData> iterator = data.iterator(); iterator.hasNext();) {
			IndicesDataOHL indicesDataOHL=new IndicesDataOHL();
			IndicesData indicesData = (IndicesData) iterator.next();
				indicesDataOHL.setOpen(indicesData.getOpen());
				indicesDataOHL.setHigh(indicesData.getHigh());
				indicesDataOHL.setLow(indicesData.getLow());
				indicesDataOHL.setPreviousClose(indicesData.getPreviousClose());
				indicesDataOHL.setLtP(indicesData.getLtP());
				indicesDataOHL.setSymbol(indicesData.getSymbol());
				indicesDataOHL.setPer(indicesData.getPer());
				indicesDataOHL.setWkhi(indicesData.getWkhi());
				indicesDataOHL.setWklo(indicesData.getWklo());
				List<String> list=ArtificialIIntelligenceStrategies.calculateOHLBuySell(indicesData.getOpen(),
						indicesData.getHigh(),
						indicesData.getLow(),
						indicesData.getLtP(),indicesData.getPreviousClose());
				indicesDataOHL.setBuyPercentage(list.get(0));
				indicesDataOHL.setSellPercentage(list.get(1));
				indicesDataOHL.setBuySell(list.get(2));
				
			dataNew.add(indicesDataOHL);
		}
		parentIndicesDataOHL.setData(dataNew);
		return parentIndicesDataOHL;
	}
	
	
	public static List<String> calculateOHLBuySell(String o,String h,String l,String ltp,String previousClose) {
		String result="Neutral";
		Double open=Double.parseDouble(o.replace(",", ""));
		Double high=Double.parseDouble(h.replace(",", ""));
		Double low=Double.parseDouble(l.replace(",", ""));
		Double ltpd=Double.parseDouble(ltp.replace(",", ""));
		Double previousClosed=Double.parseDouble(previousClose.replace(",", ""));
		
		Double highMinusOpen=high-open;
		Double openMinuslow=open-low;
		List<String> list=new ArrayList<String>();
		Double oh = (highMinusOpen / high) * 100;
		Double ol = (openMinuslow / open) * 100;
	/*	System.out.println(highMinusOpen);
		System.out.println(openMinuslow);
		System.out.println(oh);
		System.out.println(ol);*/
		list.add(oh.toString());
		list.add(ol.toString());
		/*System.out.println("open#" + open);
		System.out.println("high#" + high);*/
		if(Double.compare(open,high)==0) {
			result="Strong Sell(OH)";
			list.add(result);
			return list;
		}
		else if(Double.compare(open,low)==0) {
			result="Strong Buy(OL)";
			list.add(result);
			return list;
		}
		if(oh>=0.0 && oh<=0.85 && ol>=1.25) {
			result="Strong Sell(Lower High)";
			list.add(result);
			return list;
		}
		else if (ol>=0.0 && ol<=0.85 && oh >=1.25) {
			result="Strong Buy(Higher High)";
			list.add(result);
			return list;
		}
		if(ltpd>=open && ltpd>=previousClosed) {
			result="Buy";
			list.add(result);
			return list;
		}
		else if(ltpd<=open && ltpd<=previousClosed) {
			result="Sell";
			list.add(result);
			return list;
		}
		list.add(result);
		return list;
		
	}
	
	public static List<String> calculateOHLBuySell(String o,String h,String l,String ltp) {
		String result="Neutral";
		Double open=Double.parseDouble(o.replace(",", ""));
		Double high=Double.parseDouble(h.replace(",", ""));
		Double low=Double.parseDouble(l.replace(",", ""));
		Double ltpd=Double.parseDouble(ltp.replace(",", ""));
		
		Double highMinusOpen=high-open;
		Double openMinuslow=open-low;
		List<String> list=new ArrayList<String>();
		Double oh = (highMinusOpen / high) * 100;
		Double ol = (openMinuslow / open) * 100;
	/*	System.out.println(highMinusOpen);
		System.out.println(openMinuslow);
		System.out.println(oh);
		System.out.println(ol);*/
		list.add(oh.toString());
		list.add(ol.toString());
		if(Double.compare(open,high)==0) {
			result="Strong Sell(OH)";
			list.add(result);
			return list;
		}
		else if(Double.compare(open,low)==0) {
			result="Strong Buy(OL)";
			list.add(result);
			return list;
		}
		if(oh>=0.0 && oh<=0.85 && ol>=1.25) {
			result="Strong Sell(Lower High)";
			list.add(result);
			return list;
		}
		else if (ol>=0.0 && ol<=0.85 && oh >=1.25) {
			result="Strong Buy(Higher High)";
			list.add(result);
			return list;
		}
		if(ltpd>=open && ltpd>=low) {
			result="Buy";
			list.add(result);
			return list;
		}
		else if(ltpd<=open && ltpd<=high) {
			result="Sell";
			list.add(result);
			return list;
		}
		list.add(result);
		return list;
		
	}
	
	/*public static void main(String[] args) {
		System.out.println(ArtificialIIntelligenceStrategies.calculateOHLBuySell("307.10","322.95"
				,"304.50","318.85","306.25"));
		
		PremiumDiscountNiftyBankNifty premiumDiscountNiftyBankNifty=new ArtificialIIntelligenceStrategies().getNiftyBankNiftyFuture();
		if(premiumDiscountNiftyBankNifty!=null) {
			System.out.println(premiumDiscountNiftyBankNifty.getBankNifty());
		}
	}*/
	
}	
/*//	Nifty Premium –If Nifty future is trading higher than nifty spot, then nifty future is trading with premium. The Highest Premium seen in Nifty was 70 points in 28 Feb 2012 expiry when market rose 20% in matter on 2 months.
//
//	Premium = Nifty Future Price – Spot Nifty Value
//
//	For Eg: Suppose  NIFTY is trading at  5000 and NIFTY FUTURE is trading at  5020 in this case Nifty is trading in Premium of 20 points (5020-5000)
//
//	 
//
//	Nifty Discount –If Nifty future is trading lower than nifty spot, then nifty future is trading with Discount.
//
//	Discount = Spot Nifty Value – Nifty Future Price
//
//	For Eg: Suppose  NIFTY is trading at  5000 and NIFTY FUTURE is trading at  4990 in this case Nifty is trading in Discount of 10 points (5000-4990)
//	What is significance of Discount and Premium availability of NIFTY?
//	When discount widens , bearish mood of market is increasing
//	When premium widens , bullish mood of market is increasing
*/
