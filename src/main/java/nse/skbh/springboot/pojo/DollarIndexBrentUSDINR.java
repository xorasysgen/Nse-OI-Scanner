package nse.skbh.springboot.pojo;

public class DollarIndexBrentUSDINR {
	
	@Override
	public String toString() {
		return "DollarIndexBrentUSDINR [index=" + index + ", ltp=" + ltp + ", change=" + change + ", changePercentage="
				+ changePercentage + "]";
	}
	private String index;
	private String ltp;
	private String change;
	private String changePercentage;
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
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
	
	

}
