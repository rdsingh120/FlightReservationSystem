package com.flight.reservation.system.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flight.reservation.system.model.Passenger;
import com.flight.reservation.system.repository.PassengerRepository;

@Controller
public class PassengerController {
	
	@Autowired
	private PassengerRepository passengerRepository;
	
	@PostMapping("/sign-up")
	public String createAccount(
			@RequestParam("name") String name, 
			@RequestParam("email") String email, 
			@RequestParam("password") String password) {
		
		Passenger passenger = new Passenger(name, email, password);
		
		passengerRepository.save(passenger);
		
		return "redirect:/sign-in";
	}
	
	@PostMapping("/sign-in")
	public String login(String email, String password) {
		Optional<Passenger> passengerOpt = passengerRepository.findByEmail(email);
	    
	    if(!passengerOpt.isPresent()) return "invalid-credentials";
	    
	    Passenger passenger = passengerOpt.get();
	    
	    if(!passenger.getPassword().equals(password)) return "invalid-credentials";
	    
	    if(passenger.getNationality() == null) return "complete-profile";
	    
	    return "Dashboard";	    	
	}
	
}
