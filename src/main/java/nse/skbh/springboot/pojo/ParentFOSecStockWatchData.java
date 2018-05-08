package nse.skbh.springboot.pojo;

import java.util.List;

public class ParentFOSecStockWatchData {
	public String totValMil;
	public String time;
	public int dec;
	public String totVal;
	public List<FOSecStockWatchData> data;
	public String totQty;
	public String totQtyMil;
	public int noChg;
	public int adv;
	public String getTotValMil() {
		return totValMil;
	}
	public void setTotValMil(String totValMil) {
		this.totValMil = totValMil;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getDec() {
		return dec;
	}
	public void setDec(int dec) {
		this.dec = dec;
	}
	public String getTotVal() {
		return totVal;
	}
	public void setTotVal(String totVal) {
		this.totVal = totVal;
	}
	public List<FOSecStockWatchData> getData() {
		return data;
	}
	public void setData(List<FOSecStockWatchData> data) {
		this.data = data;
	}
	public String getTotQty() {
		return totQty;
	}
	public void setTotQty(String totQty) {
		this.totQty = totQty;
	}
	public String getTotQtyMil() {
		return totQtyMil;
	}
	public void setTotQtyMil(String totQtyMil) {
		this.totQtyMil = totQtyMil;
	}
	public int getNoChg() {
		return noChg;
	}
	public void setNoChg(int noChg) {
		this.noChg = noChg;
	}
	public int getAdv() {
		return adv;
	}
	public void setAdv(int adv) {
		this.adv = adv;
	}
	
	
}
