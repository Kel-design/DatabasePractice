package com.cupitmadland.springbootapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SpringBootController {
	
	
	//handler method to handle the index page request:  localhost:8080/
	@GetMapping("/")
	public String index() {
		
		return "index";
	}
	
	//handler method to handle the home page request:  localhost:8080/home
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	
	//handler method to handle a blank page request to display a string: localhost:8080/message
	@GetMapping("/message")
	@ResponseBody
	public String message() {
		return "Hello I am Student Kelly";
	}

}
