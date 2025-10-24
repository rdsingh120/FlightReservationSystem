package com.flight.reservation.system.controller;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flight.reservation.system.model.Passenger;
import com.flight.reservation.system.repository.PassengerRepository;

@Controller
public class PassengerController {
	
	@Autowired
	private PassengerRepository passengerRepository;
	
	@PostMapping("/sign-up")
	public String createAccount(
			@RequestParam("first-name") String firstname, 
			@RequestParam("last-name") String lastname, 
			@RequestParam String email, 
			@RequestParam String password) {
		Passenger passenger = new Passenger(firstname, lastname, email, password);
		passengerRepository.save(passenger);
		return "redirect:/sign-in";
	}
	
	@PostMapping("/sign-in")
	public String login(@RequestParam String email, @RequestParam String password) {
		Optional<Passenger> passengerOpt = passengerRepository.findByEmail(email);
	    
	    if(!passengerOpt.isPresent()) return "invalid-credentials";
	    
	    Passenger passenger = passengerOpt.get();
	    
	    if(!passenger.getPassword().equals(password)) return "invalid-credentials";
	    
	    if(passenger.getNationality() == null) return "redirect:/complete-profile/" + passenger.getPassenger_id();
	    
	    return "redirect:/profile/" + passenger.getPassenger_id();	    	
	}
	
	@PostMapping("/complete-profile/{id}")
	public String addProfileInformation(
			@PathVariable Long id,
			String nationality, 
			@RequestParam("passport-number") String passportNumber, 
			@RequestParam("issue-date") LocalDate issueDate,
			@RequestParam("expiry-date") LocalDate expiryDate,
			@RequestParam("phone-number") String phoneNumber,
			@RequestParam("street-address") String streetAddress,
			@RequestParam("street-address-line-2") String streetAddressLine2,
			@RequestParam String province,
			@RequestParam String city,
			@RequestParam("postal-code") String postalCode,
			@RequestParam String country) {
		
		Optional<Passenger> passengerOpt = passengerRepository.findById(id);
	    
	    if(!passengerOpt.isPresent()) {};
	    
	    	Passenger passenger = passengerOpt.get();
	    	passenger.setNationality(nationality);
	    	passenger.setPassportNumber(passportNumber);
	    	passenger.setIssueDate(issueDate);
	    	passenger.setExpiryDate(expiryDate);
	    	passenger.setPhonenumber(phoneNumber);
	    	passenger.setStreetAddress(streetAddress);
	    	passenger.setStreetAddressLine2(streetAddressLine2);
	    	passenger.setCity(city);
	    	passenger.setProvince(province);
	    	passenger.setPostalCode(postalCode);
	    	passenger.setCountry(country);
	    	
	    	passengerRepository.save(passenger);
		
		return "redirect:/profile/" + passenger.getPassenger_id();
	}

	
}
