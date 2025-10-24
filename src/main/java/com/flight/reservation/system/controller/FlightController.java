package com.flight.reservation.system.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flight.reservation.system.model.Flight;
import com.flight.reservation.system.model.Passenger;
import com.flight.reservation.system.repository.FlightRepository;
import com.flight.reservation.system.repository.PassengerRepository;

@Controller
public class FlightController {
	
	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	PassengerRepository passengerRepository;
	
	
	@PostMapping("search-flight/{id}")
	public String getFlights(
			@PathVariable long id, 
			@RequestParam("departureCity") String departureCity,
			@RequestParam("arrivalCity") String arrivalCity,
			Model model) {
		
		List<Flight> flights = null;
		
		Optional<Passenger> passengerOpt = passengerRepository.findById(id);
		if(!passengerOpt.isPresent()) {}
		
		Passenger passenger = passengerOpt.get();
;		model.addAttribute("passenger", passenger);
		
		
		flights = flightRepository.findByOriginAndDestination(departureCity, arrivalCity);
		model.addAttribute("flights", flights);
		
		return "search-flight";
	}

}
