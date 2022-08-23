package com.revature.ecommerce;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;






@ComponentScan("com.revature.ecommerce.service")
@EnableJpaRepositories
@SpringBootApplication
public class ECommerceP2Application {

	public static void main(String[] args) {
		SpringApplication.run(ECommerceP2Application.class, args);
	}
}