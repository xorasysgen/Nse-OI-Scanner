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
		return list;

	}

}
