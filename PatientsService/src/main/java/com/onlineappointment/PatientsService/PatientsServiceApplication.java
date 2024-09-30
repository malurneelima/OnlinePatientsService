package com.onlineappointment.PatientsService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.onlineappointment")
@EnableDiscoveryClient
public class PatientsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientsServiceApplication.class, args);
	}

}

