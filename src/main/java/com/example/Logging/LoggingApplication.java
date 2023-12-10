package com.example.Logging;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LoggingApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoggingApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean<MDCFilter> filterRegistrationBean() {
		FilterRegistrationBean<MDCFilter> registrationBean = new FilterRegistrationBean<>();
		registrationBean.setFilter(new MDCFilter());
		registrationBean.addUrlPatterns("/*");
		return registrationBean;
	}

}

