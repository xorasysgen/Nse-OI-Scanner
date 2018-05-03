package nse.skbh.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OISpurts {
	
	
	@RequestMapping("os")
	public String showOISpurts() {
		return "OI Spurts building module version 1.0.0.1";
		
	}
	

}
