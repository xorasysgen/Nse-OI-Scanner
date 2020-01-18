package nse.skbh.springboot.logic;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import nse.skbh.springboot.pojo.Nse;

public class ReadURI {

	private static boolean downloadUsingStream(URL urlStr, String file_name) throws IOException {
		try {
			BufferedInputStream bis = new BufferedInputStream(urlStr.openStream());
			FileOutputStream fis = new FileOutputStream(file_name);
			byte[] buffer = new byte[1024];
			int count = 0;
			while ((count = bis.read(buffer, 0, 1024)) != -1) {
				fis.write(buffer, 0, count);
			}
			fis.close();
			bis.close();
			return true;
		} catch (FileNotFoundException fe) {
			System.out.println("File Not Found! : " + file_name);
			System.out.println("Attemping to download previous day file from NSE... " + file_name);
			return false;
		}
	}

	public static List<Nse> unpackArchive() throws IOException {
		String date = Utils.getDateToIgnoreWeekEndCloseOpenInterest();
		System.out.println(date);
		String hitAndTrialURL="https://www1.nseindia.com/archives/nsccl/mwpl/";
		String ftpUrl = "https://www1.nseindia.com/archives/nsccl/mwpl/nseoi_" + date.replaceAll("-", "") + ".zip";
		String file_name = "nseoi_" + date.replaceAll("-", "") + ".zip";
		System.out.println("ftpUrl" + ftpUrl);
		URL url = null;
		url = new URL(ftpUrl);
		boolean status = downloadUsingStream(url, file_name);
		try {
			if (!status) {
				int loop_rolling = 1;
				status=false;
				while (!status) {
					date = Utils.getdayBeforeYesterdayDateString(loop_rolling++);
					file_name = "nseoi_" + date.replaceAll("-", "") + ".zip";
					ftpUrl=hitAndTrialURL +file_name;
					url = new URL(ftpUrl);
					/*System.out.println("hitAndTrialURL#" + ftpUrl);
					System.out.println("hitAndTrialURL file_name#" + file_name);
					System.out.println("hitAndTrialURL status#" + status);*/
					status = downloadUsingStream(url, file_name);
					File f = new File(file_name);
					boolean file_status = f.exists();
					if (file_status == false) {
						System.out.println("File Not Found! : " + file_name);
						System.out.println("Attemping to search file in current directory... " + file_name);
					}
					if (file_status == true || loop_rolling == 6) {
						System.out.println("exiting search! " + file_name);
						break;
					}

				}
			}
			FileInputStream fis = new FileInputStream(file_name);
			BufferedInputStream bis = new BufferedInputStream(fis);
			ZipInputStream zis = new ZipInputStream(bis);
			ZipEntry entry = null;
			//System.out.println("inside zipo reader" + url.toString());
			File zipFile = new File(file_name);
			//System.out.println(zipFile.getAbsoluteFile());
			@SuppressWarnings("resource")
			ZipFile zip = new ZipFile(zipFile);
			List<Nse> nse = new LinkedList<Nse>();
			while ((entry = zis.getNextEntry()) != null) {
				//System.out.println("entry: " + entry.getName() + ", " + entry.getSize());
				//System.out.println(entry.getComment());
				BufferedReader bufferedeReader = new BufferedReader(new InputStreamReader(zip.getInputStream(entry)));
				String line = bufferedeReader.readLine();
				int i = 0;
				while (line != null) {
					if (i++ == 0) {
						line = bufferedeReader.readLine();
						continue;
					}
					Nse nseObj = new Nse();
					// System.out.println(line);
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
				zis.close();
				break;
			}
			// System.out.println(new Gson().toJson(nse));
			Collections.sort(nse, new CompratorClass());
			Collections.reverse(nse);
			//System.out.println(nse);
			return nse;
		} catch (IOException e) {
		} finally {
			try {

				File file = new File(file_name);
				System.out.println(file_name);
				if (file.delete()) {
					System.out.println(file.getName() + " is deleted!");
				} else {
					System.out.println(file_name + " Delete operation is failed.");
				}

			} catch (Exception e) {

				e.printStackTrace();

			}
		}
		return null;

	}

}