package com.topic;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TopicDemoApplication {
	final static Logger logger = Logger.getLogger(TopicDemoApplication.class);
	public static void main(String[] args) {
		logger.info("start Trip Application");
		SpringApplication.run(TopicDemoApplication.class, args);
	}
}
