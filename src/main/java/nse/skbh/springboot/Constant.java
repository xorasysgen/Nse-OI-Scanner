package nse.skbh.springboot;

import java.util.ArrayList;
import java.util.List;

final class Constant {

	private static final String openInterest = "/open_interest";
	private static final String topGainer = "/top_gainer";
	private static final String topLooser = "/top_looser";
	private static final String oiSpurts = "/oi_spurts";
	private static final String foStocks = "/fo_stocks";
	private static final String mostActiveVolume = "/most_active_volume";
	private static final String mostActiveValue = "/most_active_value";
	private static final String indices = "/indices";
	private static final String advancesDeclines = "/advances_declines";
	private static final String volumeGainers = "/volume_gainers";
	private static final String most_active_intraday = "/most_active_intraday";
	private static final String bankNiftyVolume = "/derivative/bank_nifty_volume";
	private static final String call_all = "/derivative/call/call_all";
	private static final String call_nifty = "/derivative/call/call_nifty";
	private static final String call_nifty_bank = "/derivative/call/call_nifty_bank";
	private static final String call_stocks = "/derivative/call/call_stocks";
	private static final String put_all = ("/derivative/put/put_all");
	private static final String put_nifty = "/derivative/put/put_nifty";
	private static final String put_nifty_bank = "/derivative/put/put_nifty_bank";
	private static final String put_stocks = "/derivative/put/put_stocks";
	private static final String oi_spurts_rise_oi_rise_price = "oi_spurts_rise_oi_rise_price";
	private static final String oi_spurts_slide_in_price_rise_in_oi = "oi_spurts_slide_in_price_rise_in_oi";
	private static final String oi_spurts_rise_in_price_slide_in_oi = "oi_spurts_rise_in_price_slide_in_oi";
	private static final String oi_spurts_slide_in_price_slide_in_oi = "oi_spurts_slide_in_price_slide_in_oi";

	public static List<String> getListOfService() {
		List<String> list = new ArrayList<>();
		list.add(openInterest);
		list.add(topGainer);
		list.add(topLooser);
		list.add(oiSpurts);
		list.add(foStocks);
		list.add(mostActiveVolume);
		list.add(mostActiveValue);
		list.add(indices);
		list.add(advancesDeclines);
		list.add(volumeGainers);
		list.add(most_active_intraday);
		list.add(bankNiftyVolume);
		list.add(call_all);
		list.add(call_nifty);
		list.add(call_nifty_bank);
		list.add(call_stocks);
		list.add(put_all);
		list.add(put_nifty);
		list.add(put_nifty_bank);
		list.add(put_stocks);
		list.add(oi_spurts_rise_oi_rise_price);
		list.add(oi_spurts_rise_in_price_slide_in_oi);
		list.add(oi_spurts_slide_in_price_rise_in_oi);
		list.add(oi_spurts_slide_in_price_slide_in_oi);
		return list;

	}

}
