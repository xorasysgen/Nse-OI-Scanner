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

	@RequestMapping("/25_volume_gainers")
	public String top25VolumeGainer() {
		return "volume_gainers";
	}

	@RequestMapping("/most_active_securities_value")
	public String MostActive_securities_value() {
		return "most_active_securities_value";
	}

	@RequestMapping("/most_active_securities_volume")
	public String MostActive_securities_volume() {
		return "most_active_securities_volume";
	}

	@RequestMapping("/fostocks")
	public String fostocks() {
		return "fo_stocks";
	}

	@RequestMapping("/top_open_interest")
	public String topOpenInterest() {
		return "top_nse_open_interest";
	}

	@RequestMapping("/most_active_underlying")
	public String mostActiveIntraday() {
		return "most_active_intraday";
	}

	@RequestMapping("/active_fo_call")
	public String ActiveFoCall() {
		return "active_fo_call";
	}

	@RequestMapping("/active_fo_put")
	public String ActiveFoPut() {
		return "active_fo_put";
	}

	@RequestMapping("/bullish")
	public String topBullish() {
		return "bullish";
	}

	@RequestMapping("/bearish")
	public String topBearish() {
		return "bearish";
	}

	@RequestMapping("/short_covering")
	public String topShortCovering() {
		return "short_covering";
	}

	@RequestMapping("/long_unwinding")
	public String topLongUnwinding() {
		return "long_unwinding";
	}

	@RequestMapping("/derivative_call_all")
	public String TopDerivativeCallAll() {
		return "derivative_call_all";
	}

	@RequestMapping("/derivative_call_nifty_bank")
	public String TopDerivativeCallNiftyBank() {
		return "derivative_call_nifty_bank";
	}

	@RequestMapping("/derivative_call_nifty")
	public String TopDerivativeCallNifty() {
		return "derivative_call_nifty";
	}

	@RequestMapping("/derivative_put_all")
	public String TopDerivativePutAll() {
		return "derivative_put_all";
	}

	@RequestMapping("/derivative_put_nifty_bank")
	public String TopDerivativePutNiftyBank() {
		return "derivative_put_nifty_bank";
	}

	@RequestMapping("/derivative_put_nifty")
	public String TopDerivativePutNifty() {
		return "derivative_put_nifty";
	}

	@RequestMapping("/indices_nse")
	public String listIndices() {
		return "indices";
	}

}
