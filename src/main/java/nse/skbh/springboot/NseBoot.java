package nse.skbh.springboot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import nse.skbh.springboot.pojo.ServerStatus;
import nse.skbh.springboot.pojo.Services;
import nse.skbh.springboot.pojo.ServicesList;

@RestController
@SpringBootApplication
@CrossOrigin
@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class})
public class NseBoot {

	@RequestMapping("/")
	@ResponseBody
	ServerStatus root() {
		return new ServerStatus();
	}

	@RequestMapping("/services")
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

	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		return resolver;
	}

}
