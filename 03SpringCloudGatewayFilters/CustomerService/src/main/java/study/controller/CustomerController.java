package study.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/customer")
public class CustomerController {

	@GetMapping("/hello")
	public String sayHello(@RequestHeader("first-request") String header) {
		System.out.println(header);
		return "Hello Customer, How are you? ";
	}
	
}
