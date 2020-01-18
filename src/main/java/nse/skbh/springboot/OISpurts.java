package nse.skbh.springboot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import nse.skbh.springboot.logic.BankNiftyFutureOIReader;
import nse.skbh.springboot.logic.RestTemplateProvider;
import nse.skbh.springboot.pojo.ParentBankNiftyFuture;
import nse.skbh.springboot.pojo.ParentBankNiftyVolume;
import nse.skbh.springboot.pojo.ParentMostActiveCallPutAll;
import nse.skbh.springboot.pojo.Services;
import nse.skbh.springboot.pojo.ServicesList;

@RestController
@RequestMapping("/derivative")
public class OISpurts {
	
	@Autowired
	RestTemplateProvider restTemplateProvider;
	
	@GetMapping("/")
	@ResponseBody
	public ParentMostActiveCallPutAll derivative() {
		RestTemplate restTemplate = restTemplateProvider.getRestTemplate();
		ResponseEntity<ParentMostActiveCallPutAll> response = restTemplate.getForEntity(
				"https://www1.nseindia.com/live_market/dynaContent/live_analysis/most_active/CallsALLVolume.json",
				ParentMostActiveCallPutAll.class);
		ParentMostActiveCallPutAll parentMostActiveCallPutAll = response.getBody();
		return parentMostActiveCallPutAll;

	}

	@GetMapping("/call")
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

	@GetMapping("/put")
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

	@GetMapping("/bank_nifty_volume")
	public ParentBankNiftyVolume showAllBankNiftyVolume() {
		RestTemplate restTemplate = restTemplateProvider.getRestTemplate();
		ResponseEntity<ParentBankNiftyVolume> response = restTemplate.getForEntity(
				"https://www1.nseindia.com//live_market/dynaContent/live_analysis/most_active/allBankNiftyVolume.json",
				ParentBankNiftyVolume.class);
		ParentBankNiftyVolume parentBankNiftyVolume = response.getBody();
		return parentBankNiftyVolume;

	}

	@GetMapping("/call/call_all")
	public ParentMostActiveCallPutAll ShowCallsALLVolume() {
		RestTemplate restTemplate = restTemplateProvider.getRestTemplate();
		ResponseEntity<ParentMostActiveCallPutAll> response = restTemplate.getForEntity(
				"https://www1.nseindia.com/live_market/dynaContent/live_analysis/most_active/CallsALLVolume.json",
				ParentMostActiveCallPutAll.class);
		ParentMostActiveCallPutAll parentMostActiveCallPutAll = response.getBody();
		return parentMostActiveCallPutAll;

	}

	@GetMapping("/call/call_nifty")
	public ParentMostActiveCallPutAll ShowCallsNIFTYVolume() {
		RestTemplate restTemplate = restTemplateProvider.getRestTemplate();
		ResponseEntity<ParentMostActiveCallPutAll> response = restTemplate.getForEntity(
				"https://www1.nseindia.com/live_market/dynaContent/live_analysis/most_active/CallsNIFTYVolume.json",
				ParentMostActiveCallPutAll.class);
		ParentMostActiveCallPutAll parentMostActiveCallPutAll = response.getBody();
		return parentMostActiveCallPutAll;

	}

	@GetMapping("/call/call_nifty_bank")
	public ParentMostActiveCallPutAll ShowCallsBANKNIFTYVolume() {
		RestTemplate restTemplate = restTemplateProvider.getRestTemplate();
		ResponseEntity<ParentMostActiveCallPutAll> response = restTemplate.getForEntity(
				"https://www1.nseindia.com/live_market/dynaContent/live_analysis/most_active/CallsBANKNIFTYVolume.json",
				ParentMostActiveCallPutAll.class);
		ParentMostActiveCallPutAll parentMostActiveCallPutAll = response.getBody();
		return parentMostActiveCallPutAll;

	}

	@GetMapping("/call/call_stocks")
	public ParentMostActiveCallPutAll ShowCallsOPTSTocKVolume() {
		RestTemplate restTemplate = restTemplateProvider.getRestTemplate();
		ResponseEntity<ParentMostActiveCallPutAll> response = restTemplate.getForEntity(
				"https://www1.nseindia.com/live_market/dynaContent/live_analysis/most_active/CallsOPTSTKVolume.json",
				ParentMostActiveCallPutAll.class);
		ParentMostActiveCallPutAll parentMostActiveCallPutAll = response.getBody();
		return parentMostActiveCallPutAll;

	}

	/* all put section are here */

	@GetMapping("/put/put_all")
	public ParentMostActiveCallPutAll ShowPutsALLVolume() {
		RestTemplate restTemplate = restTemplateProvider.getRestTemplate();
		ResponseEntity<ParentMostActiveCallPutAll> response = restTemplate.getForEntity(
				"https://www1.nseindia.com/live_market/dynaContent/live_analysis/most_active/PutsALLVolume.json",
				ParentMostActiveCallPutAll.class);
		ParentMostActiveCallPutAll parentMostActiveCallPutAll = response.getBody();
		return parentMostActiveCallPutAll;

	}

	@GetMapping("/put/put_nifty")
	public ParentMostActiveCallPutAll ShowPutsNIFTYVolume() {
		RestTemplate restTemplate = restTemplateProvider.getRestTemplate();
		ResponseEntity<ParentMostActiveCallPutAll> response = restTemplate.getForEntity(
				"https://www1.nseindia.com/live_market/dynaContent/live_analysis/most_active/PutsNIFTYVolume.json",
				ParentMostActiveCallPutAll.class);
		ParentMostActiveCallPutAll parentMostActiveCallPutAll = response.getBody();
		return parentMostActiveCallPutAll;

	}

	@GetMapping("/put/put_nifty_bank")
	public ParentMostActiveCallPutAll ShowPutsBANKNIFTYVolume() {
		RestTemplate restTemplate = restTemplateProvider.getRestTemplate();
		ResponseEntity<ParentMostActiveCallPutAll> response = restTemplate.getForEntity(
				"https://www1.nseindia.com/live_market/dynaContent/live_analysis/most_active/PutsBANKNIFTYVolume.json",
				ParentMostActiveCallPutAll.class);
		ParentMostActiveCallPutAll parentMostActiveCallPutAll = response.getBody();
		return parentMostActiveCallPutAll;

	}

	@GetMapping("/put/put_stocks")
	public ParentMostActiveCallPutAll ShowPutsOPTSTocKVolume() {
		RestTemplate restTemplate = restTemplateProvider.getRestTemplate();
		ResponseEntity<ParentMostActiveCallPutAll> response = restTemplate.getForEntity(
				"https://www1.nseindia.com/live_market/dynaContent/live_analysis/most_active/PutsOPTSTKVolume.json",
				ParentMostActiveCallPutAll.class);
		ParentMostActiveCallPutAll parentMostActiveCallPutAll = response.getBody();
		return parentMostActiveCallPutAll;

	}
	
	@GetMapping("/nse/coc/{id}")
	public ParentBankNiftyFuture readNseFOInternalData(@PathVariable("id") String id) {
		String stockFuture="FUTSTK";
		String indexFuture="FUTIDX";
		String url=null;
		if(id!=null) {
			if(id.length()>20) {
				return new ParentBankNiftyFuture();
			}
			if(id.equalsIgnoreCase("BANKNIFTY") || id.equalsIgnoreCase("NIFTY")) {
				url="https://www1.nseindia.com/live_market/dynaContent/live_watch/get_quote/GetQuoteFO.jsp?" + 
						"underlying="+id+"&instrument="+indexFuture+"&type=-&strike=-&expiry=";
			}
			else {
			url="https://www1.nseindia.com/live_market/dynaContent/live_watch/get_quote/GetQuoteFO.jsp?" +
					"underlying="+id+"&instrument="+stockFuture + "&type=-&strike=-&expiry=";
			}
			ParentBankNiftyFuture allFutureStockData=BankNiftyFutureOIReader.getAllFutureStockReaderNSE(url);
			return allFutureStockData;
		}
		return null;

	}
	

}
