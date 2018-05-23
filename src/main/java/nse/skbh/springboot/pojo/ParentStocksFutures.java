package nse.skbh.springboot.pojo;

import java.util.List;

public class ParentStocksFutures {
	
	private String time;
	private List<StocksFutures> data;
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public List<StocksFutures> getData() {
		return data;
	}
	public void setData(List<StocksFutures> data) {
		this.data = data;
	}
	
	
	
}
