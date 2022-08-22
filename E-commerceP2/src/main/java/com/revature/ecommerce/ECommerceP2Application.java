package com.revature.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin
@Controller
@ComponentScan("com.revature.ecommerce.service")
@EnableJpaRepositories
@SpringBootApplication
public class ECommerceP2Application {

	
	@RequestMapping("/helloBackend")
	@ResponseBody
	void home() {
		System.out.println("Hello Angular this is backend speaking!");
	}
	public static void main(String[] args) {
		SpringApplication.run(ECommerceP2Application.class, args);
	}

}
