package nse.skbh.springboot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import nse.skbh.springboot.logic.RestTemplateProvider;
import nse.skbh.springboot.pojo.ParentBankNiftyVolume;
import nse.skbh.springboot.pojo.ParentMostActiveCallPutAll;
import nse.skbh.springboot.pojo.Services;
import nse.skbh.springboot.pojo.ServicesList;

@RestController
@RequestMapping("/derivative")
public class OISpurts {

	@RequestMapping("/")
	@ResponseBody
	public ParentMostActiveCallPutAll derivative() {
		RestTemplate restTemplate = new RestTemplateProvider().getRestTemplate();
		ResponseEntity<ParentMostActiveCallPutAll> response = restTemplate.getForEntity(
				"https://www.nseindia.com/live_market/dynaContent/live_analysis/most_active/CallsALLVolume.json",
				ParentMostActiveCallPutAll.class);
		ParentMostActiveCallPutAll parentMostActiveCallPutAll = response.getBody();
		return parentMostActiveCallPutAll;

	}

	@RequestMapping("/call")
	@ResponseBody
	ServicesList callHome() {
		ServicesList servicesObj = new ServicesList();
		List<Services> services = new ArrayList<>();
		List<String> list = Constant.getListOfService();
		Integer i = 1;
		for (String string : list) {
			Services s = new Services();
			s.setServiceID(i++);
			s.setServiceURI(string);
			services.add(s);
		}
		servicesObj.setService(services);
		return servicesObj;
	}

	@RequestMapping("/put")
	@ResponseBody
	ServicesList putHome() {
		ServicesList servicesObj = new ServicesList();
		List<Services> services = new ArrayList<>();
		List<String> list = Constant.getListOfService();
		Integer i = 1;
		for (String string : list) {
			Services s = new Services();
			s.setServiceID(i++);
			s.setServiceURI(string);
			services.add(s);
		}
		servicesObj.setService(services);
		return servicesObj;
	}

	@RequestMapping("/bank_nifty_volume")
	public ParentBankNiftyVolume showAllBankNiftyVolume() {
		RestTemplate restTemplate = new RestTemplateProvider().getRestTemplate();
		ResponseEntity<ParentBankNiftyVolume> response = restTemplate.getForEntity(
				"https://www.nseindia.com//live_market/dynaContent/live_analysis/most_active/allBankNiftyVolume.json",
				ParentBankNiftyVolume.class);
		ParentBankNiftyVolume parentBankNiftyVolume = response.getBody();
		return parentBankNiftyVolume;

	}

	@RequestMapping("/call/call_all")
	public ParentMostActiveCallPutAll ShowCallsALLVolume() {
		RestTemplate restTemplate = new RestTemplateProvider().getRestTemplate();
		ResponseEntity<ParentMostActiveCallPutAll> response = restTemplate.getForEntity(
				"https://www.nseindia.com/live_market/dynaContent/live_analysis/most_active/CallsALLVolume.json",
				ParentMostActiveCallPutAll.class);
		ParentMostActiveCallPutAll parentMostActiveCallPutAll = response.getBody();
		return parentMostActiveCallPutAll;

	}

	@RequestMapping("/call/call_nifty")
	public ParentMostActiveCallPutAll ShowCallsNIFTYVolume() {
		RestTemplate restTemplate = new RestTemplateProvider().getRestTemplate();
		ResponseEntity<ParentMostActiveCallPutAll> response = restTemplate.getForEntity(
				"https://www.nseindia.com/live_market/dynaContent/live_analysis/most_active/CallsNIFTYVolume.json",
				ParentMostActiveCallPutAll.class);
		ParentMostActiveCallPutAll parentMostActiveCallPutAll = response.getBody();
		return parentMostActiveCallPutAll;

	}

	@RequestMapping("/call/call_nifty_bank")
	public ParentMostActiveCallPutAll ShowCallsBANKNIFTYVolume() {
		RestTemplate restTemplate = new RestTemplateProvider().getRestTemplate();
		ResponseEntity<ParentMostActiveCallPutAll> response = restTemplate.getForEntity(
				"https://www.nseindia.com/live_market/dynaContent/live_analysis/most_active/CallsBANKNIFTYVolume.json",
				ParentMostActiveCallPutAll.class);
		ParentMostActiveCallPutAll parentMostActiveCallPutAll = response.getBody();
		return parentMostActiveCallPutAll;

	}

	@RequestMapping("/call/call_stocks")
	public ParentMostActiveCallPutAll ShowCallsOPTSTocKVolume() {
		RestTemplate restTemplate = new RestTemplateProvider().getRestTemplate();
		ResponseEntity<ParentMostActiveCallPutAll> response = restTemplate.getForEntity(
				"https://www.nseindia.com/live_market/dynaContent/live_analysis/most_active/CallsOPTSTKVolume.json",
				ParentMostActiveCallPutAll.class);
		ParentMostActiveCallPutAll parentMostActiveCallPutAll = response.getBody();
		return parentMostActiveCallPutAll;

	}

	/* all put section are here */

	@RequestMapping("/put/put_all")
	public ParentMostActiveCallPutAll ShowPutsALLVolume() {
		RestTemplate restTemplate = new RestTemplateProvider().getRestTemplate();
		ResponseEntity<ParentMostActiveCallPutAll> response = restTemplate.getForEntity(
				"https://www.nseindia.com/live_market/dynaContent/live_analysis/most_active/PutsALLVolume.json",
				ParentMostActiveCallPutAll.class);
		ParentMostActiveCallPutAll parentMostActiveCallPutAll = response.getBody();
		return parentMostActiveCallPutAll;

	}

	@RequestMapping("/put/put_nifty")
	public ParentMostActiveCallPutAll ShowPutsNIFTYVolume() {
		RestTemplate restTemplate = new RestTemplateProvider().getRestTemplate();
		ResponseEntity<ParentMostActiveCallPutAll> response = restTemplate.getForEntity(
				"https://www.nseindia.com/live_market/dynaContent/live_analysis/most_active/PutsNIFTYVolume.json",
				ParentMostActiveCallPutAll.class);
		ParentMostActiveCallPutAll parentMostActiveCallPutAll = response.getBody();
		return parentMostActiveCallPutAll;

	}

	@RequestMapping("/put/put_nifty_bank")
	public ParentMostActiveCallPutAll ShowPutsBANKNIFTYVolume() {
		RestTemplate restTemplate = new RestTemplateProvider().getRestTemplate();
		ResponseEntity<ParentMostActiveCallPutAll> response = restTemplate.getForEntity(
				"https://www.nseindia.com/live_market/dynaContent/live_analysis/most_active/PutsBANKNIFTYVolume.json",
				ParentMostActiveCallPutAll.class);
		ParentMostActiveCallPutAll parentMostActiveCallPutAll = response.getBody();
		return parentMostActiveCallPutAll;

	}

	@RequestMapping("/put/put_stocks")
	public ParentMostActiveCallPutAll ShowPutsOPTSTocKVolume() {
		RestTemplate restTemplate = new RestTemplateProvider().getRestTemplate();
		ResponseEntity<ParentMostActiveCallPutAll> response = restTemplate.getForEntity(
				"https://www.nseindia.com/live_market/dynaContent/live_analysis/most_active/PutsOPTSTKVolume.json",
				ParentMostActiveCallPutAll.class);
		ParentMostActiveCallPutAll parentMostActiveCallPutAll = response.getBody();
		return parentMostActiveCallPutAll;

	}

}
