package nse.skbh.springboot.pojo;

import java.util.List;

public class ParentBankNiftyFuture {
	private String valid;
	private String tradedDate;
	private String eqLink;
	private List<BankNiftyFuture> data = null;
	private String companyName;
	private String lastUpdateTime;
	private Object isinCode;
	private String ocLink;
	public String getValid() {
		return valid;
	}
	public void setValid(String valid) {
		this.valid = valid;
	}
	public String getTradedDate() {
		return tradedDate;
	}
	public void setTradedDate(String tradedDate) {
		this.tradedDate = tradedDate;
	}
	public String getEqLink() {
		return eqLink;
	}
	public void setEqLink(String eqLink) {
		this.eqLink = eqLink;
	}
	public List<BankNiftyFuture> getData() {
		return data;
	}
	public void setData(List<BankNiftyFuture> data) {
		this.data = data;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(String lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	public Object getIsinCode() {
		return isinCode;
	}
	public void setIsinCode(Object isinCode) {
		this.isinCode = isinCode;
	}
	public String getOcLink() {
		return ocLink;
	}
	public void setOcLink(String ocLink) {
		this.ocLink = ocLink;
	}
	
	
}
