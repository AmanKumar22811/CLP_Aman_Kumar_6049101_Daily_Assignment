package com.cg.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@GetMapping("/")
	public String home() {
		return "Welcome to home page";
	}
	
	@GetMapping("/about")
	public String about() {
		return "Welcome to about page";
	}
	
	@GetMapping("/contact")
	public String contact() {
		return "Welcome to contact page";
	}
}
