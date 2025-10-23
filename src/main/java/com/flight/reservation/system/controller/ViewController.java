package com.flight.reservation.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/sign-up")
	public String signUp() {
		return "sign-up";
	}
	
	@GetMapping("/sign-in")
	public String signIn() {
		return "sign-in";
	}
}
