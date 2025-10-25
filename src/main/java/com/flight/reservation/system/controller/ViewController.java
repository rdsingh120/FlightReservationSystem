package com.flight.reservation.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.flight.reservation.system.model.Flight;
import com.flight.reservation.system.model.Passenger;
import com.flight.reservation.system.model.Reservation;
import com.flight.reservation.system.repository.FlightRepository;
import com.flight.reservation.system.repository.PassengerRepository;
import com.flight.reservation.system.repository.ReservationRepository;

@Controller
public class ViewController {
	
	@Autowired
	PassengerRepository passengerRepository;
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@Autowired
	FlightRepository flightRepository;
	
	@GetMapping("/")
	public String homePage() {
		return "index";
	}
	
	@GetMapping("/sign-up")
	public String signUpPage() {
		return "sign-up";
	}
	
	@GetMapping("/sign-in")
	public String signInPage() {
		return "sign-in";
	}
	
	@GetMapping("/complete-profile/{id}")
	public String completeProfilePage(@PathVariable Long id, Model model) {
		Optional<Passenger> passengerOpt = passengerRepository.findById(id);
	    
	    if(passengerOpt.isPresent()) {
	    	Passenger passenger = passengerOpt.get();
	    	model.addAttribute("passenger", passenger);
	    };		
		return "complete-profile";
	}
	
	@GetMapping("/profile/{id}")
	public String profilePage(@PathVariable Long id, Model model) {
		Optional<Passenger> passengerOpt = passengerRepository.findById(id);
	    
	    if(passengerOpt.isPresent()) {
	    	Passenger passenger = passengerOpt.get();
	    	model.addAttribute("passenger", passenger);
	    };
		return "profile";
	}
	
	@GetMapping("/update-profile/{id}")
	public String updateProfilePage(@PathVariable Long id, Model model) {
		Optional<Passenger> passengerOpt = passengerRepository.findById(id);
	    
	    if(passengerOpt.isPresent()) {
	    	Passenger passenger = passengerOpt.get();
	    	model.addAttribute("passenger", passenger);
	    };		
		return "update-profile";
	}
	
	@GetMapping("/search-flight/{id}")
	public String searchFlightPage(@PathVariable Long id, Model model) {
		Optional<Passenger> passengerOpt = passengerRepository.findById(id);
	    
	    if(passengerOpt.isPresent()) {
	    	Passenger passenger = passengerOpt.get();
	    	model.addAttribute("passenger", passenger);
	    };		
		return "search-flight";
	}
	
	@GetMapping("/reservations/{id}")
	public String reservationsPage(@PathVariable Long id, Model model) {
		Optional<Passenger> passengerOpt = passengerRepository.findById(id);
		List<Reservation> reservations = reservationRepository.findByPassengerId(id);
		model.addAttribute("reservations", reservations);
		
		Map<Long, Flight> flightData = new HashMap<Long, Flight>();
		for(Reservation reservation : reservations) {
			Optional<Flight> flightOpt = flightRepository.findById(reservation.getFlightId());
			if(flightOpt.isPresent()) {
				flightData.put(reservation.getId(), flightOpt.get());
			}
		}
		model.addAttribute("flightData", flightData);		
		
	    
	    if(passengerOpt.isPresent()) {
	    	Passenger passenger = passengerOpt.get();
	    	model.addAttribute("passenger", passenger);
	    };		
		return "reservations";
	}
	
	@GetMapping("review-reservation/{id}")
	public String redirectPage(@PathVariable Long id) {
		return "redirect:/search-flight/" + id;
	}
	
	
	@GetMapping("/checkout/{passengerId}/{reservationId}")
	public String checkOutPage(@PathVariable Long passengerId, @PathVariable Long reservationId, Model model) {
		Optional<Passenger> passengerOpt = passengerRepository.findById(passengerId);
		Optional<Reservation> reservationOpt = reservationRepository.findById(reservationId);
	    
	    if(reservationOpt.isPresent()) {
	    	Reservation reservation = reservationOpt.get();
	    	model.addAttribute("reservation", reservation);
	    };	
	    
	    if(passengerOpt.isPresent()) {
	    	Passenger passenger = passengerOpt.get();
	    	model.addAttribute("passenger", passenger);
	    };		
		return "checkout";
	}
	
	@GetMapping("/change-departure-date/{passengerId}/{reservationId}")
	public String changeDepartureDatePage(@PathVariable Long passengerId, @PathVariable Long reservationId, Model model) {
		Optional<Passenger> passengerOpt = passengerRepository.findById(passengerId);
		Optional<Reservation> reservationOpt = reservationRepository.findById(reservationId);
	    
	    if(reservationOpt.isPresent()) {
	    	Reservation reservation = reservationOpt.get();
	    	model.addAttribute("reservation", reservation);
	    }
	    
	    if(passengerOpt.isPresent()) {
	    	Passenger passenger = passengerOpt.get();
	    	model.addAttribute("passenger", passenger);
	    }
		return "change-departure-date";
	}
	
	
	
	
	
}
