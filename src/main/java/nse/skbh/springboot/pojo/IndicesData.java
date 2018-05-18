package nse.skbh.springboot.pojo;

public class IndicesData {

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("IndicesData [symbol=");
		builder.append(symbol);
		builder.append(", open=");
		builder.append(open);
		builder.append(", high=");
		builder.append(high);
		builder.append(", low=");
		builder.append(low);
		builder.append(", ltP=");
		builder.append(ltP);
		builder.append(", ptsC=");
		builder.append(ptsC);
		builder.append(", per=");
		builder.append(per);
		builder.append(", trdVol=");
		builder.append(trdVol);
		builder.append(", trdVolM=");
		builder.append(trdVolM);
		builder.append(", ntP=");
		builder.append(ntP);
		builder.append(", mVal=");
		builder.append(mVal);
		builder.append(", wkhi=");
		builder.append(wkhi);
		builder.append(", wklo=");
		builder.append(wklo);
		builder.append(", wkhicmAdj=");
		builder.append(wkhicmAdj);
		builder.append(", wklocmAdj=");
		builder.append(wklocmAdj);
		builder.append(", xDt=");
		builder.append(xDt);
		builder.append(", cAct=");
		builder.append(cAct);
		builder.append(", previousClose=");
		builder.append(previousClose);
		builder.append(", dayEndClose=");
		builder.append(dayEndClose);
		builder.append(", iislPtsChange=");
		builder.append(iislPtsChange);
		builder.append(", iislPercChange=");
		builder.append(iislPercChange);
		builder.append(", yPC=");
		builder.append(yPC);
		builder.append(", mPC=");
		builder.append(mPC);
		builder.append("]");
		return builder.toString();
	}

	private String symbol;
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
	private String wkhicmAdj;
	private String wklocmAdj;
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

	public String getWkhicmAdj() {
		return wkhicmAdj;
	}

	public void setWkhicmAdj(String wkhicmAdj) {
		this.wkhicmAdj = wkhicmAdj;
	}

	public String getWklocmAdj() {
		return wklocmAdj;
	}

	public void setWklocmAdj(String wklocmAdj) {
		this.wklocmAdj = wklocmAdj;
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

}
