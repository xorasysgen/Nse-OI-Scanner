package nse.skbh.springboot.pojo;

import java.util.List;

public class ParentIndices {

	private int preOpen;
	private String time;
	private int corrOpen;
	private String status;
	private String haltedStatus;
	private int mktOpen;
	private List<Indices> data = null;
	private int code;
	private int corrClose;
	private int preClose;
	private int mktClose;
	public int getPreOpen() {
		return preOpen;
	}
	public void setPreOpen(int preOpen) {
		this.preOpen = preOpen;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getCorrOpen() {
		return corrOpen;
	}
	public void setCorrOpen(int corrOpen) {
		this.corrOpen = corrOpen;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getHaltedStatus() {
		return haltedStatus;
	}
	public void setHaltedStatus(String haltedStatus) {
		this.haltedStatus = haltedStatus;
	}
	public int getMktOpen() {
		return mktOpen;
	}
	public void setMktOpen(int mktOpen) {
		this.mktOpen = mktOpen;
	}
	public List<Indices> getData() {
		return data;
	}
	public void setData(List<Indices> data) {
		this.data = data;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public int getCorrClose() {
		return corrClose;
	}
	public void setCorrClose(int corrClose) {
		this.corrClose = corrClose;
	}
	public int getPreClose() {
		return preClose;
	}
	public void setPreClose(int preClose) {
		this.preClose = preClose;
	}
	public int getMktClose() {
		return mktClose;
	}
	public void setMktClose(int mktClose) {
		this.mktClose = mktClose;
	}
	
	
}
