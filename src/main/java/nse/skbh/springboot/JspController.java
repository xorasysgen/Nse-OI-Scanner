package nse.skbh.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JspController {

	@RequestMapping("/boot")
	public String boot() {
		return "boot";
	}


	@RequestMapping("/bank_nifty_page")
	public String bankNifty() {
		return "bank_nifty";
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
	
	@RequestMapping("/market_capitalisation_most_active_year_wise_public")
	public String marketCapitalisationMostActiveYearWise() {
		return "market_capitalisation_most_active_year_wise";
	}
	

	@RequestMapping("/fostocks")
	public String fostocks() {
		return "fo_stocks";
	}
	@RequestMapping("/nifty_top_ten_heroes_weightage")
	public String getNiftyTopTenWeightage() {
		return "nifty_top_ten_weightage";
	}
	

	@RequestMapping("/top_open_interest")
	public String topOpenInterest() {
		return "top_nse_open_interest";
	}

	@RequestMapping("/most_active_underlying")
	public String mostActiveIntraday() {
		return "most_active_intraday";
	}

	@RequestMapping("/option_chain_nifty_fifty")
	public String optionChainNifty() {
		return "nifty_option_chain";
	}

	@RequestMapping("/bank_nifty_option_chain_12")
	public String bankNiftyOptionChainNifty() {
		return "bank_nifty_option_chain";
	}

	
	@RequestMapping("/bank_nifty_option_chain_12_mobile")
	public String bankNiftyOptionChainNiftyMobile() {
		return "bank_nifty_option_chain_mobile";
	}

	
	@RequestMapping("/option_chain_nifty_fifty_mobile")
	public String optionChainNifty_mobile() {
		return "nifty_option_chain_mobile";
	}

	@RequestMapping("/top_20_contracts_intraday")
	public String Top20ContractsIntraday() {
		return "top_20_contracts";
	}
	
	@RequestMapping("/nifty_50_options_public")
	public String getnifty_50_options() {
		return "nifty_50_options";
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
	@RequestMapping("/all_nifty_indices_nse")
	public String listAllIndices() {
		return "all_nifty_indices";
	}
	
	@RequestMapping("/security_wise_deliverable_positions")
	public String get_security_wise_deliverable_positions_data() {
		return "security_wise_deliverable_positions_data";
	}

	@RequestMapping("/security_var_public")
	public String getSecurity_var_public() {
		return "security_var_nse";
	}

	@RequestMapping("/most_active_future_value_public")
	public String most_active_future_value_public() {
		return "most_active_future_value";
	}

	@RequestMapping("/most_active_future_volume_public")
	public String most_active_future_volume_public() {
		return "most_active_future_volume";
	}
	
	@RequestMapping("/broad_market_indices_all_sectors")
	public String getJspBroadMarketIndicesPublic() {
		return "broad_market_indices_public";
	}
	
	@RequestMapping("/forthcoming_dividends_public")
	public String getForthcomingDividendsPublicc() {
		return "forthcoming_dividends_nse";
	}
	@RequestMapping("/forthcoming_results_public")
	public String getForthComingResultsPublicc() {
		return "forthcoming_results_nse";
	}
	
	@RequestMapping("/option_chain_pcr_reader_months_all")
	public String getOptionChainPcrReader3Months() {
		return "option_chain_pcr_reader_3_months";
	}
	
	@RequestMapping("/world_market_futures")
	public String getWorldMarketFuturesIndices() {
		return "world_market_indices";
	}
	
	@RequestMapping("/cal_sha_avg_price")
	public String getCalShaAvgPrice() {
		return "calculate_shares_average_price";
	}
	
	
	@RequestMapping("/wd_gann_pred")
	public String getGannAngle() {
		return "gann_angle";
	}
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	
	@RequestMapping("/nifty50Intraday_ohl_strategy")
	public String nifty50Intraday() {
		return "nifty50Intraday";
	}
	
	@RequestMapping("/nifty50FOALLIntraday_ohl_strategy")
	public String nifty50FOALLIntraday() {
		return "nifty50FOALLIntraday";
	}
	
	
	
	
}
