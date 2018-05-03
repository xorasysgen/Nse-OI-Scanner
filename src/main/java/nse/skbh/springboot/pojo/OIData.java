package nse.skbh.springboot.pojo;

import java.util.ArrayList;
import java.util.List;

public class OIData {

	List<Nse> OpenInterest = new ArrayList<Nse>();

	public List<Nse> getOpenInterest() {
		return OpenInterest;
	}

	public void setOpenInterest(List<Nse> openInterest) {
		OpenInterest = openInterest;
	}

}
