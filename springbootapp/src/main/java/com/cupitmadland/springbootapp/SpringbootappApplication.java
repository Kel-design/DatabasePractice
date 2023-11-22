package com.cupitmadland.springbootapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cupitmadland.springbootapp.model.Customer;

@SpringBootApplication
public class SpringbootappApplication {

	public static void main(String[] args) {
		//SpringApplication.run(SpringbootappApplication.class, args);
		
		//use Lombok empty construction and setters/getters
		
		Customer cust = new Customer();
		cust.setUsername("msmith");
		cust.setPassword("12345");
		
		System.out.println(cust.getUsername() + " \n " cust.getPassword());
		
		//use constructor with fields to build object
		
		Customer cust2 = new Customer("maryts", "5678");
		System.out.println(cust2.getUsername() + " \n " cust2.getPassword());
	}

}
