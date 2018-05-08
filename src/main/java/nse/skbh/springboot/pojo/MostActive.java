package nse.skbh.springboot.pojo;

public class MostActive {

	private String symbol;
	private String series;
	private Object openPrice;
	private Object highPrice;
	private Object lowPrice;
	private String ltp;
	private String previousPrice;
	private String netPrice;
	private String tradedQuantity;
	private String turnoverInLakhs;
	private String lastCorpAnnouncementDate;
	private String lastCorpAnnouncement;
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getSeries() {
		return series;
	}
	public void setSeries(String series) {
		this.series = series;
	}
	public Object getOpenPrice() {
		return openPrice;
	}
	public void setOpenPrice(Object openPrice) {
		this.openPrice = openPrice;
	}
	public Object getHighPrice() {
		return highPrice;
	}
	public void setHighPrice(Object highPrice) {
		this.highPrice = highPrice;
	}
	public Object getLowPrice() {
		return lowPrice;
	}
	public void setLowPrice(Object lowPrice) {
		this.lowPrice = lowPrice;
	}
	public String getLtp() {
		return ltp;
	}
	public void setLtp(String ltp) {
		this.ltp = ltp;
	}
	public String getPreviousPrice() {
		return previousPrice;
	}
	public void setPreviousPrice(String previousPrice) {
		this.previousPrice = previousPrice;
	}
	public String getNetPrice() {
		return netPrice;
	}
	public void setNetPrice(String netPrice) {
		this.netPrice = netPrice;
	}
	public String getTradedQuantity() {
		return tradedQuantity;
	}
	public void setTradedQuantity(String tradedQuantity) {
		this.tradedQuantity = tradedQuantity;
	}
	public String getTurnoverInLakhs() {
		return turnoverInLakhs;
	}
	public void setTurnoverInLakhs(String turnoverInLakhs) {
		this.turnoverInLakhs = turnoverInLakhs;
	}
	public String getLastCorpAnnouncementDate() {
		return lastCorpAnnouncementDate;
	}
	public void setLastCorpAnnouncementDate(String lastCorpAnnouncementDate) {
		this.lastCorpAnnouncementDate = lastCorpAnnouncementDate;
	}
	public String getLastCorpAnnouncement() {
		return lastCorpAnnouncement;
	}
	public void setLastCorpAnnouncement(String lastCorpAnnouncement) {
		this.lastCorpAnnouncement = lastCorpAnnouncement;
	}
	
	
	
	
}
