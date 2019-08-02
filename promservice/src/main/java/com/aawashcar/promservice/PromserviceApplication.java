package com.aawashcar.promservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PromserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PromserviceApplication.class, args);
	}
}
