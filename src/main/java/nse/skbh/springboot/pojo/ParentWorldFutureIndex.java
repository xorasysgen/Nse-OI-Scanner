package nse.skbh.springboot.pojo;

import java.util.List;

public class ParentWorldFutureIndex {
	
	List<WorldFutureIndex> data;

	public List<WorldFutureIndex> getData() {
		return data;
	}

	public void setData(List<WorldFutureIndex> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ParentWorldFutureIndex [data=");
		builder.append(data);
		builder.append("]");
		return builder.toString();
	}
	
	

}
