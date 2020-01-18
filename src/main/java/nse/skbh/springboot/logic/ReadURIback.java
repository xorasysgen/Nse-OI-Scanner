package nse.skbh.springboot.logic;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import com.google.gson.Gson;

import nse.skbh.springboot.pojo.Nse;

public class ReadURIback {

	private static boolean downloadUsingStream(URL urlStr, String file) throws IOException {
		try {
			BufferedInputStream bis = new BufferedInputStream(urlStr.openStream());
			FileOutputStream fis = new FileOutputStream(file);
			byte[] buffer = new byte[1024];
			int count = 0;
			while ((count = bis.read(buffer, 0, 1024)) != -1) {
				fis.write(buffer, 0, count);
			}
			fis.close();
			bis.close();
			return true;
		} catch (FileNotFoundException fe) {
			return false;
		}
	}

	public static List<Nse> unpackArchive() throws IOException {
		String date = Utils.getYesterdayDateString();
		String ftpUrl = "https://www1.nseindia.com/archives/nsccl/mwpl/nseoi_" + date.replaceAll("-", "") + ".zip";
		String file_name = date.replaceAll("-", "") + ".zip";
		URL url = null;
		url = new URL(ftpUrl);
		if (!downloadUsingStream(url, file_name)) {
			downloadUsingStream(url, file_name);
		}
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		InputStream is = con.getInputStream();
		ZipInputStream zis = new ZipInputStream(is);
		ZipEntry entry = null;
		System.out.println(url.toString());
		File zipFile = new File("nseoi_" + file_name);
		System.out.println(zipFile.getAbsoluteFile());
		@SuppressWarnings("resource")
		ZipFile zip = new ZipFile(zipFile);
		List<Nse> nse = new LinkedList<Nse>();
		while ((entry = zis.getNextEntry()) != null) {
			System.out.println("entry: " + entry.getName() + ", " + entry.getSize());
			System.out.println(entry.getComment());
			BufferedReader bufferedeReader = new BufferedReader(new InputStreamReader(zip.getInputStream(entry)));
			String line = bufferedeReader.readLine();
			int i = 0;
			while (line != null) {
				if (i++ == 0) {
					line = bufferedeReader.readLine();
					continue;
				}
				Nse nseObj = new Nse();
				System.out.println(line);
				String[] a = line.split("\\,");
				nseObj.setDate(a[0]);
				nseObj.setISIN(a[1]);
				nseObj.setName(a[2]);
				nseObj.setScrip(a[3]);
				nseObj.setMWPL(a[4]);
				nseObj.setNSE_Open_Interest(a[5]);

				if ((i != 0)) {
					Float s = (Float.parseFloat(a[5]) / Float.parseFloat(a[4])) * 100;
					nseObj.setUsedLimit(s);
				} else {

				}
				// nseObj.setUsedLimit("UsedLimit");
				nse.add(nseObj);
				line = bufferedeReader.readLine();
			}
			bufferedeReader.close();
			break;
		}
		System.out.println(new Gson().toJson(nse));
		Collections.sort(nse, new CompratorClass());
		Collections.reverse(nse);
		System.out.println(nse);
		return nse;

	}

}