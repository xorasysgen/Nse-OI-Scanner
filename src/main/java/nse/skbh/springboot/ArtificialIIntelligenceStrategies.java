package nse.skbh.springboot;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import nse.skbh.springboot.logic.GannRoadMap;
import nse.skbh.springboot.logic.NiftyAndBankNiftySupportResistance;
import nse.skbh.springboot.logic.RestTemplateProvider;
import nse.skbh.springboot.logic.Top20ContractsReader;
import nse.skbh.springboot.pojo.OptionSuggestion;
import nse.skbh.springboot.pojo.ParentOptionSuggestion;
import nse.skbh.springboot.pojo.ParentsDataPoints;
import nse.skbh.springboot.pojo.RoadMapDataPoints;

@RestController
@RequestMapping("/suggestions")
public class ArtificialIIntelligenceStrategies {
	
	@GetMapping("/bank_nifty_expiry_day_option_suggestion")
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
		Object obj = new JsonParser().parse(stringInJson);
		JsonObject jsonObject = (JsonObject) obj;
		JsonObject jsonObjectChild =  jsonObject.getAsJsonObject("indices");
		String rawLastprice=jsonObjectChild.get("lastprice").getAsString();
		if(rawLastprice!=null) {
			rawLastprice=rawLastprice.replaceAll(",", "");
		}
		String rawPrevclose=jsonObjectChild.get("prevclose").getAsString();
		if(rawPrevclose!=null) {
			rawPrevclose=rawPrevclose.replaceAll(",", "");
		}
		String ltp=rawLastprice;
		String close=rawPrevclose;
		String symbolName="NIFTY";
		RoadMapDataPoints roadMapDataPoints=GannRoadMap.roadMap(ltp,close,symbolName);
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
		String symbolName="BANKNIFTY";
		RoadMapDataPoints roadMapDataPoints=GannRoadMap.roadMap(ltp,close,symbolName);
		//System.err.println(roadMapDataPoints);
		return roadMapDataPoints;

	}
	
	
}
