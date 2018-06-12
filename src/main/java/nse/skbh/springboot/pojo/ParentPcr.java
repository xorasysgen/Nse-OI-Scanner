package nse.skbh.springboot.pojo;

import java.util.List;

public class ParentPcr {
	
	private String overAllPcr;
	private List<PcrDetail> data;
	
	public String getOverAllPcr() {
		return overAllPcr;
	}

	public List<PcrDetail> getData() {
		return data;
	}

	public void setData(List<PcrDetail> data) {
		this.data = data;
	}

	public void setOverAllPcr(String overAllPcr) {
		this.overAllPcr = overAllPcr;
	}
	
	
	
	
}
