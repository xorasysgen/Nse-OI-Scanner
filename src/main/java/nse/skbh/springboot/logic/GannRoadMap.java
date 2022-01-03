package nse.skbh.springboot.logic;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

import nse.skbh.springboot.pojo.RoadMapDataPoints;

public class GannRoadMap {
	
	private final static Double degree_0P0625 = 0.0625;
	private final static Double degree_0P125 = 0.125;
	private final static Double degree_p25 = 0.25;
	private final static Double degree_0P375 = 0.375;
	private final static Double degree_0P50 = 0.50;
	private final static Double degree_0P625 = 0.625;
	private final static Double degree_0P75 = 0.75;
	private final static Double degree_0P1 = 1.0;


	/**
	 * @throws NumberFormatException
	 */
	public static RoadMapDataPoints roadMap(String ltp_input,String close_input,String open_input,String symbolName) throws NumberFormatException {
		Double ltp_double=Double.parseDouble(ltp_input);
		Double close=Double.parseDouble(close_input);
		Double sqrt=Math.sqrt(close);
		WeakHashMap<String,Double> map=new WeakHashMap<String,Double>();
		List<Double> dataPoints=new LinkedList<Double>();
		
		Double up0=sqrt+degree_0P0625;
		up0=new BigDecimal(up0*up0).round(MathContext.DECIMAL32).doubleValue();
		Double up1=sqrt+degree_0P125;
		up1=new BigDecimal(up1*up1).round(MathContext.DECIMAL32).doubleValue();
		Double up2=sqrt+degree_p25;
		up2=new BigDecimal(up2*up2).round(MathContext.DECIMAL32).doubleValue();
		Double up3=sqrt+degree_0P375;
		up3=new BigDecimal(up3*up3).round(MathContext.DECIMAL32).doubleValue();
		Double up4=sqrt+degree_0P50;
		up4=new BigDecimal(up4*up4).round(MathContext.DECIMAL32).doubleValue();
		Double up5=sqrt+degree_0P625;
		up5=new BigDecimal(up5*up5).round(MathContext.DECIMAL32).doubleValue();
		Double up6=sqrt+degree_0P75;
		up6=new BigDecimal(up6*up6).round(MathContext.DECIMAL32).doubleValue();
		
		Double up7=sqrt+degree_0P1;
		up7=new BigDecimal(up7*up7).round(MathContext.DECIMAL32).doubleValue();
		
		Double down0=sqrt-degree_0P0625;
		down0=new BigDecimal(down0*down0).round(MathContext.DECIMAL32).doubleValue();
		Double down1=sqrt-degree_0P125;
		down1=new BigDecimal(down1*down1).round(MathContext.DECIMAL32).doubleValue();
		Double down2=sqrt-degree_p25;
		down2=new BigDecimal(down2*down2).round(MathContext.DECIMAL32).doubleValue();
		Double down3=sqrt-degree_0P375;
		down3=new BigDecimal(down3*down3).round(MathContext.DECIMAL32).doubleValue();
		Double down4=sqrt-degree_0P50;
		down4=new BigDecimal(down4*down4).round(MathContext.DECIMAL32).doubleValue();
		Double down5=sqrt-degree_0P625;
		down5=new BigDecimal(down5*down5).round(MathContext.DECIMAL32).doubleValue();
		Double down6=sqrt-degree_0P75;
		down6=new BigDecimal(down6*down6).round(MathContext.DECIMAL32).doubleValue();
		
		Double down7=sqrt-degree_0P1;
		down7=new BigDecimal(down7*down7).round(MathContext.DECIMAL32).doubleValue();
		
	
		dataPoints.add(down0);
		dataPoints.add(down1);
		dataPoints.add(down2);
		dataPoints.add(down3);
		dataPoints.add(down4);
		dataPoints.add(down5);
		dataPoints.add(down6);
		dataPoints.add(down7);
		dataPoints.add(up0);
		dataPoints.add(up1);
		dataPoints.add(up2);
		dataPoints.add(up3);
		dataPoints.add(up4);
		dataPoints.add(up5);
		dataPoints.add(up6);
		dataPoints.add(up7);
		
		map.put("s0open", Math.abs(down0-ltp_double));
		map.put("s1", Math.abs(down1-ltp_double));
		map.put("s2", Math.abs(down2-ltp_double));
		map.put("s3", Math.abs(down3-ltp_double));
		map.put("s4", Math.abs(down4-ltp_double));
		map.put("s5", Math.abs(down5-ltp_double));
		map.put("s6", Math.abs(down6-ltp_double));
		map.put("s7", Math.abs(down7-ltp_double));
		map.put("r0open", Math.abs(up0-ltp_double));
		map.put("r1", Math.abs(up1-ltp_double));
		map.put("r2", Math.abs(up2-ltp_double));
		map.put("r3", Math.abs(up3-ltp_double));
		map.put("r4", Math.abs(up4-ltp_double));
		map.put("r5", Math.abs(up5-ltp_double));
		map.put("r6", Math.abs(up6-ltp_double));
		map.put("r7", Math.abs(up7-ltp_double));
		 Map<Object, Object> sortedMap= Utils.sortTwoStringKeyValueHashMapByValuesDoubleType(map);
		 Map.Entry<Object,Object> entry = sortedMap.entrySet().iterator().next();
		 String key = entry.getKey().toString();
		 
		 String openDistance=findNearValueObject(dataPoints,open_input);
		 String closeDistance=findNearValueObject(dataPoints,close_input);
		 RoadMapDataPoints roadMapDataPoints=new RoadMapDataPoints();
		 roadMapDataPoints.setR0open(up0.toString());
		 roadMapDataPoints.setR1(up1.toString());
		 roadMapDataPoints.setR2(up2.toString());
		 roadMapDataPoints.setR3(up3.toString());
		 roadMapDataPoints.setR4(up4.toString());
		 roadMapDataPoints.setR5(up5.toString());
		 roadMapDataPoints.setR6(up6.toString());
		 roadMapDataPoints.setR7(up7.toString());
		 roadMapDataPoints.setS0Open(down0.toString());
		 roadMapDataPoints.setS1(down1.toString());
		 roadMapDataPoints.setS2(down2.toString());
		 roadMapDataPoints.setS3(down3.toString());
		 roadMapDataPoints.setS4(down4.toString());
		 roadMapDataPoints.setS5(down5.toString());
		 roadMapDataPoints.setS6(down6.toString());
		 roadMapDataPoints.setS7(down7.toString());
		 roadMapDataPoints.setSymbol(symbolName);
		 roadMapDataPoints.setLtpDataPointcordinate(key);
		 roadMapDataPoints.setCloseDataPointcordinate(closeDistance);
		 roadMapDataPoints.setOpenDataPointcordinate(openDistance);
		 map.clear();
		 dataPoints.clear();
		 
		 return roadMapDataPoints;
	}
	
	
	
	private static String findNearValueObject(List<Double> dataPoints,String price) {
		WeakHashMap<String,Double> map=new WeakHashMap<String,Double>();
		Double customPrice=Double.parseDouble(price);
		
		map.put("s0open", Math.abs(dataPoints.get(0)-customPrice));
		map.put("s1", Math.abs(dataPoints.get(1)-customPrice));
		map.put("s2", Math.abs(dataPoints.get(2)-customPrice));
		map.put("s3", Math.abs(dataPoints.get(3)-customPrice));
		map.put("s4", Math.abs(dataPoints.get(4)-customPrice));
		map.put("s5", Math.abs(dataPoints.get(5)-customPrice));
		map.put("s6", Math.abs(dataPoints.get(6)-customPrice));
		map.put("s7", Math.abs(dataPoints.get(7)-customPrice));
		map.put("r0open", Math.abs(dataPoints.get(8)-customPrice));
		map.put("r1", Math.abs(dataPoints.get(9)-customPrice));
		map.put("r2", Math.abs(dataPoints.get(10)-customPrice));
		map.put("r3", Math.abs(dataPoints.get(11)-customPrice));
		map.put("r4", Math.abs(dataPoints.get(12)-customPrice));
		map.put("r5", Math.abs(dataPoints.get(13)-customPrice));
		map.put("r6", Math.abs(dataPoints.get(14)-customPrice));
		map.put("r7", Math.abs(dataPoints.get(15)-customPrice));
		
		 Map<Object, Object> sortedMap= Utils.sortTwoStringKeyValueHashMapByValuesDoubleType(map);
		 Map.Entry<Object,Object> entry = sortedMap.entrySet().iterator().next();
		 String keyDistance = entry.getKey().toString();
		return keyDistance;
	}
		

}
