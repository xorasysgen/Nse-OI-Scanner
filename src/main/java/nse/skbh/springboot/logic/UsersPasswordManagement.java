package nse.skbh.springboot.logic;

import java.util.LinkedHashMap;
import java.util.Map;

public class UsersPasswordManagement {
	
	Map<String,String> dataMap=new LinkedHashMap<String,String>();

	public Map<String, String> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, String> dataMap) {
		this.dataMap = dataMap;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UsersPasswordManagement [dataMap=");
		builder.append(dataMap);
		builder.append("]");
		return builder.toString();
	}
	
	

}
