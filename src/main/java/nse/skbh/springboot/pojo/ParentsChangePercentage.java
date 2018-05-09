package nse.skbh.springboot.pojo;

import java.util.List;

public class ParentsChangePercentage {

	
	private int results;
	private String success;
	private List<ChangePercentage> rows;
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
	public List<ChangePercentage> getRows() {
		return rows;
	}
	public void setRows(List<ChangePercentage> rows) {
		this.rows = rows;
	}
	
}
