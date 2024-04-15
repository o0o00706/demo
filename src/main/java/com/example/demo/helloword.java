package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloword {
	
	@RequestMapping("/")
	
	public String sayHello () {
		return "helloWord";
	}

}
