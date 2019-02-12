package nse.skbh.springboot;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import nse.skbh.springboot.logic.BankNiftyFutureOIReader;
import nse.skbh.springboot.logic.BankNiftyOptionChainReader;
import nse.skbh.springboot.logic.BroadMarketIndices;
import nse.skbh.springboot.logic.CsvReader;
import nse.skbh.springboot.logic.CsvReaderForthComingDividend;
import nse.skbh.springboot.logic.CsvReaderResultsForthComingFY;
import nse.skbh.springboot.logic.DatFileReader;
import nse.skbh.springboot.logic.HoldingFinderService;
import nse.skbh.springboot.logic.HtmlReaderindices;
import nse.skbh.springboot.logic.Nifty50Options;
import nse.skbh.springboot.logic.OptionChainReader;
import nse.skbh.springboot.logic.ReadURI;
import nse.skbh.springboot.logic.RestTemplateProvider;
import nse.skbh.springboot.logic.Top20ContractsReader;
import nse.skbh.springboot.logic.ZerodhaTool;
import nse.skbh.springboot.pojo.ForthComingDividend;
import nse.skbh.springboot.pojo.GainerLosser;
import nse.skbh.springboot.pojo.IndicesData;
import nse.skbh.springboot.pojo.MarketCapitalisation;
import nse.skbh.springboot.pojo.Nse;
import nse.skbh.springboot.pojo.OIData;
import nse.skbh.springboot.pojo.ParentAdvanceDecline;
import nse.skbh.springboot.pojo.ParentBankNiftyFuture;
import nse.skbh.springboot.pojo.ParentDeliveryBhavData;
import nse.skbh.springboot.pojo.ParentFOSecStockWatchData;
import nse.skbh.springboot.pojo.ParentIndices;
import nse.skbh.springboot.pojo.ParentIndicesData;
import nse.skbh.springboot.pojo.ParentMarketCapitalisation;
import nse.skbh.springboot.pojo.ParentMostActive;
import nse.skbh.springboot.pojo.ParentMostActiveUnderlying;
import nse.skbh.springboot.pojo.ParentOIChangeData;
import nse.skbh.springboot.pojo.ParentPcr;
import nse.skbh.springboot.pojo.ParentRiseInOpenInterestRiseInPrice;
import nse.skbh.springboot.pojo.ParentSecurityVaR;
import nse.skbh.springboot.pojo.ParentStocksFutures;
import nse.skbh.springboot.pojo.ParentTop20Contract;
import nse.skbh.springboot.pojo.ParentVolumeGainer25;
import nse.skbh.springboot.pojo.ParentWorldFutureIndex;
import nse.skbh.springboot.pojo.ParentsForthComingResultsFY;
import nse.skbh.springboot.pojo.ParentsNiftyIndices;
import nse.skbh.springboot.pojo.ParentsOI;
import nse.skbh.springboot.pojo.ParentsStocksOI;
import nse.skbh.springboot.pojo.Pcr;

@RestController
public class WebBoot {

	@RequestMapping("/mkt_open_status")
	public String smeNormalMktStatus() {
		RestTemplate restTemplate = new RestTemplateProvider().getRestTemplate();
		ResponseEntity<String> response = restTemplate
				.getForEntity("https://nseindia.com/emerge/homepage/smeNormalMktStatus.json", String.class);
		String string = response.getBody();
		return string;

	}
	
	@RequestMapping("/next_trading_date")
	public String getNextTradingDate() {
		RestTemplate restTemplate = new RestTemplateProvider().getRestTemplate();
		ResponseEntity<String> response = restTemplate
				.getForEntity("https://www.nseindia.com/homeNextDate.htm", String.class);
		String string = response.getBody();
		return string;

	}
	
	@RequestMapping("/zerodha")
	public String zerodhaFutureUrl() {
		return ZerodhaTool.getZerodhaFuturesURL();
	}
	

	@RequestMapping("/option_chain_reader")
	public Pcr getOptionChainData() {
		return OptionChainReader.getOptionDataPCR();

	}
	
	@RequestMapping("/option_chain_reader_all")
	public ParentPcr getThreeMonthOptionDataPCR() {
		return OptionChainReader.getThreeMonthOptionDataPCR();

	}
	
	
	@RequestMapping("/option_chain_nifty")
	public ParentsOI getOptionChainNiftyData() {
		return OptionChainReader.getNiftyOptionChain();

	}
	
	
	@RequestMapping("/option_chain_stocks/{id}")
	public ParentsStocksOI getOptionChainStocksData(@PathVariable String id) {
		if(id!=null) {
			if(id.length()>20)
				id="ITC";
			else if(id.equalsIgnoreCase("BANKNIFTY") || id.equalsIgnoreCase("NIFTY"))
				id="ITC";
			
		}
		
		return OptionChainReader.getStockOptionChain(id);
	}
	
	
	
	
	@RequestMapping("/nifty_weekly_optionChain/{id}")
	public ParentsStocksOI getNiftyWeeklyOptionChainData(@PathVariable String id) {
		if(id!=null) {
			return OptionChainReader.getNiftyWeeklyOptionChain(id);
		}
		return null;
		
	}
	
	@RequestMapping("/banknifty_weekly_optionChain/{id}")
	public ParentsStocksOI getBankNiftyWeeklyOptionChainData(@PathVariable String id) {
		if(id!=null) {
			return OptionChainReader.getBankNiftyWeeklyOptionChain(id);
		}
		return null;
		
	}
	
	
	@RequestMapping("/banknifty_option_chain_reader")
	public Pcr getbankNiftyOptionChainData() {
		return BankNiftyOptionChainReader.getBankNiftyOptionDataPCR();
		
	}
	
	@RequestMapping("/banknifty_option_chain_nifty")
	public ParentsOI getBankNiftyOptionChainNiftyData() {
		return BankNiftyOptionChainReader.getBankNiftyOptionChain();

	}
	
	@RequestMapping("/top_20_contracts_nse_fo")
	public ParentTop20Contract getTop20Contracts() {
		return Top20ContractsReader.getTop20ContractsNSE();

	}
	@RequestMapping("/nifty_50_Options")
	public ParentTop20Contract getNifty50Options() {
		return Nifty50Options.getNifty50OOptionsContractsNSE();
	}
	

	@RequestMapping("/future_stocks_spike_volume")
	public ParentStocksFutures futOPTSTK() {
		RestTemplate restTemplate = new RestTemplateProvider().getRestTemplate();
		ResponseEntity<ParentStocksFutures> response = restTemplate.getForEntity(
				"https://www.nseindia.com/live_market/dynaContent/live_analysis/most_active/FutOPTSTKVolume.json",
				ParentStocksFutures.class);
		ParentStocksFutures string = response.getBody();
		return string;

	}

	@RequestMapping("/future_stocks_spike_value")
	public ParentStocksFutures futOPTSTKValue() {
		RestTemplate restTemplate = new RestTemplateProvider().getRestTemplate();
		ResponseEntity<ParentStocksFutures> response = restTemplate.getForEntity(
				"https://www.nseindia.com/live_market/dynaContent/live_analysis/most_active/FutOPTSTKValue.json",
				ParentStocksFutures.class);
		ParentStocksFutures string = response.getBody();
		return string;

	}

	@RequestMapping("/security_wise_deliverable_positions_data")
	public ParentDeliveryBhavData securityWiseDeliverablePositionsData() {
		ParentDeliveryBhavData results = new CsvReader().getBhavCopyFromNSEOnline();
		return results;
	}

	@RequestMapping("/security_var")
	public ParentSecurityVaR getSecurityVarFromNSe() {
		ParentSecurityVaR results = new DatFileReader().getSecurityVar();
		return results;
	}
	
	@RequestMapping("/forthcoming_dividends")
	public ForthComingDividend ForthcomingDividends() {
		ForthComingDividend results = new CsvReaderForthComingDividend().getForthComingDividendFromNSEOnline();
		return results;
	}
	
	
	@RequestMapping("/forthcoming_results")
	public ParentsForthComingResultsFY ForthComingResults() {
		ParentsForthComingResultsFY results = new CsvReaderResultsForthComingFY().getForthComingResultsFYFromNSEOnline();
		return results;
	}
	

	@RequestMapping("/open_interest")
	public OIData home() {

		List<Nse> nse = null;
		try {
			nse = ReadURI.unpackArchive();
		} catch (IOException e) {
			e.printStackTrace();
		}
		OIData OIData = new OIData();
		OIData.setData(nse);
		return OIData;
		// return new Gson().toJson(OIData);
	}

	@RequestMapping("/top_gainer")
	public GainerLosser topGainer() {
		RestTemplate restTemplate = new RestTemplateProvider().getRestTemplate();
		ResponseEntity<GainerLosser> response = restTemplate.getForEntity(
				"https://www.nseindia.com/live_market/dynaContent/live_analysis/gainers/niftyGainers1.json",
				GainerLosser.class);
		GainerLosser gainerLosser = response.getBody();
		return gainerLosser;
	}

	@RequestMapping("/top_looser")
	public GainerLosser topLosser() {
		RestTemplate restTemplate = new RestTemplateProvider().getRestTemplate();
		ResponseEntity<GainerLosser> response = restTemplate.getForEntity(
				"https://www.nseindia.com/live_market/dynaContent/live_analysis/losers/niftyLosers1.json",
				GainerLosser.class);
		GainerLosser gainerLosser = response.getBody();
		return gainerLosser;
	}

	@RequestMapping("/oi_spurts")
	public ParentOIChangeData topPositiveOIChangeData() {
		RestTemplate restTemplate = new RestTemplateProvider().getRestTemplate();
		ResponseEntity<ParentOIChangeData> response = restTemplate.getForEntity(
				"https://www.nseindia.com/live_market/dynaContent/live_analysis/oi_spurts/topPositiveOIChangeData.json",
				ParentOIChangeData.class);
		ParentOIChangeData parentOIChangeData = response.getBody();
		return parentOIChangeData;
	}

	@RequestMapping("/oi_spurts_rise_oi_rise_price")
	public ParentRiseInOpenInterestRiseInPrice topRiseInOpenInterestRiseInPrice() {
		RestTemplate restTemplate = new RestTemplateProvider().getRestTemplate();
		ResponseEntity<ParentRiseInOpenInterestRiseInPrice> response = restTemplate.getForEntity(
				"https://www.nseindia.com/live_market/dynaContent/live_analysis/oi_spurts/riseInPriceRiseInOI.json",
				ParentRiseInOpenInterestRiseInPrice.class);
		ParentRiseInOpenInterestRiseInPrice parentRiseInOpenInterestRiseInPrice = response.getBody();
		return parentRiseInOpenInterestRiseInPrice;
	}

	@RequestMapping("/oi_spurts_slide_in_price_rise_in_oi")
	public ParentRiseInOpenInterestRiseInPrice topSlideInPriceRiseInOI() {
		RestTemplate restTemplate = new RestTemplateProvider().getRestTemplate();
		ResponseEntity<ParentRiseInOpenInterestRiseInPrice> response = restTemplate.getForEntity(
				"https://www.nseindia.com/live_market/dynaContent/live_analysis/oi_spurts/slideInPriceRiseInOI.json",
				ParentRiseInOpenInterestRiseInPrice.class);
		ParentRiseInOpenInterestRiseInPrice parentRiseInOpenInterestRiseInPrice = response.getBody();
		return parentRiseInOpenInterestRiseInPrice;
	}

	@RequestMapping("/oi_spurts_rise_in_price_slide_in_oi")
	public ParentRiseInOpenInterestRiseInPrice topRiseInPriceSlideInOI() {
		RestTemplate restTemplate = new RestTemplateProvider().getRestTemplate();
		ResponseEntity<ParentRiseInOpenInterestRiseInPrice> response = restTemplate.getForEntity(
				"https://www.nseindia.com/live_market/dynaContent/live_analysis/oi_spurts/riseInPriceSlideInOI.json",
				ParentRiseInOpenInterestRiseInPrice.class);
		ParentRiseInOpenInterestRiseInPrice parentRiseInOpenInterestRiseInPrice = response.getBody();
		return parentRiseInOpenInterestRiseInPrice;
	}

	@RequestMapping("/oi_spurts_slide_in_price_slide_in_oi")
	public ParentRiseInOpenInterestRiseInPrice topSlideInPriceSlideInOI() {
		RestTemplate restTemplate = new RestTemplateProvider().getRestTemplate();
		ResponseEntity<ParentRiseInOpenInterestRiseInPrice> response = restTemplate.getForEntity(
				"https://www.nseindia.com/live_market/dynaContent/live_analysis/oi_spurts/slideInPriceSlideInOI.json",
				ParentRiseInOpenInterestRiseInPrice.class);
		ParentRiseInOpenInterestRiseInPrice parentRiseInOpenInterestRiseInPrice = response.getBody();
		return parentRiseInOpenInterestRiseInPrice;
	}

	@RequestMapping("/fo_stocks")
	public ParentFOSecStockWatchData foSecStockWatch() {
		RestTemplate restTemplate = new RestTemplateProvider().getRestTemplate();
		ResponseEntity<ParentFOSecStockWatchData> response = restTemplate.getForEntity(
				"https://www.nseindia.com/live_market/dynaContent/live_watch/stock_watch/foSecStockWatch.json",
				ParentFOSecStockWatchData.class);
		ParentFOSecStockWatchData parentFOSecStockWatchData = response.getBody();
		return parentFOSecStockWatchData;
	}

	@RequestMapping("/most_active_volume")
	public ParentMostActive mostActiveSecuritiesByVolume() {
		RestTemplate restTemplate = new RestTemplateProvider().getRestTemplate();
		ResponseEntity<ParentMostActive> response = restTemplate.getForEntity(
				"https://www.nseindia.com/live_market/dynaContent/live_analysis/most_active/allTopVolume1.json",
				ParentMostActive.class);
		ParentMostActive parentMostActive = response.getBody();
		return parentMostActive;
	}

	
	@RequestMapping("/most_active_value")
	public ParentMostActive mostActiveSecuritiesByValue() {
		RestTemplate restTemplate = new RestTemplateProvider().getRestTemplate();
		ResponseEntity<ParentMostActive> response = restTemplate.getForEntity(
				"https://www.nseindia.com/live_market/dynaContent/live_analysis/most_active/allTopValue1.json",
				ParentMostActive.class);
		ParentMostActive parentMostActive = response.getBody();
		return parentMostActive;
	}

	@RequestMapping("/most_active_securities_market_capitalisation")
	public ParentMarketCapitalisation MostActiveSecuritiesMarketCapitalisationReader() {
		RestTemplate restTemplate = new RestTemplateProvider().getRestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity(
				"https://nseindia.com/products/dynaContent/equities/equities/json/mostActiveYearly.json",
				String.class);
		
		if (response.getBody() != null) {
			ParentMarketCapitalisation marketCapitalisation  = new Gson().fromJson(response.getBody().toString(),
					ParentMarketCapitalisation.class);
			List<MarketCapitalisation> data=marketCapitalisation.getData();
			for (MarketCapitalisation marketCapitalisation2 : data) {
				marketCapitalisation2.setTotmkt(marketCapitalisation2.getTotmkt()!=null?marketCapitalisation2.getTotmkt().trim():"");
				marketCapitalisation2.setTotturnover(marketCapitalisation2.getTotturnover()!=null?marketCapitalisation2.getTotturnover().trim():"");
			}
			return marketCapitalisation;
		}
		return new ParentMarketCapitalisation();
	}
	
	@RequestMapping("/indices")
	public ParentIndices allIndices() {
		RestTemplate restTemplate = new RestTemplateProvider().getRestTemplate();
		ResponseEntity<ParentIndices> response = restTemplate
				.getForEntity("https://www.nseindia.com/homepage/Indices1.json", ParentIndices.class);
		ParentIndices indices = response.getBody();
		return indices;
	}
	
	@RequestMapping("/all_nifty_indices")
	public ParentsNiftyIndices allNiftyIndices() {
		RestTemplate restTemplate = new RestTemplateProvider().getRestTemplate();
		ResponseEntity<ParentsNiftyIndices> response = restTemplate
				.getForEntity("https://www.nseindia.com/live_market/dynaContent/live_watch/stock_watch/liveIndexWatchData.json", ParentsNiftyIndices.class);
		ParentsNiftyIndices indices = response.getBody();
		return indices;
	}
	
	
	

	@RequestMapping("/advances_declines")
	public ParentAdvanceDecline AdvancesDeclines() {
		RestTemplate restTemplate = new RestTemplateProvider().getRestTemplate();
		ResponseEntity<ParentAdvanceDecline> response = restTemplate.getForEntity(
				"https://www.nseindia.com/live_market/dynaContent/live_analysis/changePercentage.json",
				ParentAdvanceDecline.class);
		ParentAdvanceDecline parentAdvanceDecline = response.getBody();
		return parentAdvanceDecline;
	}

	@RequestMapping("/advances_declines_nifty")
	public ParentIndicesData AdvancesDeclinesNifty() {
		RestTemplate restTemplate = new RestTemplateProvider().getRestTemplate();
		ResponseEntity<ParentIndicesData> response = restTemplate.getForEntity(
				"https://www.nseindia.com/live_market/dynaContent/live_watch/stock_watch/niftyStockWatch.json",
				ParentIndicesData.class);
		ParentIndicesData parentIndicesData = response.getBody();
		return parentIndicesData;
	}
	
	
	@RequestMapping("/nifty_top_10_weightage_holdings")
	public ParentIndicesData getNifty10Holdings() {
	Map<String,String> map=new HoldingFinderService().getTempCalulationNIFTY50Top10HoldingsDateFile();
	RestTemplate restTemplate = new RestTemplateProvider().getRestTemplate();
	ResponseEntity<ParentIndicesData> response = restTemplate.getForEntity(
			"https://www.nseindia.com/live_market/dynaContent/live_watch/stock_watch/niftyStockWatch.json",
			ParentIndicesData.class);
	ParentIndicesData parentIndicesData = response.getBody();
	List<IndicesData> data=parentIndicesData.getData();
	if(map!=null) {
	List<IndicesData> newData=new ArrayList<IndicesData>();
	for (Iterator<IndicesData> iterator = data.iterator(); iterator.hasNext();) {
		IndicesData indicesData = (IndicesData) iterator.next();
		if(map!=null) {
			String w=map.get(indicesData.getSymbol());
			if(w!=null) {
				indicesData.setWeightage(w.trim());
				newData.add(indicesData);
			}
		}
	}
	parentIndicesData.setData(newData);
	}
	return parentIndicesData;
	
	}
	
	
	

	@RequestMapping("/advances_declines_bank_nifty")
	public ParentIndicesData AdvancesDeclinesBankNifty() {
		RestTemplate restTemplate = new RestTemplateProvider().getRestTemplate();
		ResponseEntity<ParentIndicesData> response = restTemplate.getForEntity(
				"https://www.nseindia.com/live_market/dynaContent/live_watch/stock_watch/bankNiftyStockWatch.json",
				ParentIndicesData.class);
		ParentIndicesData parentIndicesData = response.getBody();
		List<IndicesData> data = parentIndicesData.getData();
		for (IndicesData indicesData : data) {
			List<String> list=ArtificialIIntelligenceStrategies.calculateOHLBuySell(indicesData.getOpen(), indicesData.getHigh(), indicesData.getLow(), indicesData.getLtP(), indicesData.getPreviousClose());
			if(list!=null && list.size()>0) {
				String signal=list.get(2);
				indicesData.setSignal(signal);
			}
			if (indicesData.getSymbol().equals("KOTAKBANK")) {
				indicesData.setWeightage("13.12%");
				indicesData.setWeightageOld("13.99%");
			}

			if (indicesData.getSymbol().equals("INDUSINDBK")) {
				indicesData.setWeightage("7.43%");
				indicesData.setWeightageOld("8.36%");
			}
			if (indicesData.getSymbol().equals("YESBANK")) {
				indicesData.setWeightage("2.92%");
				indicesData.setWeightageOld("5.77%");
			}
			if (indicesData.getSymbol().equals("FEDERALBNK")) {
				indicesData.setWeightage("1.21%");
				indicesData.setWeightageOld("1.36%");
			}
			if (indicesData.getSymbol().equals("HDFCBANK")) {
				indicesData.setWeightage("37.04%");
				indicesData.setWeightageOld("34.49%");
			}

			if (indicesData.getSymbol().equals("AXISBANK")) {
				indicesData.setWeightage("9.96%");
				indicesData.setWeightageOld("7.70%");
			}
			if (indicesData.getSymbol().equals("RBLBANK")) {
				indicesData.setWeightage("1.66%");
				indicesData.setWeightageOld("1.60%");
			}

			if (indicesData.getSymbol().equals("SBIN")) {
				indicesData.setWeightage("8.57%");
				indicesData.setWeightageOld("7.92%");
			}
			

			if (indicesData.getSymbol().equals("PNB")) {
				indicesData.setWeightage("00.00%");
				indicesData.setWeightageOld("00.00%");
			}

			if (indicesData.getSymbol().equals("IDFCBANK")) {
				indicesData.setWeightage("00.00%");
				indicesData.setWeightageOld("00.00%");
			}
			

			if (indicesData.getSymbol().equals("BANKBARODA")) {
				indicesData.setWeightage("0.82%");
				indicesData.setWeightageOld("1.23%");
				}
				
			if (indicesData.getSymbol().equals("ICICIBANK")) {
				indicesData.setWeightage("16.93%");
				indicesData.setWeightageOld("15.81%");
			}

		}
		parentIndicesData.setData(data);
		return parentIndicesData;
	}

	@RequestMapping("/volume_gainers")
	public ParentVolumeGainer25 volumeGainers() {
		RestTemplate restTemplate = new RestTemplateProvider().getRestTemplate();
		ResponseEntity<ParentVolumeGainer25> response = restTemplate.getForEntity(
				"https://www.nseindia.com/live_market/dynaContent/live_analysis/volume_spurts/volume_spurts.json",
				ParentVolumeGainer25.class);
		ParentVolumeGainer25 parentVolumeGainer25 = response.getBody();
		return parentVolumeGainer25;
	}

	@RequestMapping("/most_active_intraday")
	public ParentMostActiveUnderlying mostActiveUnderlying() {
		RestTemplate restTemplate = new RestTemplateProvider().getRestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity(
				"https://www.nseindia.com/live_market/dynaContent/live_analysis/underlyings/ActiveUnderlyingsValue.json",
				String.class);
		if (response.getBody() != null) {
			ParentMostActiveUnderlying parentMostActiveUnderlying = new Gson().fromJson(response.getBody().toString(),
					ParentMostActiveUnderlying.class);
			return parentMostActiveUnderlying;
		}
		return null;
	}
	
	@RequestMapping("/broad_market_indices")
	public String getBroadMarketIndices() {
		return BroadMarketIndices.getBroadMarketIndices();
	}
	
	
	@RequestMapping("/world_market_indices")
	public ParentWorldFutureIndex getWorldMarketIndices() {
		return HtmlReaderindices.getParentWorldFutureIndex();
	}
	
	@RequestMapping("/nifty_future_oi")
	public ParentBankNiftyFuture getNiftyFutureOI() {
		return BankNiftyFutureOIReader.getNiftyFutureOIReader();
	}
	
	@RequestMapping("/bank_nifty_future_oi")
	public ParentBankNiftyFuture getBankNiftyFutureOI() {
		return BankNiftyFutureOIReader.getBankNiftyFutureOIReader();
	}

	
	
}
