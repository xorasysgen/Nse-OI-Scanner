package nse.skbh.springboot.pojo;

import java.util.List;

public class ParentMostActiveCallPutAll {

	private String time;
	private List<MostActiveCallPutAll> data;
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public List<MostActiveCallPutAll> getData() {
		return data;
	}
	public void setData(List<MostActiveCallPutAll> data) {
		this.data = data;
	}
	
	
}
