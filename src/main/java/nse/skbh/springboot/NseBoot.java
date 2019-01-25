package nse.skbh.springboot;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
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
public class NseBoot {
	
	private static ConfigurableApplicationContext context;
	private static Logger logger = LoggerFactory.getLogger(NseBoot.class);
	
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
		context =SpringApplication.run(NseBoot.class, args);
		// boot from here, run as simple java program, rest it will take care of
		// it. config files

	}

	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		return resolver;
	}

	
	public static void restart() {
        ApplicationArguments args = context.getBean(ApplicationArguments.class);
 
        Thread thread = new Thread(() -> {
        	logger.warn("Application shutting down and Context will be Reloaded in 10 seconds...");
            try {
            	Thread.sleep(10000);// hold system for 5 seconds
           
			} catch (InterruptedException exceptionObject) {
				exceptionObject.printStackTrace();
			}
            context.close();
            context = SpringApplication.run(NseBoot.class, args.getSourceArgs());
        });
 
        thread.setDaemon(false);
        thread.start();
    }
}
