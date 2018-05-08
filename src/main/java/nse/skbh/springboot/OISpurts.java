package nse.skbh.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OISpurts {
	
	
	@RequestMapping("os")
	public String showOISpurts() {
		RestTemplate restTemplate = new RestTemplate();
		return "OI Spurts building module version 1.0.0.1 system : diffrent than git";
		
	}
	

}
