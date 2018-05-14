package nse.skbh.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JspController {

	@RequestMapping("/boot")
	public String boot() {
		return "boot";
	}

	@RequestMapping("/index")
	public String index() {
		return "index";
	}

	@RequestMapping("/oispurts")
	public String oiSpurts() {
		return "oiSpurts";
	}

	@RequestMapping("/gainers")
	public String gainers() {
		return "gainers";
	}

	@RequestMapping("/losers")
	public String lossers() {
		return "loosers";
	}

	@RequestMapping("/fostocks")
	public String fostocks() {
		return "fo_stocks";
	}

	@RequestMapping("/top_open_interest")
	public String topOpenInterest() {
		return "top_nse_open_interest";
	}

}
