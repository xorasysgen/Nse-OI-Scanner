package nse.skbh.springboot.pojo;

public class PremiumDiscountNiftyBankNifty {
	
	private Float nifty;
	private Float bankNifty;
	
	public Float getNifty() {
		return nifty;
	}
	public void setNifty(Float nifty) {
		this.nifty = nifty;
	}
	public Float getBankNifty() {
		return bankNifty;
	}
	public void setBankNifty(Float bankNifty) {
		this.bankNifty = bankNifty;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PremiumDiscountNiftyBankNifty [nifty=");
		builder.append(nifty);
		builder.append(", bankNifty=");
		builder.append(bankNifty);
		builder.append("]");
		return builder.toString();
	}
	
	

}
