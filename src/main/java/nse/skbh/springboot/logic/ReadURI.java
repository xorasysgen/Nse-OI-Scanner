package nse.skbh.springboot.logic;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.List;

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
			System.out.println("Attemping to search file in current directory... " + file_name);
			return false;
		}
	}

	public static List<Nse> unpackArchive() throws IOException {

		return null;

	}

}