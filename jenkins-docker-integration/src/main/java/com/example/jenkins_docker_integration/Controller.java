package com.example.jenkins_docker_integration;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greetings")
public class Controller {
	
	
	@GetMapping
	public String greetings() {
		return "Welcome User, greetings";
	}

}
