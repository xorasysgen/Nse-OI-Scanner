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
		SpringApplication.run(NseBoot.class, args);

	}

}
