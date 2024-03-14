 package kunnu.com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RetryConfiguration {
	
	@Bean
	public RestTemplate rt () {
		return new RestTemplate();
	}
	
}
