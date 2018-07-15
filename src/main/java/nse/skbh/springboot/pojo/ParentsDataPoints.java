package nse.skbh.springboot.pojo;

import java.util.List;

public class ParentsDataPoints {
	
	List<DataPoints> data;

	@Override
	public String toString() {
		return "ParentsDataPoints [data=" + data + "]";
	}

	public List<DataPoints> getData() {
		return data;
	}

	public void setData(List<DataPoints> data) {
		this.data = data;
	}
	
	

}
