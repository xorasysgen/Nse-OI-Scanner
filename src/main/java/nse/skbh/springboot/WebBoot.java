package nse.skbh.springboot;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nse.skbh.springboot.logic.ReadURI;
import nse.skbh.springboot.pojo.Nse;
import nse.skbh.springboot.pojo.OIData;

@RestController
public class WebBoot {

	@RequestMapping("/oi")
	public OIData home() {
		/* test for the uploading and merging of git directory */

		List<Nse> nse = null;
		try {
			nse = ReadURI.unpackArchive();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		OIData OIData = new OIData();
		OIData.setOpenInterest(nse);
		return OIData;
		// return new Gson().toJson(OIData);
	}

}
