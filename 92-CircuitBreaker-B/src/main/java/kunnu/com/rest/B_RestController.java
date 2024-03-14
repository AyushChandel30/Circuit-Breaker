package kunnu.com.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/b")
public class B_RestController {
	
	@GetMapping
	public String serviceB() {
		return "service b called";
	}

}
