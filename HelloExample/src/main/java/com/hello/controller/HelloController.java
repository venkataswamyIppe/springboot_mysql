package com.hello.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping("/hello/{name}")
	public String sayHello(@PathVariable String name){
		return "Hello "+name+" welcome to spring boot application";
	}
}
