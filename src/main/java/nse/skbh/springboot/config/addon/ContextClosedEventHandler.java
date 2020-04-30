package nse.skbh.springboot.config.addon;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.catalina.connector.Connector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class ContextClosedEventHandler implements TomcatConnectorCustomizer, ApplicationListener<ContextClosedEvent> {


	@Autowired
	private Env env;

	private volatile Connector connector;

	@Override
	public void customize(Connector connector) {
		log.info("Tomcat Connector Called...");
		this.connector = connector;
	}

	@Override
	public void onApplicationEvent(ContextClosedEvent event) {
		if(connector!=null) {
		this.connector.pause();
		Executor executor = this.connector.getProtocolHandler().getExecutor();
		log.info(env.getMessage());
		if (executor instanceof ThreadPoolExecutor) {
			try {
				ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executor;
				threadPoolExecutor.shutdown();
				if (!threadPoolExecutor.awaitTermination(env.getTIMEOUT(), TimeUnit.SECONDS)) {
					log.warn(env.getMessage_1_1() + " " + env.getTIMEOUT() + " " + env.getMessage_1_2());
					threadPoolExecutor.shutdownNow();
					if (!threadPoolExecutor.awaitTermination(env.getTIMEOUT(), TimeUnit.SECONDS)) {
						log.error(env.getMessage_1_3());
					}
				} else {
					log.info(env.getMessage_1_4());
				}
			} catch (InterruptedException ex) {
				log.info(env.getMessage_1_5());
				Thread.currentThread().interrupt();
				 throw new ResponseStatusException(
				           HttpStatus.SERVICE_UNAVAILABLE, "Server forcefully shutdown");
			}
		}
		}
		else {
			return;
		}
	}

	public Env getEnv() {
		return env;
	}

	public void setEnv(Env env) {
		this.env = env;
	}
	
	
	
	

}
