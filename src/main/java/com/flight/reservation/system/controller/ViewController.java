package com.flight.reservation.system.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.flight.reservation.system.model.Passenger;
import com.flight.reservation.system.repository.PassengerRepository;

@Controller
public class ViewController {
	
	@Autowired
	PassengerRepository passengerRepository;
	
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
	
	@GetMapping("/complete-profile/{id}")
	public String completeProfile(@PathVariable Long id, Model model) {
		Optional<Passenger> passengerOpt = passengerRepository.findById(id);
	    
	    if(passengerOpt.isPresent()) {
	    	Passenger passenger = passengerOpt.get();
	    	model.addAttribute("passenger", passenger);
	    };
	    
	    
		
		return "complete-profile";
	}
}
