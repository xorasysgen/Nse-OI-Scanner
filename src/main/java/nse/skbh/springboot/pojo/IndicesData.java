package nse.skbh.springboot.pojo;

public class IndicesData {

	private String symbol;
	private String weightage;
	private String weightageOld;
	private String signal;
	private String open;
	private String high;
	private String low;
	private String ltP;
	private String ptsC;
	private String per;
	private String trdVol;
	private String trdVolM;
	private String ntP;
	private String mVal;
	private String wkhi;
	private String wklo;
	private String wkhicm_adj;
	private String wklocm_adj;
	private String xDt;
	private String cAct;
	private String previousClose;
	private String dayEndClose;
	private String iislPtsChange;
	private String iislPercChange;
	private String yPC;
	private String mPC;
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getWeightage() {
		return weightage;
	}
	public void setWeightage(String weightage) {
		this.weightage = weightage;
	}
	public String getOpen() {
		return open;
	}
	public void setOpen(String open) {
		this.open = open;
	}
	public String getHigh() {
		return high;
	}
	public void setHigh(String high) {
		this.high = high;
	}
	public String getLow() {
		return low;
	}
	public void setLow(String low) {
		this.low = low;
	}
	public String getLtP() {
		return ltP;
	}
	public void setLtP(String ltP) {
		this.ltP = ltP;
	}
	public String getPtsC() {
		return ptsC;
	}
	public void setPtsC(String ptsC) {
		this.ptsC = ptsC;
	}
	public String getPer() {
		return per;
	}
	public void setPer(String per) {
		this.per = per;
	}
	public String getTrdVol() {
		return trdVol;
	}
	public void setTrdVol(String trdVol) {
		this.trdVol = trdVol;
	}
	public String getTrdVolM() {
		return trdVolM;
	}
	public void setTrdVolM(String trdVolM) {
		this.trdVolM = trdVolM;
	}
	public String getNtP() {
		return ntP;
	}
	public void setNtP(String ntP) {
		this.ntP = ntP;
	}
	public String getmVal() {
		return mVal;
	}
	public void setmVal(String mVal) {
		this.mVal = mVal;
	}
	public String getWkhi() {
		return wkhi;
	}
	public void setWkhi(String wkhi) {
		this.wkhi = wkhi;
	}
	public String getWklo() {
		return wklo;
	}
	public void setWklo(String wklo) {
		this.wklo = wklo;
	}
	public String getWkhicm_adj() {
		return wkhicm_adj;
	}
	public void setWkhicm_adj(String wkhicm_adj) {
		this.wkhicm_adj = wkhicm_adj;
	}
	public String getWklocm_adj() {
		return wklocm_adj;
	}
	public void setWklocm_adj(String wklocm_adj) {
		this.wklocm_adj = wklocm_adj;
	}
	public String getxDt() {
		return xDt;
	}
	public void setxDt(String xDt) {
		this.xDt = xDt;
	}
	public String getcAct() {
		return cAct;
	}
	public void setcAct(String cAct) {
		this.cAct = cAct;
	}
	public String getPreviousClose() {
		return previousClose;
	}
	public void setPreviousClose(String previousClose) {
		this.previousClose = previousClose;
	}
	public String getDayEndClose() {
		return dayEndClose;
	}
	public void setDayEndClose(String dayEndClose) {
		this.dayEndClose = dayEndClose;
	}
	public String getIislPtsChange() {
		return iislPtsChange;
	}
	public void setIislPtsChange(String iislPtsChange) {
		this.iislPtsChange = iislPtsChange;
	}
	public String getIislPercChange() {
		return iislPercChange;
	}
	public void setIislPercChange(String iislPercChange) {
		this.iislPercChange = iislPercChange;
	}
	public String getyPC() {
		return yPC;
	}
	public void setyPC(String yPC) {
		this.yPC = yPC;
	}
	public String getmPC() {
		return mPC;
	}
	public void setmPC(String mPC) {
		this.mPC = mPC;
	}
	
	
	public String getWeightageOld() {
		return weightageOld;
	}
	public void setWeightageOld(String weightageOld) {
		this.weightageOld = weightageOld;
	}
	public String getSignal() {
		return signal;
	}
	public void setSignal(String signal) {
		this.signal = signal;
	}
	
	@Override
	public String toString() {
		return "IndicesData [symbol=" + symbol + ", weightage=" + weightage + ", open=" + open + ", high=" + high
				+ ", low=" + low + ", ltP=" + ltP + ", ptsC=" + ptsC + ", per=" + per + ", trdVol=" + trdVol
				+ ", trdVolM=" + trdVolM + ", ntP=" + ntP + ", mVal=" + mVal + ", wkhi=" + wkhi + ", wklo=" + wklo
				+ ", wkhicm_adj=" + wkhicm_adj + ", wklocm_adj=" + wklocm_adj + ", xDt=" + xDt + ", cAct=" + cAct
				+ ", previousClose=" + previousClose + ", dayEndClose=" + dayEndClose + ", iislPtsChange="
				+ iislPtsChange + ", iislPercChange=" + iislPercChange + ", yPC=" + yPC + ", mPC=" + mPC + "]";
	}

	

}
