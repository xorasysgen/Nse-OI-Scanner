package nse.skbh.springboot.pojo;

public class OI {
	
	private String oi_call;
	private String chng_in_oi_call;
	private String volume_call;
	private String iv_call;
	private String ltp_call;
	private String net_chng_call;
	private String bid_qty_call;
	private String bid_price_call;
	private String ask_price_call;
	private String ask_qty_call;
	private String strikePrice;
	private String oi_put;
	private String chng_in_oi_put;
	private String volume_put;
	private String iv_put;
	private String ltp_put;
	private String net_chng_put;
	private String bid_qty_put;
	private String bid_price_put;
	private String ask_price_put;
	private String ask_qty_put;
	public String getOi_call() {
		return oi_call;
	}
	public void setOi_call(String oi_call) {
		this.oi_call = oi_call;
	}
	public String getChng_in_oi_call() {
		return chng_in_oi_call;
	}
	public void setChng_in_oi_call(String chng_in_oi_call) {
		this.chng_in_oi_call = chng_in_oi_call;
	}
	public String getVolume_call() {
		return volume_call;
	}
	public void setVolume_call(String volume_call) {
		this.volume_call = volume_call;
	}
	public String getIv_call() {
		return iv_call;
	}
	public void setIv_call(String iv_call) {
		this.iv_call = iv_call;
	}
	public String getLtp_call() {
		return ltp_call;
	}
	public void setLtp_call(String ltp_call) {
		this.ltp_call = ltp_call;
	}
	public String getNet_chng_call() {
		return net_chng_call;
	}
	public void setNet_chng_call(String net_chng_call) {
		this.net_chng_call = net_chng_call;
	}
	public String getBid_qty_call() {
		return bid_qty_call;
	}
	public void setBid_qty_call(String bid_qty_call) {
		this.bid_qty_call = bid_qty_call;
	}
	public String getBid_price_call() {
		return bid_price_call;
	}
	public void setBid_price_call(String bid_price_call) {
		this.bid_price_call = bid_price_call;
	}
	public String getAsk_price_call() {
		return ask_price_call;
	}
	public void setAsk_price_call(String ask_price_call) {
		this.ask_price_call = ask_price_call;
	}
	public String getAsk_qty_call() {
		return ask_qty_call;
	}
	public void setAsk_qty_call(String ask_qty_call) {
		this.ask_qty_call = ask_qty_call;
	}
	public String getStrikePrice() {
		return strikePrice;
	}
	public void setStrikePrice(String strikePrice) {
		this.strikePrice = strikePrice;
	}
	public String getOi_put() {
		return oi_put;
	}
	public void setOi_put(String oi_put) {
		this.oi_put = oi_put;
	}
	public String getChng_in_oi_put() {
		return chng_in_oi_put;
	}
	public void setChng_in_oi_put(String chng_in_oi_put) {
		this.chng_in_oi_put = chng_in_oi_put;
	}
	public String getVolume_put() {
		return volume_put;
	}
	public void setVolume_put(String volume_put) {
		this.volume_put = volume_put;
	}
	public String getIv_put() {
		return iv_put;
	}
	public void setIv_put(String iv_put) {
		this.iv_put = iv_put;
	}
	public String getLtp_put() {
		return ltp_put;
	}
	public void setLtp_put(String ltp_put) {
		this.ltp_put = ltp_put;
	}
	public String getNet_chng_put() {
		return net_chng_put;
	}
	public void setNet_chng_put(String net_chng_put) {
		this.net_chng_put = net_chng_put;
	}
	public String getBid_qty_put() {
		return bid_qty_put;
	}
	public void setBid_qty_put(String bid_qty_put) {
		this.bid_qty_put = bid_qty_put;
	}
	public String getBid_price_put() {
		return bid_price_put;
	}
	public void setBid_price_put(String bid_price_put) {
		this.bid_price_put = bid_price_put;
	}
	public String getAsk_price_put() {
		return ask_price_put;
	}
	public void setAsk_price_put(String ask_price_put) {
		this.ask_price_put = ask_price_put;
	}
	public String getAsk_qty_put() {
		return ask_qty_put;
	}
	public void setAsk_qty_put(String ask_qty_put) {
		this.ask_qty_put = ask_qty_put;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OI [oi_call=");
		builder.append(oi_call);
		builder.append(", chng_in_oi_call=");
		builder.append(chng_in_oi_call);
		builder.append(", volume_call=");
		builder.append(volume_call);
		builder.append(", iv_call=");
		builder.append(iv_call);
		builder.append(", ltp_call=");
		builder.append(ltp_call);
		builder.append(", net_chng_call=");
		builder.append(net_chng_call);
		builder.append(", bid_qty_call=");
		builder.append(bid_qty_call);
		builder.append(", bid_price_call=");
		builder.append(bid_price_call);
		builder.append(", ask_price_call=");
		builder.append(ask_price_call);
		builder.append(", ask_qty_call=");
		builder.append(ask_qty_call);
		builder.append(", strikePrice=");
		builder.append(strikePrice);
		builder.append(", oi_put=");
		builder.append(oi_put);
		builder.append(", chng_in_oi_put=");
		builder.append(chng_in_oi_put);
		builder.append(", volume_put=");
		builder.append(volume_put);
		builder.append(", iv_put=");
		builder.append(iv_put);
		builder.append(", ltp_put=");
		builder.append(ltp_put);
		builder.append(", net_chng_put=");
		builder.append(net_chng_put);
		builder.append(", bid_qty_put=");
		builder.append(bid_qty_put);
		builder.append(", bid_price_put=");
		builder.append(bid_price_put);
		builder.append(", ask_price_put=");
		builder.append(ask_price_put);
		builder.append(", ask_qty_put=");
		builder.append(ask_qty_put);
		builder.append("]");
		return builder.toString();
	}
	
	

}
