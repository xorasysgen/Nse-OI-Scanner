package nse.skbh.springboot.pojo;

public class SecurityVaR {

	private String symbol;
	private String series;
	private String securityVaR;
	private String indexVaR;
	private String vaRMargin;
	private String extremeLossRate;
	private String adhocMargin;
	private String applicableMarginRate;
	private String safeOrUnsafe;

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public String getSecurityVaR() {
		return securityVaR;
	}

	public void setSecurityVaR(String securityVaR) {
		this.securityVaR = securityVaR;
	}

	public String getIndexVaR() {
		return indexVaR;
	}

	public void setIndexVaR(String indexVaR) {
		this.indexVaR = indexVaR;
	}

	public String getVaRMargin() {
		return vaRMargin;
	}

	public void setVaRMargin(String vaRMargin) {
		this.vaRMargin = vaRMargin;
	}

	public String getExtremeLossRate() {
		return extremeLossRate;
	}

	public void setExtremeLossRate(String extremeLossRate) {
		this.extremeLossRate = extremeLossRate;
	}

	public String getAdhocMargin() {
		return adhocMargin;
	}

	public void setAdhocMargin(String adhocMargin) {
		this.adhocMargin = adhocMargin;
	}

	public String getApplicableMarginRate() {
		return applicableMarginRate;
	}

	public void setApplicableMarginRate(String applicableMarginRate) {
		this.applicableMarginRate = applicableMarginRate;
	}

	public String getSafeOrUnsafe() {
		return safeOrUnsafe;
	}

	public void setSafeOrUnsafe(String safeOrUnsafe) {
		this.safeOrUnsafe = safeOrUnsafe;
	}

}
