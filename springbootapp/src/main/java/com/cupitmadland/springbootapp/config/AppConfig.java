package com.cupitmadland.springbootapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cupitmadland.springbootapp.model.Customer;

@Configuration
public class AppConfig {
	
	@Bean
	public Customer superCustomer() {
		
		System.out.println("\n RETURNING A CUSTOMER OBJECT ANNOTATED WITH @Bean.....\n");
		return new Customer("Mary", "12345");
		
	}

}
