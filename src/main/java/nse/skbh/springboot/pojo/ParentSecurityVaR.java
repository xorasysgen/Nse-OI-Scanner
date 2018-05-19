package nse.skbh.springboot.pojo;

import java.util.ArrayList;
import java.util.List;

public class ParentSecurityVaR {
	List<SecurityVaR> data = new ArrayList<SecurityVaR>();

	public List<SecurityVaR> getData() {
		return data;
	}

	public void setData(List<SecurityVaR> data) {
		this.data = data;
	}

}
