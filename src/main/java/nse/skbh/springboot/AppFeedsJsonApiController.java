package nse.skbh.springboot;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import nse.skbh.springboot.logic.RestTemplateProvider;
import nse.skbh.springboot.logic.Utils;

@RestController
@RequestMapping("/appfeeds")
public class AppFeedsJsonApiController {
	
	@GetMapping("/nifty")
	public String getNiftyAppFeeds() {
		RestTemplate restTemplate = new RestTemplateProvider().getRestTemplate();
		ResponseEntity<String> response = restTemplate
				.getForEntity(AppFeedsJsonApiController.URIHelper().concat("jsonapi/market/indices&ind_id=9"), String.class);
		String string = response.getBody();
		return string;

	}
	
	@GetMapping("/nifty/chart")
	public String getNiftyAppFeedsChart() {
		RestTemplate restTemplate = new RestTemplateProvider().getRestTemplate();
		ResponseEntity<String> response = restTemplate
				.getForEntity(AppFeedsJsonApiController.URIHelper().concat("jsonapi/market/graph&format=&ind_id=9&range=1d&type=area"), String.class);
		String string = response.getBody();
		return string;

	}
	
	@GetMapping("/banknifty")
	public String getBankNiftyAppFeeds() {
		RestTemplate restTemplate = new RestTemplateProvider().getRestTemplate();
		ResponseEntity<String> response = restTemplate
				.getForEntity(AppFeedsJsonApiController.URIHelper().concat("jsonapi/market/indices&ind_id=23"), String.class);
		String string = response.getBody();
		return string;

	}
	
	@GetMapping("/banknifty/chart")
	public String getBankNiftyAppFeedsChart() {
		RestTemplate restTemplate = new RestTemplateProvider().getRestTemplate();
		ResponseEntity<String> response = restTemplate
				.getForEntity(AppFeedsJsonApiController.URIHelper().concat("jsonapi/market/graph&format=&ind_id=23&range=1d&type=area"), String.class);
		String string = response.getBody();
		return string;

	}
	
	
	
	
	
	/*----------------------------------------------------------------------------------------*/
	
	
	
	private  static String URIHelper() {
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
