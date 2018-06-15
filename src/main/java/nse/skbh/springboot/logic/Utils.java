package nse.skbh.springboot.logic;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.codec.binary.Base64;

public class Utils {

	private static Date dayBeforeYesterday(int dayBack) {
		final Calendar cal = Calendar.getInstance();
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

}
