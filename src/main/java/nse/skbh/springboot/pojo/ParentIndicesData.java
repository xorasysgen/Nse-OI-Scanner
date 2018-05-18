package nse.skbh.springboot.pojo;

import java.util.List;

public class ParentIndicesData {

	private String trdVolumesumMil;
	private String time;
	private List<LatestIndicesData> latestData;
	private int declines;
	private String trdValueSum;
	private List<IndicesData> data;
	private String trdValueSumMil;
	private int unchanged;
	private String trdVolumesum;
	private int advances;

	public String getTrdVolumesumMil() {
		return trdVolumesumMil;
	}

	public void setTrdVolumesumMil(String trdVolumesumMil) {
		this.trdVolumesumMil = trdVolumesumMil;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public List<LatestIndicesData> getLatestData() {
		return latestData;
	}

	public void setLatestData(List<LatestIndicesData> latestData) {
		this.latestData = latestData;
	}

	public int getDeclines() {
		return declines;
	}

	public void setDeclines(int declines) {
		this.declines = declines;
	}

	public String getTrdValueSum() {
		return trdValueSum;
	}

	public void setTrdValueSum(String trdValueSum) {
		this.trdValueSum = trdValueSum;
	}

	public List<IndicesData> getData() {
		return data;
	}

	public void setData(List<IndicesData> data) {
		this.data = data;
	}

	public String getTrdValueSumMil() {
		return trdValueSumMil;
	}

	public void setTrdValueSumMil(String trdValueSumMil) {
		this.trdValueSumMil = trdValueSumMil;
	}

	public int getUnchanged() {
		return unchanged;
	}

	public void setUnchanged(int unchanged) {
		this.unchanged = unchanged;
	}

	public String getTrdVolumesum() {
		return trdVolumesum;
	}

	public void setTrdVolumesum(String trdVolumesum) {
		this.trdVolumesum = trdVolumesum;
	}

	public int getAdvances() {
		return advances;
	}

	public void setAdvances(int advances) {
		this.advances = advances;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ParentIndicesData [trdVolumesumMil=");
		builder.append(trdVolumesumMil);
		builder.append(", time=");
		builder.append(time);
		builder.append(", latestData=");
		builder.append(latestData);
		builder.append(", declines=");
		builder.append(declines);
		builder.append(", trdValueSum=");
		builder.append(trdValueSum);
		builder.append(", data=");
		builder.append(data);
		builder.append(", trdValueSumMil=");
		builder.append(trdValueSumMil);
		builder.append(", unchanged=");
		builder.append(unchanged);
		builder.append(", trdVolumesum=");
		builder.append(trdVolumesum);
		builder.append(", advances=");
		builder.append(advances);
		builder.append("]");
		return builder.toString();
	}
	
	

}
