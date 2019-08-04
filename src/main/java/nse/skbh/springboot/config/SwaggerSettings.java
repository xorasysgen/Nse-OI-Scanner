package nse.skbh.springboot.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@Configuration
public class SwaggerSettings {
	
	@Bean
	Contact contact() {
		return new Contact("Sushil Kumar Bhaskar", "https://jsr101.heroku.com", "xorasysgen@yahoo.com");
	}
	
	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("nse.skbh.springboot"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInformation());
	}
	
	
	@SuppressWarnings("unused")
	private Predicate<String> apiPaths() {
		return Predicates.or(PathSelectors.ant("/suggestions/*"),PathSelectors.ant("/currency/*"));
	}


	private ApiInfo apiInformation() {
		return new ApiInfo("nse-api",
				"NSE AI Project in Capital Market and Stock Market powered by Spring Boot",
				"JSR101-1.8.5.RELEASE",
				"Open Source",
				contact(),
				"Api licence", "https://jsr102.heroku.com", Collections.emptyList());

	}
	

}
