package nse.skbh.springboot.pojo;

public class Nse {

	private String date;
	private String ISIN;
	private String Scrip;
	private String Name;
	private String MWPL;
	private String NSE_Open_Interest;
	private Float usedLimit;

	public Float getUsedLimit() {
		return usedLimit;
	}

	public void setUsedLimit(Float usedLimit) {
		this.usedLimit = usedLimit;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getISIN() {
		return ISIN;
	}

	public void setISIN(String iSIN) {
		ISIN = iSIN;
	}

	public String getScrip() {
		return Scrip;
	}

	public void setScrip(String scrip) {
		Scrip = scrip;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	
	public String getMWPL() {
		return MWPL;
	}

	public void setMWPL(String mWPL) {
		MWPL = mWPL;
	}

	public String getNSE_Open_Interest() {
		return NSE_Open_Interest;
	}

	public void setNSE_Open_Interest(String nSE_Open_Interest) {
		NSE_Open_Interest = nSE_Open_Interest;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Nse [date=");
		builder.append(date);
		builder.append(", ISIN=");
		builder.append(ISIN);
		builder.append(", Scrip=");
		builder.append(Scrip);
		builder.append(", Name=");
		builder.append(Name);
		builder.append(", MWPL=");
		builder.append(MWPL);
		builder.append(", NSE_Open_Interest=");
		builder.append(NSE_Open_Interest);
		builder.append(", usedLimit=");
		builder.append(usedLimit);
		builder.append("]");
		return builder.toString();
	}



}
