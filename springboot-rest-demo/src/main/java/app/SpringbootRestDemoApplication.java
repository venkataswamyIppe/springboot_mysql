package app;

import org.apache.log4j.Logger;
import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import app.config.JerseyInitialization;


@EnableAutoConfiguration
@ComponentScan("app")
@Configuration
public class SpringbootRestDemoApplication {
	final static Logger logger = Logger.getLogger(SpringbootRestDemoApplication.class);
	public static void main(String[] args) {
		logger.info("start your application");
		new SpringApplicationBuilder(SpringbootRestDemoApplication.class).run(args);
	}

	@Bean
	public ServletRegistrationBean jerseyServlet() {
		ServletRegistrationBean registration = new ServletRegistrationBean(new ServletContainer(), "/*");
		registration.addInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS, JerseyInitialization.class.getName());
		return registration;
	}
}
