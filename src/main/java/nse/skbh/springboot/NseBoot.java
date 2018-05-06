package nse.skbh.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@SpringBootApplication
public class NseBoot {

	public static void main(String[] args) {

		/*
		 * Spring Boot makes it easy to create stand-alone, production-grade
		 * Spring based Applications that you can "just run". We take an
		 * opinionated view of the Spring platform and third-party libraries so
		 * you can get started with minimum fuss
		 */

		SpringApplication.run(NseBoot.class, args);
		// start server by calling this method just like another program
	}

}
