package kunnu.com.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping ("/retry")
public class RetryRestController {

	@Autowired
	private RestTemplate rt;
	
	int count = 1;
	
	@GetMapping
	@Retry (name="rr")
	@RateLimiter (name="rr")
	public String retry () {
		
		System.out.println("retried count::"+ count++);
		
		String url = "http://localhost:6002/b";
		String fromB = rt.getForObject(url, String.class);
		return "Success, " + fromB ;
	}
	
}
