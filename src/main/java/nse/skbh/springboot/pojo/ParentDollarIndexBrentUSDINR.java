package nse.skbh.springboot.pojo;

import java.util.List;

public class ParentDollarIndexBrentUSDINR {
	
	List<DollarIndexBrentUSDINR> data;

	@Override
	public String toString() {
		return "ParentDollarIndexBrentUSDINR [data=" + data + "]";
	}

	public List<DollarIndexBrentUSDINR> getData() {
		return data;
	}

	public void setData(List<DollarIndexBrentUSDINR> data) {
		this.data = data;
	}
	

}
