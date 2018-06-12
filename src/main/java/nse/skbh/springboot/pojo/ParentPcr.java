package nse.skbh.springboot.pojo;

import java.util.List;

public class ParentPcr {
	
	private String overAllPcr;
	private List<Pcr> data;
	
	public String getOverAllPcr() {
		return overAllPcr;
	}
	public void setOverAllPcr(String overAllPcr) {
		this.overAllPcr = overAllPcr;
	}
	public List<Pcr> getData() {
		return data;
	}
	public void setData(List<Pcr> data) {
		this.data = data;
	}
	
	
}
