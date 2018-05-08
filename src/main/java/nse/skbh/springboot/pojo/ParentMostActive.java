package nse.skbh.springboot.pojo;

import java.util.List;

public class ParentMostActive {

	private String time;
	private List<MostActive> data;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public List<MostActive> getData() {
		return data;
	}

	public void setData(List<MostActive> data) {
		this.data = data;
	}

}
