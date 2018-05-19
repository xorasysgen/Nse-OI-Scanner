package nse.skbh.springboot.pojo;

import java.util.LinkedList;
import java.util.List;

public class ParentDeliveryBhavData {

	List<DeliveryBhavData> data = new LinkedList<DeliveryBhavData>();

	public List<DeliveryBhavData> getData() {
		return data;
	}

	public void setData(List<DeliveryBhavData> data) {
		this.data = data;
	}

}
