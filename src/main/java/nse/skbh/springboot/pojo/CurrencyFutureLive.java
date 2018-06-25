package nse.skbh.springboot.pojo;

public class CurrencyFutureLive {
	
	private String expiryDate;
	private String ltp;
	private String change;
	private String changePercentage;
	private String todayDate;
	
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getLtp() {
		return ltp;
	}
	public void setLtp(String ltp) {
		this.ltp = ltp;
	}
	public String getChange() {
		return change;
	}
	public void setChange(String change) {
		this.change = change;
	}
	public String getChangePercentage() {
		return changePercentage;
	}
	public void setChangePercentage(String changePercentage) {
		this.changePercentage = changePercentage;
	}
	public String getTodayDate() {
		return todayDate;
	}
	public void setTodayDate(String todayDate) {
		this.todayDate = todayDate;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CurrencyFutureLive [expiryDate=");
		builder.append(expiryDate);
		builder.append(", ltp=");
		builder.append(ltp);
		builder.append(", change=");
		builder.append(change);
		builder.append(", changePercentage=");
		builder.append(changePercentage);
		builder.append(", todayDate=");
		builder.append(todayDate);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	

}
