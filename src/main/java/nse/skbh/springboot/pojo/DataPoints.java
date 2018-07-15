package nse.skbh.springboot.pojo;

public class DataPoints {

	private String ltpDataPointcordinate;
	private String ltp;
	private String symbol;
	private String name;
	private String s3;
	private String s2;
	private String s1;
	private String pivotPoints;
	private String r1;
	private String r2;
	private String r3;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getS3() {
		return s3;
	}
	public void setS3(String s3) {
		this.s3 = s3;
	}
	public String getS2() {
		return s2;
	}
	public void setS2(String s2) {
		this.s2 = s2;
	}
	public String getS1() {
		return s1;
	}
	public void setS1(String s1) {
		this.s1 = s1;
	}
	public String getPivotPoints() {
		return pivotPoints;
	}
	public void setPivotPoints(String pivotPoints) {
		this.pivotPoints = pivotPoints;
	}
	public String getR1() {
		return r1;
	}
	public void setR1(String r1) {
		this.r1 = r1;
	}
	public String getR2() {
		return r2;
	}
	public void setR2(String r2) {
		this.r2 = r2;
	}
	public String getR3() {
		return r3;
	}
	public void setR3(String r3) {
		this.r3 = r3;
	}
	

	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getLtp() {
		return ltp;
	}
	public void setLtp(String ltp) {
		this.ltp = ltp;
	}
	@Override
	public String toString() {
		return "DataPoints [ltp=" + ltp + ", symbol=" + symbol + ", name=" + name + ", s3=" + s3 + ", s2=" + s2
				+ ", s1=" + s1 + ", pivotPoints=" + pivotPoints + ", r1=" + r1 + ", r2=" + r2 + ", r3=" + r3 + "]";
	}
	public String getLtpDataPointcordinate() {
		return ltpDataPointcordinate;
	}
	public void setLtpDataPointcordinate(String ltpDataPointcordinate) {
		this.ltpDataPointcordinate = ltpDataPointcordinate;
	}
	
	
	
}
