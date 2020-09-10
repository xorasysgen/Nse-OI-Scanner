package nse.skbh.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import nse.skbh.springboot.logic.RestTemplateProvider;
import nse.skbh.springboot.logic.Utils;

@RestController
@RequestMapping("/appfeeds")
public class AppFeedsJsonApiController {
	
	@Autowired
	RestTemplateProvider restTemplateProvider;
	
	@GetMapping("/nifty")
	@HystrixCommand(fallbackMethod = "appFeedsJsonApiControllerFailure", commandKey = "AppFeedsJson" , groupKey = "AppFeedsJsonApiController")
	public String getNiftyAppFeeds() {
		RestTemplate restTemplate = restTemplateProvider.getRestTemplate();
		ResponseEntity<String> response = restTemplate
				.getForEntity(AppFeedsJsonApiController.URIHelper().concat("jsonapi/market/indices&ind_id=9"), String.class);
		String string = response.getBody();
		return string;

	}
	
	public String appFeedsJsonApiControllerFailure() {
		return "nifty appFeedsJsonApi ControllerFailure Happend";

	}
	
	@GetMapping("/nifty/chart")
	public String getNiftyAppFeedsChart() {
		RestTemplate restTemplate = restTemplateProvider.getRestTemplate();
		ResponseEntity<String> response = restTemplate
				.getForEntity(AppFeedsJsonApiController.URIHelper().concat("jsonapi/market/graph&format=&ind_id=9&range=1d&type=area"), String.class);
		String string = response.getBody();
		return string;

	}
	
	@GetMapping("/banknifty")
	public String getBankNiftyAppFeeds() {
		RestTemplate restTemplate = restTemplateProvider.getRestTemplate();
		ResponseEntity<String> response = restTemplate
				.getForEntity(AppFeedsJsonApiController.URIHelper().concat("jsonapi/market/indices&ind_id=23"), String.class);
		String string = response.getBody();
		return string;

	}
	
	@GetMapping("/banknifty/chart")
	public String getBankNiftyAppFeedsChart() {
		RestTemplate restTemplate = restTemplateProvider.getRestTemplate();
		ResponseEntity<String> response = restTemplate
				.getForEntity(AppFeedsJsonApiController.URIHelper().concat("jsonapi/market/graph&format=&ind_id=23&range=1d&type=area"), String.class);
		String string = response.getBody();
		return string;

	}
	
	@GetMapping("/banknifty/future")
	public String getBankNiftyFutureAppFeeds() {
		RestTemplate restTemplate = restTemplateProvider.getRestTemplate();
		ResponseEntity<String> response = restTemplate
				.getForEntity(AppFeedsJsonApiController.URIHelper().concat("jsonapi/fno/overview&format=&inst_type=Futures&id=BANKNIFTY&ExpiryDate="), String.class);
		String stringInJson = response.getBody();
		if(stringInJson!=null) {
		Object obj = new JsonParser().parse(stringInJson);
		JsonObject jsonObject = (JsonObject) obj;
		JsonObject jsonObjectChild =  jsonObject.getAsJsonObject("fno_list");
		String extractedItem=jsonObjectChild.get("item").toString();
		return extractedItem;
		}
		return "";

	}
	
	@GetMapping("/nifty/future")
	public String getNiftyFutureAppFeeds() {
		RestTemplate restTemplate = restTemplateProvider.getRestTemplate();
		ResponseEntity<String> response = restTemplate
				.getForEntity(AppFeedsJsonApiController.URIHelper().concat("jsonapi/fno/overview&format=&inst_type=Futures&id=NIFTY&ExpiryDate="), String.class);
		String stringInJson = response.getBody();
		if(stringInJson!=null) {
		Object obj = new JsonParser().parse(stringInJson);
		JsonObject jsonObject = (JsonObject) obj;
		JsonObject jsonObjectChild =  jsonObject.getAsJsonObject("fno_list");
		String extractedItem=jsonObjectChild.get("item").toString();
		return extractedItem;
		}
		return "";

	}
	/*----------------------------this code is offline and deprecated only money control one is live------------------------------------------------------------*/
/*	public static void main(String[] args) {
		RestTemplate restTemplate = restTemplateProvider.getRestTemplate();
		ResponseEntity<String> response = restTemplate
				.getForEntity("https://www.nseindia.com/live_market/dynaContent/live_watch/get_quote/ajaxFOGetQuoteJSON.jsp?underlying=BANKNIFTY&instrument=OPTIDX&expiry=27DEC2018&type=ce&strike=26900", String.class);
		String stringInJson = response.getBody();
		System.out.println(stringInJson);
		
		
	}
	*/
	/*----------------------------------------------------------------------------------------*/
	
	
	
	public static String URIHelper() {
		String key=Utils.decoder(Users.key.getBytes());
		String apiURL=null;
		try {
			apiURL=Utils._decrypt(Users.apiURL, key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apiURL;
	}
	/*----------------------------------------------------------------------------------------*/
	
}
