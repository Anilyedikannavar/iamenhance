package com.application.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.application.config") // Add the correct package name
@EntityScan(basePackages="com.application.model") // Add the correct package name
@ComponentScan("com.application")
@EnableJpaRepositories(basePackages = "com.application.repository")
public class IamenhanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(IamenhanceApplication.class, args);
	}

}
