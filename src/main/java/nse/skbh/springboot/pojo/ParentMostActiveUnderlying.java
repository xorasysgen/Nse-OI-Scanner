package nse.skbh.springboot.pojo;

import java.util.List;

public class ParentMostActiveUnderlying {
	
	private String time;

    private List<MostActiveUnderlying> data;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public List<MostActiveUnderlying> getData() {
		return data;
	}

	public void setData(List<MostActiveUnderlying> data) {
		this.data = data;
	}
    
    

}
