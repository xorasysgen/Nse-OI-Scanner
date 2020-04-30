package nse.skbh.springboot.config.addon;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:env.properties")
public class Env  implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Value("${init.gracefulshutdown.timeout}")
	private Integer TIMEOUT;
	
	@Value("${init.gracefulshutdown.message0}")
	private String message;
	
	@Value("${init.gracefulshutdown.message1}")
	private String message_1_1;
	
	@Value("${init.gracefulshutdown.message2}")
	private String message_1_2;
	
	@Value("${init.gracefulshutdown.message3}")
	private String message_1_3;
	
	@Value("${init.gracefulshutdown.message4}")
	private String message_1_4;
	
	@Value("${init.gracefulshutdown.message5}")
	private String message_1_5;

	public Env() {
	}

	public Integer getTIMEOUT() {
		return TIMEOUT;
	}

	public String getMessage() {
		return message;
	}

	public String getMessage_1_1() {
		return message_1_1;
	}

	public String getMessage_1_2() {
		return message_1_2;
	}

	public String getMessage_1_3() {
		return message_1_3;
	}

	public String getMessage_1_4() {
		return message_1_4;
	}

	public String getMessage_1_5() {
		return message_1_5;
	}

	@Override
	public String toString() {
		return "Env [TIMEOUT=" + TIMEOUT + ", message=" + message + ", message_1_1=" + message_1_1 + ", message_1_2="
				+ message_1_2 + ", message_1_3=" + message_1_3 + ", message_1_4=" + message_1_4 + ", message_1_5="
				+ message_1_5 + "]";
	}

	

	
}