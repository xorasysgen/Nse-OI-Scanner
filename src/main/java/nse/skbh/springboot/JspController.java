package nse.skbh.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JspController {

	@RequestMapping("/index")
    public String index(){
        return "index";
	}
	
	@RequestMapping("/oispurts")
    public String oiSpurts(){
        return "oiSpurts";
	}
	
	@RequestMapping("/gainers")
    public String gainers(){
        return "gainers";
	}
	
	@RequestMapping("/lossers")
    public String lossers(){
        return "loosers";
	}
	
	@RequestMapping("/boot")
    public String boot(){
        return "boot";
	}
	
	
}
