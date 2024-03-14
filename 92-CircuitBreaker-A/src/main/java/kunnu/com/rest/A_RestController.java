package kunnu.com.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/a")
public class A_RestController {
	
	@Autowired
	private RestTemplate rt;

	private static final String BASE_URL = "http://localhost:6002";
	private static final String B = "breaker";
	
	
	@GetMapping
	@CircuitBreaker (name=B, fallbackMethod = "fallBack_A")
	public String serviceA() {
		String msg = "A service called";
		
		
		String url = BASE_URL + "/b";
		String forObject = rt.getForObject(url, String.class);
		return msg + ", " + forObject;
	}
	
	public String fallBack_A (Exception e) {
		return "Comming from Fall back method";
	}
	
}
