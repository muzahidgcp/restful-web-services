package com.smh.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HellowWorldController {
	
	@GetMapping("/hello-world")
	public String hellowWorld() {
		return "Hello World ";
	}
	
	@GetMapping("/hello-world-bean")
	public HelloWorldBean hellowWorldBean() {
		return new HelloWorldBean("Hello World ");
	}
	
	@GetMapping("/hello-world/path-variable/{name}")
	public HelloWorldBean hellowWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean("Hello World "+name);
	}

}
