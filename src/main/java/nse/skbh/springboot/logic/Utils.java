package nse.skbh.springboot.logic;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

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

	public static void main(String[] args) {
		String fileName = "04052018.zipd";
		ZipInputStream zis = null;
		File f = new File(fileName);
		System.out.println(f.exists());
		try {
			FileInputStream fis = new FileInputStream(fileName);
			BufferedInputStream bis = new BufferedInputStream(fis);
			zis = new ZipInputStream(bis);

			ZipEntry entry;
			File zipFile = new File("04052018.zip");
			System.out.println(zipFile.getAbsoluteFile());
			@SuppressWarnings("resource")
			ZipFile zip = new ZipFile(zipFile);
			while ((entry = zis.getNextEntry()) != null) {
				BufferedReader bufferedeReader = new BufferedReader(new InputStreamReader(zip.getInputStream(entry)));
				String line = bufferedeReader.readLine();
				System.out.println(line);
				line = bufferedeReader.readLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (zis != null)
				try {
					zis.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
		}
	}

}
