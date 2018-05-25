package nse.skbh.springboot.pojo;

import java.util.List;

public class ParentsOI {
	
	private List<OI> data;

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

	
	

}
