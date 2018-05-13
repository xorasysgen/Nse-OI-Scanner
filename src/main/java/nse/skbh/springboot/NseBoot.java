package nse.skbh.springboot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import nse.skbh.springboot.pojo.Services;
import nse.skbh.springboot.pojo.ServicesList;

@RestController
@SpringBootApplication
@CrossOrigin
public class NseBoot {

	@RequestMapping("/")
	@ResponseBody
	ServicesList home() {
		ServicesList servicesObj = new ServicesList();
		List<Services> services = new ArrayList<>();
		List<String> list = Constant.getListOfService();
		Integer i = 1;
		for (String string : list) {
			Services s = new Services();
			s.setServiceID(i++);
			s.setServiceURI(string);
			services.add(s);
		}
		servicesObj.setService(services);
		return servicesObj;
	}

	public static void main(String[] args) {

		SpringApplication.run(NseBoot.class, args);
		// boot from here, run as simple java program, rest it will take care of
		// it.

	}

}
