package nse.skbh.springboot.pojo;

public class OIChangeData {

	private String symbol;
	private String latestOI;
	private String prevOI;
	private String oiChange;
	private String percOIchange;
	private String volume;
	private String valueInLakhs;
	private String underlying;
	private String isFO;
	private String FUTVAL;
	private String OPTVAL;
	private String TOTVAL;
	private String OPVAL;

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getLatestOI() {
		return latestOI;
	}

	public void setLatestOI(String latestOI) {
		this.latestOI = latestOI;
	}

	public String getPrevOI() {
		return prevOI;
	}

	public void setPrevOI(String prevOI) {
		this.prevOI = prevOI;
	}

	public String getOiChange() {
		return oiChange;
	}

	public void setOiChange(String oiChange) {
		this.oiChange = oiChange;
	}

	public String getPercOIchange() {
		return percOIchange;
	}

	public void setPercOIchange(String percOIchange) {
		this.percOIchange = percOIchange;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getValueInLakhs() {
		return valueInLakhs;
	}

	public void setValueInLakhs(String valueInLakhs) {
		this.valueInLakhs = valueInLakhs;
	}

	public String getUnderlying() {
		return underlying;
	}

	public void setUnderlying(String underlying) {
		this.underlying = underlying;
	}

	public String getIsFO() {
		return isFO;
	}

	public void setIsFO(String isFO) {
		this.isFO = isFO;
	}

	public String getFUTVAL() {
		return FUTVAL;
	}

	public void setFUTVAL(String FUTVAL) {
		this.FUTVAL = FUTVAL;
	}

	public String getOPTVAL() {
		return OPTVAL;
	}

	public void setOPTVAL(String OPTVAL) {
		this.OPTVAL = OPTVAL;
	}

	public String getTOTVAL() {
		return TOTVAL;
	}

	public void setTOTVAL(String TOTVAL) {
		this.TOTVAL = TOTVAL;
	}

	public String getOPVAL() {
		return OPVAL;
	}

	public void setOPVAL(String OPVAL) {
		this.OPVAL = OPVAL;
	}

}
