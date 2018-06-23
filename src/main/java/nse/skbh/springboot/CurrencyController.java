package nse.skbh.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import nse.skbh.springboot.logic.CsvReaderCurrency;
import nse.skbh.springboot.pojo.USDINRCurrency;

@RestController
@RequestMapping("/currency")
public class CurrencyController {

	@RequestMapping("/usd_inr")
	@ResponseBody
	public USDINRCurrency getUSDINRCurrency() {
		return new CsvReaderCurrency().getForthComingResultsFYFromNSEOnline();

	}



	

}
