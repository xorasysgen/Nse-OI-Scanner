package nse.skbh.springboot.pojo;

import java.util.List;

public class ParentBankNiftyVolume {

	public String time;
	public List<BankNiftyVolume> data;
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public List<BankNiftyVolume> getData() {
		return data;
	}
	public void setData(List<BankNiftyVolume> data) {
		this.data = data;
	}
	
	
}
