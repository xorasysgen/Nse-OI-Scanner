package nse.skbh.springboot.logic;

import java.util.Arrays;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
/**********************************************************
@Controller
@ResponseBody
public @interface RestController
A convenience annotation that is itself annotated with @Controller and @ResponseBody.
@RestController= @Controller + @ResponseBody.
**************************************************************/

public class RestTemplateProvider {

	private RestTemplate restTemplate;
	
	/*here we are going to provide Jackson2HttpMessageConverter mapping, So that it will support to respected response type ( application/octet-stream).

	MappingJackson2HttpMessageConverter provides the default configuration used by Jackson2ObjectMapperBuilder.*/
	
	public RestTemplateProvider() {
		restTemplate=new RestTemplate();
		MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
		mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_OCTET_STREAM,MediaType.TEXT_PLAIN));
		restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);
	}

	public RestTemplate getRestTemplate() {
		return restTemplate;
	}

	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	/*public void httpMessageConvertorAdaptor(restTemplate) {
		MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
		mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_OCTET_STREAM,MediaType.TEXT_PLAIN));
		restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);
	}*/
	
	
}
