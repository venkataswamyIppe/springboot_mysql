package com.hello.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class HelloWorldSpringBootApplication {

	// @RequestMapping annotation is used for mapping web requests onto specific
	// handler classes
	@RequestMapping("/")
	String basicURL() {
		return "Welcome to Spring Boot Hello World Tutorial";
	}

	@RequestMapping("/hello")
	String crunchifyURL() {
		return "Hello Friends! This is your first SpringBoot Example. Isn't that so Simple?";
	}

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldSpringBootApplication.class, args);
	}
}
