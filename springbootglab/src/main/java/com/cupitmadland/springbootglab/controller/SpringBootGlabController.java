package com.cupitmadland.springbootglab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SpringBootGlabController {
	
	@GetMapping("/")
	public String index() {
		
		return "index";
	
	}
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	@GetMapping("/message")
	@ResponseBody
	public String message() {
		return "I'm testing if I can get a message onto a blank webpage in JSON format";
	}

}
