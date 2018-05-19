package nse.skbh.springboot.pojo;

public class SecurityVaR {

	private String symbol;
	private String series;
	private String securityVars;
	private String indexVars;
	private String varsMargin;
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

	public String getSecurityVars() {
		return securityVars;
	}

	public void setSecurityVars(String securityVars) {
		this.securityVars = securityVars;
	}

	public String getIndexVars() {
		return indexVars;
	}

	public void setIndexVars(String indexVars) {
		this.indexVars = indexVars;
	}

	public String getVarsMargin() {
		return varsMargin;
	}

	public void setVarsMargin(String varsMargin) {
		this.varsMargin = varsMargin;
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
