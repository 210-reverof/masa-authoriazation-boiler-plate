package com.boilerplate.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class UserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
		checkClassPathForEurekaRegistration();
	}

	private static void checkClassPathForEurekaRegistration() {
		try {
			Class.forName("org.springframework.cloud.netflix.eureka.EurekaRegistration");
			System.out.println("EurekaRegistration.class is found in the classpath.");
		} catch (ClassNotFoundException e) {
			System.out.println("EurekaRegistration.class is not found in the classpath.");
		}
	}



}
