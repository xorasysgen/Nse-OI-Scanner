package nse.skbh.springboot.pojo;

public class Services {

	private Integer serviceID;
	private String serviceURI;
	
	
	public Services(Integer serviceID, String serviceURI) {
		super();
		this.serviceID = serviceID;
		this.serviceURI = serviceURI;
	}
	public Services() {
	}
	public Integer getServiceID() {
		return serviceID;
	}
	public void setServiceID(Integer serviceID) {
		this.serviceID = serviceID;
	}
	public String getServiceURI() {
		return serviceURI;
	}
	public void setServiceURI(String serviceURI) {
		this.serviceURI = serviceURI;
	}
	
	
	
	
	
}
