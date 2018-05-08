package nse.skbh.springboot.pojo;

import java.util.List;

public class ParentOIChangeData {

	
	private String time;
	private List<OIChangeData> data;
	private String previousMarketDate;
	private String currentMarketDate;
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public List<OIChangeData> getData() {
		return data;
	}
	public void setData(List<OIChangeData> data) {
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
