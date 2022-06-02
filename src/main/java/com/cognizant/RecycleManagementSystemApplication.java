package com.cognizant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.cognizant","com.cognizant.controller","com.cognizant.dao","com.cognizant.model","com.cognizant.service"})
public class RecycleManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecycleManagementSystemApplication.class, args);
	}

}
