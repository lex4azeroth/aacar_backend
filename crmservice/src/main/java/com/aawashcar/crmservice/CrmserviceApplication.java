package com.aawashcar.crmservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CrmserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrmserviceApplication.class, args);
	}
}
