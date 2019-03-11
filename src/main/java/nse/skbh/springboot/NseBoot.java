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

import nse.skbh.springboot.logic.RestTemplateProvider;
import nse.skbh.springboot.pojo.ServerStatus;
import nse.skbh.springboot.pojo.Services;
import nse.skbh.springboot.pojo.ServicesList;

/**************************************************************************
@SpringBootApplication = @Configuration + @ComponentScan + @EnableAutoConfiguration
@Configuration to enable Java-based configuration. 
@ComponentScan to enable component scanning, All the@Controller classes you write are discovered by this annotation.  
@EnableAutoConfiguration to enable Spring Boot's auto-configuration feature.
@SpringBootApplication is a 3-in-1 annotation that combines the functionality of @Configuration, @ComponentScan, and @EnableAutoConfiguration.
****************************************************************************/

/************************************************************************************************
@Scope=singleton #Scopes a single bean definition to a single object instance per Spring IoC container.
@Scope=prototype #Scopes a single bean definition to any number of object instances.
@Scope=request   #Scopes a single bean definition to the lifecycle of a single HTTP request; that is each and every HTTP request will have its own instance of a bean created off the back of a single bean definition. Only valid in the context of a web-aware Spring ApplicationContext.
@Scope=session   #Scopes a single bean definition to the lifecycle of a HTTP Session. Only valid in the context of a web-aware Spring ApplicationContext.
@Scope=global session #Scopes a single bean definition to the lifecycle of a global HTTP Session. Typically only valid when used in a portlet context. Only valid in the context of a web-aware Spring ApplicationContext.used in portlet context.

@RestController is a specialized version of the controller. 
It includes the @Controller and @ResponseBody annotations and
as a result, simplifies the controller implementation:
*************************************************************************************************/
@RestController
@SpringBootApplication
@CrossOrigin
public class NseBoot {
	
	private static ConfigurableApplicationContext context;
	private static Logger logger = LoggerFactory.getLogger(NseBoot.class);
	
	
	/*begins Bean creation section*/
	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		return resolver;
	}

	@Bean
	public RestTemplateProvider restTemplateProvider() {
		return new RestTemplateProvider();
	}
	
	/************************* not in use ********************
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	***********************uncomment when need******************/
	
	/*End Bean creation section*/
	
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
	

	
	public static void restart() {
        ApplicationArguments args = context.getBean(ApplicationArguments.class);
 
        Thread thread = new Thread(() -> {
        	logger.warn("Application shutting down and Context will be Reloaded in 10 seconds...");
            try {
            	Thread.sleep(10000);// hold system for 10 seconds
           
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
