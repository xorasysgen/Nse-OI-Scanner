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
	private static final String all_nifty_indices="/all_nifty_indices";
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
	private static final String oi_spurts_rise_oi_rise_price = "/oi_spurts_rise_oi_rise_price";
	private static final String oi_spurts_slide_in_price_rise_in_oi = "/oi_spurts_slide_in_price_rise_in_oi";
	private static final String oi_spurts_rise_in_price_slide_in_oi = "/oi_spurts_rise_in_price_slide_in_oi";
	private static final String oi_spurts_slide_in_price_slide_in_oi = "/oi_spurts_slide_in_price_slide_in_oi";
	private static final String advances_declines_bank_nifty = "/advances_declines_bank_nifty";
	private static final String advances_declines_nifty = "/advances_declines_nifty";
	private static final String nifty_top_10_weightage_holdings="/nifty_top_10_weightage_holdings";
	private static final String security_wise_deliverable_positions_data = "/security_wise_deliverable_positions_data";
	private static final String security_var = "/security_var";
	private static final String future_stocks_spike_volume = "/future_stocks_spike_volume";
	private static final String future_stocks_spike_value = "/future_stocks_spike_value";
	private static final String option_chain_reader = "/option_chain_reader";
	private static final String option_chain_reader_all = "/option_chain_reader_all";
	private static final String option_chain_nifty="/option_chain_nifty";
	private static final String top_20_contracts_nse_fo="/top_20_contracts_nse_fo";
	private static final String nifty_50_Options="/nifty_50_Options";
	private static final String banknifty_option_chain_reader="/banknifty_option_chain_reader";
	private static final String banknifty_option_chain_nifty="/banknifty_option_chain_nifty";
	private static final String most_active_securities_market_capitalisation="/most_active_securities_market_capitalisation";
	private static final String forthcoming_dividends="/forthcoming_dividends"; 
	private static final String forthcoming_results="/forthcoming_results";
	private static final String currency_usd_inr ="/currency/usd_inr";
	private static final String intraday_usd_inr_live="/currency/intraday_usd_inr_live";
	private static final String dollar_index_brent_usd_inr="/currency/dollar_index_brent_usd_inr";
	private static final String world_market_indices="/world_market_indices";
	private static final String nifty_future_oi="/nifty_future_oi";
	private static final String bank_nifty_future_oi="/bank_nifty_future_oi";
	private static final String bank_nifty_expiry_day_option_suggestion="/suggestions/bank_nifty_expiry_day_option_suggestion";
	private static final String banknifty_and_nifty_support_resistance="/suggestions/banknifty_and_nifty_support_resistance";
	private static final String non_expiry_day="/suggestions/bank_nifty_expiry_day_option_suggestion/non_expiry_day"; 
	private static final String aggressive_calls="/suggestions/bank_nifty_expiry_day_option_suggestion/aggressive_calls";
	private static final String nifty_roadMap="/suggestions/nifty_roadMap";
	private static final String bank_nifty_roadMap="/suggestions/bank_nifty_roadMap";
	private static final String premium_discount_nifty_banknifty="/suggestions/premium_discount_nifty_banknifty";
	private static final String ohl_strategy_fo="/suggestions/nifty/ohl_strategy/fo";
	private static final String ohl_strategy="/suggestions/nifty/ohl_strategy";
	
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
		list.add(all_nifty_indices);
		list.add(advancesDeclines);
		list.add(advances_declines_bank_nifty);
		list.add(advances_declines_nifty);
		list.add(nifty_top_10_weightage_holdings);
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
		list.add(security_wise_deliverable_positions_data);
		list.add(security_var);
		list.add(future_stocks_spike_value);
		list.add(future_stocks_spike_volume);
		list.add(option_chain_reader);
		list.add(option_chain_reader_all);
		list.add(option_chain_nifty);
		list.add(top_20_contracts_nse_fo);
		list.add(nifty_50_Options);
		list.add(banknifty_option_chain_reader);
		list.add(banknifty_option_chain_nifty);
		list.add(most_active_securities_market_capitalisation);
		list.add(forthcoming_dividends);
		list.add(forthcoming_results);
		list.add(currency_usd_inr);
		list.add(intraday_usd_inr_live);
		list.add(dollar_index_brent_usd_inr);
		list.add(world_market_indices);
		list.add(nifty_future_oi);
		list.add(bank_nifty_future_oi);
		list.add(bank_nifty_expiry_day_option_suggestion);
		list.add(banknifty_and_nifty_support_resistance);
		list.add(non_expiry_day);
		list.add(aggressive_calls);
		list.add(nifty_roadMap);
		list.add(bank_nifty_roadMap);
		list.add(premium_discount_nifty_banknifty);
		list.add(ohl_strategy);
		list.add(ohl_strategy_fo);
		return list;

	}

}
