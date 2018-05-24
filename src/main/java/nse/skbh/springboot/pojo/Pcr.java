package nse.skbh.springboot.pojo;

public class Pcr {

	private String puts;
	private String putsVolume;
	private String callsVolume;
	private String calls;
	private String pcrVolume;
	private String pcrOI;

	public String getPuts() {
		return puts;
	}

	public void setPuts(String puts) {
		this.puts = puts;
	}

	public String getPutsVolume() {
		return putsVolume;
	}

	public void setPutsVolume(String putsVolume) {
		this.putsVolume = putsVolume;
	}

	public String getCallsVolume() {
		return callsVolume;
	}

	public void setCallsVolume(String callsVolume) {
		this.callsVolume = callsVolume;
	}

	public String getCalls() {
		return calls;
	}

	public void setCalls(String calls) {
		this.calls = calls;
	}

	public String getPcrVolume() {
		return pcrVolume;
	}

	public void setPcrVolume(String pcrVolume) {
		this.pcrVolume = pcrVolume;
	}

	public String getPcrOI() {
		return pcrOI;
	}

	public void setPcrOI(String pcrOI) {
		this.pcrOI = pcrOI;
	}

	@Override
	public String toString() {
		return "Pcr [puts=" + puts + ", putsVolume=" + putsVolume + ", callsVolume=" + callsVolume + ", calls=" + calls
				+ ", pcrVolume=" + pcrVolume + ", pcrOI=" + pcrOI + "]";
	}

}
