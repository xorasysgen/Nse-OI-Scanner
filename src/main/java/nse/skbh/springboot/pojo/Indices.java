package nse.skbh.springboot.pojo;

public class Indices {
	
	private String name;
	private String lastPrice;
	private String change;
	private String pChange;
	private String imgFileName;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastPrice() {
		return lastPrice;
	}
	public void setLastPrice(String lastPrice) {
		this.lastPrice = lastPrice;
	}
	public String getChange() {
		return change;
	}
	public void setChange(String change) {
		this.change = change;
	}
	public String getpChange() {
		return pChange;
	}
	public void setpChange(String pChange) {
		this.pChange = pChange;
	}
	public String getImgFileName() {
		return imgFileName;
	}
	public void setImgFileName(String imgFileName) {
		this.imgFileName = imgFileName;
	}
	
	
}
