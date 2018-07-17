package nse.skbh.springboot;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nse.skbh.springboot.logic.NiftyAndBankNiftySupportResistance;
import nse.skbh.springboot.logic.Top20ContractsReader;
import nse.skbh.springboot.pojo.OptionSuggestion;
import nse.skbh.springboot.pojo.ParentOptionSuggestion;
import nse.skbh.springboot.pojo.ParentsDataPoints;

@RestController
@RequestMapping("/suggestions")
public class ArtificialIIntelligenceStrategies {
	
	@GetMapping("/bank_nifty_expiry_day_option_suggestion")
	public ParentOptionSuggestion getbankNiftyOptionFinderExpiryDay() {
		Map<String,String> map=Top20ContractsReader.bankNiftyOptionFinder();
		ParentOptionSuggestion parentOptionSuggestion=new ParentOptionSuggestion();
		List<OptionSuggestion> data=null;
		if(map!=null) {
			data=new LinkedList<>();
			for(Map.Entry<String, String> temp:map.entrySet()) {
				OptionSuggestion optionSuggestion=new OptionSuggestion();
				optionSuggestion.setOptionTypeStrikePrice(temp.getValue());
				data.add(optionSuggestion);
			}
		}
		parentOptionSuggestion.setData(data);
		return parentOptionSuggestion;

	}
	
	@GetMapping("/bank_nifty_expiry_day_option_suggestion/non_expiry_day")
	public ParentOptionSuggestion getbankNiftyOptionFinderNonExpiryDay() {
		Map<String,String> map=Top20ContractsReader.bankNiftyOptionFinderNonExpiryDay();
		ParentOptionSuggestion parentOptionSuggestion=new ParentOptionSuggestion();
		List<OptionSuggestion> data=null;
		if(map!=null) {
			data=new LinkedList<>();
			for(Map.Entry<String, String> temp:map.entrySet()) {
				OptionSuggestion optionSuggestion=new OptionSuggestion();
				optionSuggestion.setOptionTypeStrikePrice(temp.getValue());
				data.add(optionSuggestion);
			}
		}
		parentOptionSuggestion.setData(data);
		return parentOptionSuggestion;

	}
	
	@GetMapping("/banknifty_and_nifty_support_resistance")
	public ParentsDataPoints getDataPointsNiftyAndBankNifty() {
		return NiftyAndBankNiftySupportResistance.excuteParallelProcess();
	}
	
	
	
}
