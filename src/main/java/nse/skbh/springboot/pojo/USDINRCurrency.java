package nse.skbh.springboot.pojo;

public class USDINRCurrency {
	private String date;
	private String open;
	private String high;
	private String low;
	private String close;
	private String ltp;
	private String settlePrice;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getOpen() {
		return open;
	}
	public void setOpen(String open) {
		this.open = open;
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
	public String getClose() {
		return close;
	}
	public void setClose(String close) {
		this.close = close;
	}
	@Override
	public String toString() {
		return "USDINRCurrency [date=" + date + ", open=" + open + ", high=" + high + ", low=" + low + ", close="
				+ close + ", ltp=" + ltp + ", settlePrice=" + settlePrice + "]";
	}
	public String getLtp() {
		return ltp;
	}
	public void setLtp(String ltp) {
		this.ltp = ltp;
	}
	public String getSettlePrice() {
		return settlePrice;
	}
	public void setSettlePrice(String settlePrice) {
		this.settlePrice = settlePrice;
	}
	
	
	
	

}
