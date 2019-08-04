package nse.skbh.springboot;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import nse.skbh.springboot.logic.CurrencyContracts;
import nse.skbh.springboot.logic.NiftyExpiryDatesNewContracts;
import nse.skbh.springboot.pojo.StockName;


@Controller
@RequestMapping("/")
public class NSESearchController {
	
	@GetMapping("/nifty_weekly")
	public String niftyWeekly(Model model){
		StockName stockName=new StockName();		
		model.addAttribute("stockName", stockName);
		model.addAttribute("actionUri", "/niftyWeeklyContracts"); // unused
		List<String> list =NiftyExpiryDatesNewContracts.getNiftyExpiryDates();
		initModelList(model,list);
		return "get_option_chain_nifty_weekly";
	}
	
	@GetMapping("/bank_nifty_weekly")
	public String bankNiftyWeekly(Model model){
		StockName stockName=new StockName();		
		model.addAttribute("stockName", stockName);
		model.addAttribute("actionUri", "/bankniftyWeeklyContracts");// unused
		List<String> list =NiftyExpiryDatesNewContracts.getNiftyExpiryDates();
		initModelList(model,list);
		return "get_option_chain_banknifty_weekly";
	}
	
	@RequestMapping(value="/currency_weekly",method=RequestMethod.GET)
	public String CurrencyWeekly(Model model){
		StockName stockName=new StockName();		
		model.addAttribute("stockName", stockName);
		model.addAttribute("actionUri", "/CurrencyWeeklyContracts");// unused
		List<String> list =CurrencyContracts.getCurrencyContractsExpiryDates();
		model.addAttribute("dateList", list);
		return "get_option_chain_currency_weekly";
	}
	
	
	
	@RequestMapping(value="/coc",method=RequestMethod.GET)
	public String register(Model model){
		StockName stockName=new StockName();		
		model.addAttribute("stockName", stockName);
		model.addAttribute("actionUri", "/getQuoteFO");
		initModelList(model);
		return "get_quote_fo";
		
	}
	
	
	@RequestMapping(value="/option_chain_stocks_pcr",method=RequestMethod.GET)
	public String OptionChainFutureStocks(Model model){
		StockName stockName=new StockName();		
		model.addAttribute("stockName", stockName);
		model.addAttribute("actionUri", "/option_chain_stocks");
		initModelList(model);
		return "get_option_chain";
		
	}
	
	private void initModelList(Model model) {
		List<String> list;
		String [] array= {"ACC",
				"ADANIENT",
				"ADANIPORTS",
				"ADANIPOWER",
				"AJANTPHARM",
				"ALBK",
				"AMARAJABAT",
				"AMBUJACEM",
				"APOLLOHOSP",
				"APOLLOTYRE",
				"ARVIND",
				"ASHOKLEY",
				"ASIANPAINT",
				"AUROPHARMA",
				"AXISBANK",
				"BAJAJ-AUTO",
				"BAJAJFINSV",
				"BAJFINANCE",
				"BALKRISIND",
				"BANKBARODA",
				"BANKINDIA",
				"BANKNIFTY",
				"BATAINDIA",
				"BEL",
				"BEML",
				"BERGEPAINT",
				"BHARATFIN",
				"BHARATFORG",
				"BHARTIARTL",
				"BHEL",
				"BIOCON",
				"BOSCHLTD",
				"BPCL",
				"BRITANNIA",
				"CADILAHC",
				"CANBK",
				"CANFINHOME",
				"CAPF",
				"CASTROLIND",
				"CEATLTD",
				"CENTURYTEX",
				"CESC",
				"CGPOWER",
				"CHENNPETRO",
				"CHOLAFIN",
				"CIPLA",
				"COALINDIA",
				"COLPAL",
				"CONCOR",
				"CUMMINSIND",
				"DABUR",
				"DALMIABHA",
				"DCBBANK",
				"DHFL",
				"DISHTV",
				"DIVISLAB",
				"DLF",
				"DRREDDY",
				"EICHERMOT",
				"ENGINERSIN",
				"EQUITAS",
				"ESCORTS",
				"EXIDEIND",
				"FEDERALBNK",
				"GAIL",
				"GLENMARK",
				"GMRINFRA",
				"GODFRYPHLP",
				"GODREJCP",
				"GODREJIND",
				"GRANULES",
				"GRASIM",
				"GSFC",
				"HAVELLS",
				"HCC",
				"HCLTECH",
				"HDFC",
				"HDFCBANK",
				"HEROMOTOCO",
				"HEXAWARE",
				"HINDALCO",
				"HINDPETRO",
				"HINDUNILVR",
				"HINDZINC",
				"IBULHSGFIN",
				"ICICIBANK",
				"ICICIPRULI",
				"IDBI",
				"IDEA",
				"IDFC",
				"IDFCBANK",
				"IFCI",
				"IGL",
				"INDIACEM",
				"INDIANB",
				"INDIGO",
				"INDUSINDBK",
				"INFIBEAM",
				"INFRATEL",
				"INFY",
				"IOC",
				"IRB",
				"ITC",
				"JETAIRWAYS",
				"JINDALSTEL",
				"JISLJALEQS",
				"JPASSOCIAT",
				"JSWSTEEL",
				"JUBLFOOD",
				"JUSTDIAL",
				"KAJARIACER",
				"KOTAKBANK",
				"KPIT",
				"KSCL",
				"KTKBANK",
				"L&TFH",
				"LICHSGFIN",
				"LT",
				"LUPIN",
				"M&M",
				"M&MFIN",
				"MANAPPURAM",
				"MARICO",
				"MARUTI",
				"MCDOWELL-N",
				"MCX",
				"MFSL",
				"MGL",
				"MINDTREE",
				"MOTHERSUMI",
				"MRF",
				"MRPL",
				"MUTHOOTFIN",
				"NATIONALUM",
				"NBCC",
				"NCC",
				"NESTLEIND",
				"NHPC",
				"NIFTY",
				"NIITTECH",
				"NMDC",
				"NTPC",
				"OFSS",
				"OIL",
				"ONGC",
				"ORIENTBANK",
				"PAGEIND",
				"PCJEWELLER",
				"PEL",
				"PETRONET",
				"PFC",
				"PIDILITIND",
				"PNB",
				"POWERGRID",
				"PTC",
				"PVR",
				"RAMCOCEM",
				"RAYMOND",
				"RBLBANK",
				"RCOM",
				"RECLTD",
				"RELCAPITAL",
				"RELIANCE",
				"RELINFRA",
				"REPCOHOME",
				"RPOWER",
				"SAIL",
				"SBIN",
				"SHREECEM",
				"SIEMENS",
				"SOUTHBANK",
				"SREINFRA",
				"SRF",
				"SRTRANSFIN",
				"STAR",
				"SUNPHARMA",
				"SUNTV",
				"SUZLON",
				"SYNDIBANK",
				"TATACHEM",
				"TATACOMM",
				"TATAELXSI",
				"TATAGLOBAL",
				"TATAMOTORS",
				"TATAMTRDVR",
				"TATAPOWER",
				"TATASTEEL",
				"TCS",
				"TECHM",
				"TITAN",
				"TORNTPHARM",
				"TORNTPOWER",
				"TV18BRDCST",
				"TVSMOTOR",
				"UBL",
				"UJJIVAN",
				"ULTRACEMCO",
				"UNIONBANK",
				"UPL",
				"VEDL",
				"VGUARD",
				"VOLTAS",
				"WIPRO",
				"WOCKPHARMA",
				"YESBANK",
				"ZEEL"};
		list=Arrays.asList(array);
		model.addAttribute("stockList", list);
	}
	
	
	private void initModelList(Model model, List<String> list) {
		model.addAttribute("dateList", list);
	}
}
