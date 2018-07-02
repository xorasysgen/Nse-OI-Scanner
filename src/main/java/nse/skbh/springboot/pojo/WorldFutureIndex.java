package nse.skbh.springboot.pojo;

public class WorldFutureIndex {
	private String index;
	private String symbol;
	private String month;
	private String ltp;
	private String high;
	private String low;
	private String chg;
	private String chgPer;
	private String time;
	
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getLtp() {
		return ltp;
	}
	public void setLtp(String ltp) {
		this.ltp = ltp;
	}
	public String getHigh() {
		return high;
	}
	public void setHigh(String high) {
		this.high = high;
	}
	public String getLow() {
		return low;
	}
	public void setLow(String low) {
		this.low = low;
	}
	public String getChg() {
		return chg;
	}
	public void setChg(String chg) {
		this.chg = chg;
	}
	public String getChgPer() {
		return chgPer;
	}
	public void setChgPer(String chgPer) {
		this.chgPer = chgPer;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("WorldFutureIndex [index=");
		builder.append(index);
		builder.append(", symbol=");
		builder.append(symbol);
		builder.append(", month=");
		builder.append(month);
		builder.append(", ltp=");
		builder.append(ltp);
		builder.append(", high=");
		builder.append(high);
		builder.append(", low=");
		builder.append(low);
		builder.append(", chg=");
		builder.append(chg);
		builder.append(", chgPer=");
		builder.append(chgPer);
		builder.append(", time=");
		builder.append(time);
		builder.append("]");
		return builder.toString();
	}
	
	

}
