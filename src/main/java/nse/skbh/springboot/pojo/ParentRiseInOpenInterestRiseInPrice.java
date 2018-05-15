package nse.skbh.springboot.pojo;

import java.util.List;

public class ParentRiseInOpenInterestRiseInPrice {

	private String time;
	private List<RiseInOpenInterestRiseInPrice> data;
	private String previousMarketDate;
	private String currentMarketDate;
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public List<RiseInOpenInterestRiseInPrice> getData() {
		return data;
	}
	public void setData(List<RiseInOpenInterestRiseInPrice> data) {
		this.data = data;
	}
	public String getPreviousMarketDate() {
		return previousMarketDate;
	}
	public void setPreviousMarketDate(String previousMarketDate) {
		this.previousMarketDate = previousMarketDate;
	}
	public String getCurrentMarketDate() {
		return currentMarketDate;
	}
	public void setCurrentMarketDate(String currentMarketDate) {
		this.currentMarketDate = currentMarketDate;
	}
	
	
}
