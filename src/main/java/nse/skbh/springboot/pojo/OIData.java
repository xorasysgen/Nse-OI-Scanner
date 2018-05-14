package nse.skbh.springboot.pojo;

import java.util.ArrayList;
import java.util.List;

public class OIData {

	List<Nse> data = new ArrayList<Nse>();

	public List<Nse> getData() {
		return data;
	}

	public void setData(List<Nse> data) {
		this.data = data;
	}

}
