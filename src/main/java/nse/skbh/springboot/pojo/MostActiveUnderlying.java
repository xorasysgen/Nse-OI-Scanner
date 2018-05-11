package nse.skbh.springboot.pojo;

public class MostActiveUnderlying {

	private String UNDERLYINGVALUE;

    private String TOTAL_VALUE;

    private String VOLUME1;

    private String VOLUME2;

    private String OP;

    private String OPENINTEREST;

    private String VALUE2;

    private String FO_SYMBOL;

    private String VALUE1;

    private String TOTAL_VOLUME;

	public String getUNDERLYINGVALUE() {
		return UNDERLYINGVALUE;
	}

	public void setUNDERLYINGVALUE(String uNDERLYINGVALUE) {
		UNDERLYINGVALUE = uNDERLYINGVALUE;
	}

	public String getTOTAL_VALUE() {
		return TOTAL_VALUE;
	}

	public void setTOTAL_VALUE(String tOTAL_VALUE) {
		TOTAL_VALUE = tOTAL_VALUE;
	}

	public String getVOLUME1() {
		return VOLUME1;
	}

	public void setVOLUME1(String vOLUME1) {
		VOLUME1 = vOLUME1;
	}

	public String getVOLUME2() {
		return VOLUME2;
	}

	public void setVOLUME2(String vOLUME2) {
		VOLUME2 = vOLUME2;
	}

	public String getOP() {
		return OP;
	}

	public void setOP(String oP) {
		OP = oP;
	}

	public String getOPENINTEREST() {
		return OPENINTEREST;
	}

	public void setOPENINTEREST(String oPENINTEREST) {
		OPENINTEREST = oPENINTEREST;
	}

	public String getVALUE2() {
		return VALUE2;
	}

	public void setVALUE2(String vALUE2) {
		VALUE2 = vALUE2;
	}

	public String getFO_SYMBOL() {
		return FO_SYMBOL;
	}

	public void setFO_SYMBOL(String fO_SYMBOL) {
		FO_SYMBOL = fO_SYMBOL;
	}

	public String getVALUE1() {
		return VALUE1;
	}

	public void setVALUE1(String vALUE1) {
		VALUE1 = vALUE1;
	}

	public String getTOTAL_VOLUME() {
		return TOTAL_VOLUME;
	}

	public void setTOTAL_VOLUME(String tOTAL_VOLUME) {
		TOTAL_VOLUME = tOTAL_VOLUME;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MostActiveUnderlying [UNDERLYINGVALUE=");
		builder.append(UNDERLYINGVALUE);
		builder.append(", TOTAL_VALUE=");
		builder.append(TOTAL_VALUE);
		builder.append(", VOLUME1=");
		builder.append(VOLUME1);
		builder.append(", VOLUME2=");
		builder.append(VOLUME2);
		builder.append(", OP=");
		builder.append(OP);
		builder.append(", OPENINTEREST=");
		builder.append(OPENINTEREST);
		builder.append(", VALUE2=");
		builder.append(VALUE2);
		builder.append(", FO_SYMBOL=");
		builder.append(FO_SYMBOL);
		builder.append(", VALUE1=");
		builder.append(VALUE1);
		builder.append(", TOTAL_VOLUME=");
		builder.append(TOTAL_VOLUME);
		builder.append("]");
		return builder.toString();
	}
    
    
	
}
