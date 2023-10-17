package com.api.springbootbaseapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.api.springbootbaseapi.models")
public class SpringBootBaseApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBaseApiApplication.class, args);
	}

}
