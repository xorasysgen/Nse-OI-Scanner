package nse.skbh.springboot;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import nse.skbh.springboot.logic.ReadURI;
import nse.skbh.springboot.logic.RestTemplateProvider;
import nse.skbh.springboot.pojo.GainerLosser;
import nse.skbh.springboot.pojo.Nse;
import nse.skbh.springboot.pojo.OIData;
import nse.skbh.springboot.pojo.ParentFOSecStockWatchData;
import nse.skbh.springboot.pojo.ParentMostActive;
import nse.skbh.springboot.pojo.ParentOIChangeData;

@RestController
public class WebBoot  {

	@RequestMapping("/open_interest")
	public OIData home() {

		List<Nse> nse = null;
		try {
			nse = ReadURI.unpackArchive();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		OIData OIData = new OIData();
		OIData.setOpenInterest(nse);
		return OIData;
		// return new Gson().toJson(OIData);
	}
	
	@RequestMapping("/top_gainer")
	public GainerLosser topGainer() {
		RestTemplate restTemplate = new RestTemplateProvider().getRestTemplate();
        ResponseEntity<GainerLosser> response = 
        	      restTemplate.getForEntity("https://www.nseindia.com/live_market/dynaContent/live_analysis/gainers/niftyGainers1.json",GainerLosser.class);
        GainerLosser gainerLosser = response.getBody();
        return gainerLosser;
	}
	
	@RequestMapping("/top_looser")
	public GainerLosser topLosser() {
		RestTemplate restTemplate=new RestTemplateProvider().getRestTemplate();
        ResponseEntity<GainerLosser> response = 
        	      restTemplate.getForEntity("https://www.nseindia.com/live_market/dynaContent/live_analysis/losers/niftyLosers1.json",GainerLosser.class);
        GainerLosser gainerLosser = response.getBody();
        return gainerLosser;
	}
	
	
	@RequestMapping("/oi_spurts")
	public ParentOIChangeData topPositiveOIChangeData() {
		RestTemplate restTemplate=new RestTemplateProvider().getRestTemplate();
        ResponseEntity<ParentOIChangeData> response = 
        	      restTemplate.getForEntity("https://www.nseindia.com/live_market/dynaContent/live_analysis/oi_spurts/topPositiveOIChangeData.json",ParentOIChangeData.class);
        ParentOIChangeData parentOIChangeData = response.getBody();
        return parentOIChangeData;
	}
	
	@RequestMapping("/fo_stocks")
	public ParentFOSecStockWatchData foSecStockWatch() {
		RestTemplate restTemplate=new RestTemplateProvider().getRestTemplate();
        ResponseEntity<ParentFOSecStockWatchData> response = 
        	      restTemplate.getForEntity("https://www.nseindia.com/live_market/dynaContent/live_watch/stock_watch/foSecStockWatch.json",ParentFOSecStockWatchData.class);
        ParentFOSecStockWatchData parentFOSecStockWatchData = response.getBody();
        return parentFOSecStockWatchData;
	}

	
	@RequestMapping("/most_active_volume")
	public ParentMostActive mostActiveSecuritiesByVolume() {
		RestTemplate restTemplate=new RestTemplateProvider().getRestTemplate();
        ResponseEntity<ParentMostActive> response = 
        	      restTemplate.getForEntity("https://www.nseindia.com/live_market/dynaContent/live_analysis/most_active/allTopVolume1.json",ParentMostActive.class);
        ParentMostActive parentMostActive = response.getBody();
        return parentMostActive;
	}
	
	@RequestMapping("/most_active_value")
	public ParentMostActive mostActiveSecuritiesByValue() {
		RestTemplate restTemplate=new RestTemplateProvider().getRestTemplate();
        ResponseEntity<ParentMostActive> response = 
        	      restTemplate.getForEntity("https://www.nseindia.com/live_market/dynaContent/live_analysis/most_active/allTopValue1.json",ParentMostActive.class);
        ParentMostActive parentMostActive = response.getBody();
        return parentMostActive;
	}

	
	
	
	

}
