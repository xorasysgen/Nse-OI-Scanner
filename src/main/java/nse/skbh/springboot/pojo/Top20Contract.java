package nse.skbh.springboot.pojo;

public class Top20Contract {
	
	private String instrumentType;
	private String underlying;
	private String expiryDate;
	private String optionType;
	private String strikePrice;
	private String prevClose;
	private String openPrice;
	private String highPrice;
	private String lowPrice;
	private String lastPrice;
	private String volumeContracts;
	private String premiumTurnoverLacs;
	private String turnoverLacs;
	private String underlyingValue;
	
	public String getInstrumentType() {
		return instrumentType;
	}
	public void setInstrumentType(String instrumentType) {
		this.instrumentType = instrumentType;
	}
	public String getUnderlying() {
		return underlying;
	}
	public void setUnderlying(String underlying) {
		this.underlying = underlying;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getOptionType() {
		return optionType;
	}
	public void setOptionType(String optionType) {
		this.optionType = optionType;
	}
	public String getStrikePrice() {
		return strikePrice;
	}
	public void setStrikePrice(String strikePrice) {
		this.strikePrice = strikePrice;
	}
	public String getPrevClose() {
		return prevClose;
	}
	public void setPrevClose(String prevClose) {
		this.prevClose = prevClose;
	}
	public String getOpenPrice() {
		return openPrice;
	}
	public void setOpenPrice(String openPrice) {
		this.openPrice = openPrice;
	}
	public String getHighPrice() {
		return highPrice;
	}
	public void setHighPrice(String highPrice) {
		this.highPrice = highPrice;
	}
	public String getLowPrice() {
		return lowPrice;
	}
	public void setLowPrice(String lowPrice) {
		this.lowPrice = lowPrice;
	}
	public String getLastPrice() {
		return lastPrice;
	}
	public void setLastPrice(String lastPrice) {
		this.lastPrice = lastPrice;
	}
	public String getVolumeContracts() {
		return volumeContracts;
	}
	public void setVolumeContracts(String volumeContracts) {
		this.volumeContracts = volumeContracts;
	}
	public String getTurnoverLacs() {
		return turnoverLacs;
	}
	public void setTurnoverLacs(String turnoverLacs) {
		this.turnoverLacs = turnoverLacs;
	}
	public String getUnderlyingValue() {
		return underlyingValue;
	}
	public void setUnderlyingValue(String underlyingValue) {
		this.underlyingValue = underlyingValue;
	}
	public String getPremiumTurnoverLacs() {
		return premiumTurnoverLacs;
	}
	public void setPremiumTurnoverLacs(String premiumTurnoverLacs) {
		this.premiumTurnoverLacs = premiumTurnoverLacs;
	}
	
	
	
	

}
