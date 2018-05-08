package nse.skbh.springboot.pojo;

import java.util.List;

public class GainerLosser {

	public String time;
	public List<Data> data;
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public List<Data> getData() {
		return data;
	}
	public void setData(List<Data> data) {
		this.data = data;
	}
	
}
