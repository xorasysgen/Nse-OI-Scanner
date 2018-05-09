package nse.skbh.springboot.pojo;

import java.util.List;

public class ParentAdvanceDecline {
	private int results;
	private String success;
	private List<AdvanceDecline> rows;
	public int getResults() {
		return results;
	}
	public void setResults(int results) {
		this.results = results;
	}
	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	public List<AdvanceDecline> getRows() {
		return rows;
	}
	public void setRows(List<AdvanceDecline> rows) {
		this.rows = rows;
	}
	
	
}
