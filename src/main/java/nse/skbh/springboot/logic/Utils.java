package nse.skbh.springboot.logic;
import java.security.MessageDigest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;
import java.util.stream.Collectors;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class Utils {

	private static Date dayBeforeYesterday(int dayBack) {
		final Calendar cal = Calendar.getInstance();
		if (dayBack == 1)
			dayBack = -1;
		
		if (dayBack == 2)
			dayBack = -2;

		if (dayBack == 3)
			dayBack = -3;

		if (dayBack == 4)
			dayBack = -4;

		if (dayBack == 5)
			dayBack = -5;

		if (dayBack == 6)
			dayBack = -6;

		cal.add(Calendar.DATE, dayBack);
		return cal.getTime();
	}

	private static Date yesterday() {
		final Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		return cal.getTime();
	}

	public static String getYesterdayDateString() {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		return dateFormat.format(yesterday());

	}

	public static String getdayBeforeYesterdayDateString(int dayBack) {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		return dateFormat.format(dayBeforeYesterday(dayBack));

	}

	public static String formatDate_ddMMyyyy(Date date) {
		DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
		return dateFormat.format(date);

	}
	
	
	public static String formatDate_ddMMyy(Date date) {
		DateFormat dateFormat = new SimpleDateFormat("ddMMyy");
		return dateFormat.format(date);

	}

	public static String getDateBasedOnNSEVaRFile() {

		Calendar c = Calendar.getInstance();
		// Set the calendar to the current date
		c.clear();
		String fDate = formatDate_ddMMyyyy(new Date());
		Integer year = Integer.parseInt(fDate.substring(04, 8));
		Integer month = Integer.parseInt(fDate.substring(02, 04));
		Integer date = Integer.parseInt(fDate.substring(0, 2));
		c.set(year, month - 1, date); // month start from 0 - 11
		Integer dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		if (dayOfWeek == Calendar.FRIDAY) {
			c.add(Calendar.DATE, 0); // If it's Friday does not skip to Monday
		} else if (dayOfWeek == Calendar.SATURDAY) {
			c.add(Calendar.DATE, 2); // If it's Saturday so skip to Monday
		} else {
			c.add(Calendar.DATE, 0);
		}
		Date preparedDate = c.getTime();
		String formatedPreparedDate = formatDate_ddMMyyyy(preparedDate);
		return formatedPreparedDate;

	}

	public static String getDateToIgnoreWeekEndClose() {

		Calendar c = Calendar.getInstance();
		// Set the calendar to the current date
		c.clear();
		String fDate = formatDate_ddMMyyyy(new Date());
		Integer year = Integer.parseInt(fDate.substring(04, 8));
		Integer month = Integer.parseInt(fDate.substring(02, 04));
		Integer date = Integer.parseInt(fDate.substring(0, 2));
		c.set(year, month - 1, date); // month start from 0 - 11
		Integer dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		if (dayOfWeek == Calendar.FRIDAY) {
			c.add(Calendar.DATE, 0); // If it's Friday don`t skip to Monday
		} else if (dayOfWeek == Calendar.SATURDAY) {
			c.add(Calendar.DATE, -1); // If it's Saturday so skip to Monday
		} else if (dayOfWeek == Calendar.SUNDAY) {
			c.add(Calendar.DATE, -2); // If it's Saturday so skip to Monday
		} else {
			c.add(Calendar.DATE, -1);
		}
		Date preparedDate = c.getTime();
		String formatedPreparedDate = formatDate_ddMMyyyy(preparedDate);
		return formatedPreparedDate;

	}
	
	
	
	public static String getDateToIgnoreWeekEndCloseOpenInterest() {

		Calendar c = Calendar.getInstance();
		// Set the calendar to the current date
		c.clear();
		String fDate = formatDate_ddMMyyyy(new Date());
		Integer year = Integer.parseInt(fDate.substring(04, 8));
		Integer month = Integer.parseInt(fDate.substring(02, 04));
		Integer date = Integer.parseInt(fDate.substring(0, 2));
		c.set(year, month - 1, date); // month start from 0 - 11
		Integer dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		if (dayOfWeek == Calendar.FRIDAY) {
			c.add(Calendar.DATE, 0); // If it's Friday don`t skip to Monday
		} else if (dayOfWeek == Calendar.SATURDAY) {
			c.add(Calendar.DATE, -1); // If it's Saturday so skip to Monday
		} else if (dayOfWeek == Calendar.SUNDAY) {
			c.add(Calendar.DATE, -2); // If it's Saturday so skip to Monday
		} else {
			c.add(Calendar.DATE, 0);
		}
		Date preparedDate = c.getTime();
		String formatedPreparedDate = formatDate_ddMMyyyy(preparedDate);
		return formatedPreparedDate;

	}
	
	
	
	public static String getSecurityVarDateBasedOnNSEVaRFile() {

		Calendar c = Calendar.getInstance();
		// Set the calendar to the current date
		c.clear();
		String fDate = formatDate_ddMMyyyy(new Date());
		Integer year = Integer.parseInt(fDate.substring(04, 8));
		Integer month = Integer.parseInt(fDate.substring(02, 04));
		Integer date = Integer.parseInt(fDate.substring(0, 2));
		c.set(year, month - 1, date); // month start from 0 - 11
		Integer dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		if (dayOfWeek == Calendar.FRIDAY) {
			c.add(Calendar.DATE, -1); // If it's Friday does not skip to Monday
		} else if (dayOfWeek == Calendar.SATURDAY) {
			c.add(Calendar.DATE, -1); // If it's Saturday so skip to Monday
		} else if (dayOfWeek == Calendar.SUNDAY) {
			c.add(Calendar.DATE, -2); // If it's Saturday so skip to Monday
		}
		else {
			c.add(Calendar.DATE, 0);
		}
		Date preparedDate = c.getTime();
		String formatedPreparedDate = formatDate_ddMMyyyy(preparedDate);
		return formatedPreparedDate;

	}

	
	public static Integer compareDates(String date) {
		SimpleDateFormat sf=new SimpleDateFormat("ddMMMyy");
		Date expiry = null;
		
		try {
			expiry = sf.parse(date);
		} catch (ParseException exceptionObject) {
			exceptionObject.printStackTrace();
		}
		Date current=new Date();
		String string=sf.format(current);
		try {
			current=sf.parse(string);
		} catch (ParseException exceptionObject) {
			exceptionObject.printStackTrace();
		}
		
		return current.compareTo(expiry);
		
	}
	
	
	public static String getNIFTY50Top10HoldingsDateFormatddMMyy() {

		Calendar c = Calendar.getInstance();
		// Set the calendar to the current date
		c.clear();
		String fDate = formatDate_ddMMyyyy(new Date());
		Integer year = Integer.parseInt(fDate.substring(04, 8));
		Integer month = Integer.parseInt(fDate.substring(02, 04));
		Integer date = Integer.parseInt(fDate.substring(0, 2));
		c.set(year, month - 1, date); // month start from 0 - 11
		Integer dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		if (dayOfWeek == Calendar.FRIDAY) {
			c.add(Calendar.DATE, -1); // If it's Friday  skip to Thursday
		} else if (dayOfWeek == Calendar.SATURDAY) {
			c.add(Calendar.DATE, -1); // If it's Saturday so skip to Monday
		} else if (dayOfWeek == Calendar.SUNDAY) {
			c.add(Calendar.DATE, -2); // If it's Sunday so skip to Monday
		}else if (dayOfWeek == Calendar.MONDAY) {
			c.add(Calendar.DATE, -3); // If it's Sunday so skip to Monday
		}
		else {
			c.add(Calendar.DATE, -1);
		}
		Date preparedDate = c.getTime();
		String formatedPreparedDate = formatDate_ddMMyy(preparedDate);
		return formatedPreparedDate;

	}
	
	
	public static String getTimeZoneOfServer() {
		String DATE_FORMAT = "dd-M-yyyy hh:mm:ss a";
		DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
		String result = dateFormat.format(new Date()).concat(" ").concat(dateFormat.getTimeZone().getID());
		return result;
	}
	
	public static String encoder(String cipher) {
		byte[] encodedBytes = Base64.encodeBase64(cipher.getBytes());
		return new String(encodedBytes);
	}
	
	public static String decoder(byte[]  encodedBytes) {
		byte[] decodedBytes = Base64.decodeBase64(encodedBytes);
		return new String(decodedBytes);
	}
	
	public static String _encrypt(String message, String secretKey) throws Exception {
		
		MessageDigest md = MessageDigest.getInstance("SHA-1");
		byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
		byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
		
		SecretKey key = new SecretKeySpec(keyBytes, "DESede");
		Cipher cipher = Cipher.getInstance("DESede");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		
		byte[] plainTextBytes = message.getBytes("utf-8");
	    byte[] buf = cipher.doFinal(plainTextBytes);
	    byte [] base64Bytes = Base64.encodeBase64(buf);
	    String base64EncryptedString = new String(base64Bytes);
	    
	    return base64EncryptedString;
	}

	public static  String _decrypt(String encryptedText, String secretKey) throws Exception {
	
	    byte[] message = Base64.decodeBase64(encryptedText.getBytes("utf-8"));
		
		MessageDigest md = MessageDigest.getInstance("SHA-1");
		byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
		byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
		SecretKey key = new SecretKeySpec(keyBytes, "DESede");
		
		Cipher decipher = Cipher.getInstance("DESede");
		decipher.init(Cipher.DECRYPT_MODE, key);
		
		byte[] plainText = decipher.doFinal(message);
		
		return new String(plainText, "UTF-8");
	}
	
	public  static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> unsortMap) {

        List<Map.Entry<K, V>> list =
                new LinkedList<Map.Entry<K, V>>(unsortMap.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        Map<K, V> result = new LinkedHashMap<K, V>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;

    }
	
	public static LinkedHashMap<Integer, String> sortHashMapByValues(
	        HashMap<Integer, String> passedMap) {
	    List<Integer> mapKeys = new ArrayList<>(passedMap.keySet());
	    List<String> mapValues = new ArrayList<>(passedMap.values());
	    Collections.sort(mapKeys);
	    Collections.sort(mapValues);

	    LinkedHashMap<Integer, String> sortedMap =
	        new LinkedHashMap<>();

	    Iterator<String> valueIt = mapValues.iterator();
	    while (valueIt.hasNext()) {
	        String val = valueIt.next();
	        Iterator<Integer> keyIt = mapKeys.iterator();

	        while (keyIt.hasNext()) {
	            Integer key = keyIt.next();
	            String comp1 = passedMap.get(key);
	            String comp2 = val;

	            if (comp1.equals(comp2)) {
	                keyIt.remove();
	                sortedMap.put(key, val);
	                break;
	            }
	        }
	    }
	    return sortedMap;
	}
	
	public static Map<Object, Object> sortTwoStringKeyValueHashMapByValues(HashMap<String, Float> map) {
	 Map<Object, Object> sortedMap =map.entrySet().stream()
			 						.sorted(Entry.comparingByValue())
			 						.collect(Collectors.toMap(Entry::getKey, Entry::getValue,(e1, e2) -> e1, LinkedHashMap::new));
	return sortedMap;
	}
	
	public static Map<Object, Object> sortTwoStringKeyValueHashMapByValuesDoubleType(WeakHashMap<String, Double> map) {
		 Map<Object, Object> sortedMap =map.entrySet().stream()
				 						.sorted(Entry.comparingByValue())
				 						.collect(Collectors.toMap(Entry::getKey, Entry::getValue,(e1, e2) -> e1, LinkedHashMap::new));
		return sortedMap;
	}
	
}