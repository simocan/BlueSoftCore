package com.bluesoft.barkod;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class BlueSoftCoreApplication extends SpringBootServletInitializer {

//public class BlueSoftCoreApplication {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(BlueSoftCoreApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(BlueSoftCoreApplication.class, args);
	}
	
	

}
