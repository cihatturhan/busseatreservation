package com.cihatturhan.busseatreservation.com.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	
	@GetMapping("/")
	public String ggetHome() {
		
		return "home";
	}
}
