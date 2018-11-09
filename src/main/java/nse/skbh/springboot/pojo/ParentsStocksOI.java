package nse.skbh.springboot.pojo;

import java.util.List;

public class ParentsStocksOI {
	
	private List<OI> data;
	private PcrDetail pcr;

	public List<OI> getData() {
		return data;
	}

	public void setData(List<OI> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ParentsOI [data=");
		builder.append(data);
		builder.append("]");
		return builder.toString();
	}

	public PcrDetail getPcr() {
		return pcr;
	}

	public void setPcr(PcrDetail pcr) {
		this.pcr = pcr;
	}

	
	

}
