package com.ibm.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;



@Configuration
@EnableAutoConfiguration
public class ApiTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiTestApplication.class, args);
	}
}
