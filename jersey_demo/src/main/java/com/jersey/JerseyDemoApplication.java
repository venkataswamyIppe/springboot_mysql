package com.jersey;

import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.jersey.config.JerseyInitialization;

@EnableAutoConfiguration
public class JerseyDemoApplication {
	public static void main(String[] args) {
		new SpringApplicationBuilder(JerseyDemoApplication.class).run(args);
	}

	@Bean
	public ServletRegistrationBean jerseyServlet() {
		ServletRegistrationBean registration = new ServletRegistrationBean(new ServletContainer(), "/*");
		registration.addInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS, JerseyInitialization.class.getName());
		return registration;
	}
}
