package nse.skbh.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import nse.skbh.springboot.logic.CsvReaderCurrency;
import nse.skbh.springboot.logic.CsvReaderToGetCurrencyLive;
import nse.skbh.springboot.pojo.CurrencyFutureLive;
import nse.skbh.springboot.pojo.USDINRCurrency;

@RestController
@RequestMapping("/currency")
public class CurrencyController {

	@RequestMapping("/usd_inr")
	@ResponseBody
	public USDINRCurrency getUSDINRCurrency() {
		return new CsvReaderCurrency().getForthComingResultsFYFromNSEOnline();

	}
	
	@RequestMapping("/intraday_usd_inr_live")
	@ResponseBody
	public CurrencyFutureLive getIntradayUSDINRCurrency() {
		return new CsvReaderToGetCurrencyLive().getCsvReaderToGetCurrencyLive();

	}



	

}
