package com.flight.reservation.system.controller;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flight.reservation.system.model.Flight;
import com.flight.reservation.system.model.Passenger;
import com.flight.reservation.system.model.Reservation;
import com.flight.reservation.system.model.Reservation.BookingStatus;
import com.flight.reservation.system.repository.FlightRepository;
import com.flight.reservation.system.repository.PassengerRepository;
import com.flight.reservation.system.repository.ReservationRepository;

@Controller
public class ReservationController {
	
	@Autowired
	PassengerRepository passengerRepository;
	
	@Autowired
	FlightRepository flightRepository;
	
	@Autowired ReservationRepository reservationRepository;
	
	
	@PostMapping("/review-reservation/{id}")
	public String reviewReservation(
			@PathVariable Long id,
			@RequestParam("flight") Long flightId,
			@RequestParam("departureDate") String departureDate,
			@RequestParam("adultsCount") int adultsCount,
			Model model) {
		
		Optional<Passenger> passengerOpt = passengerRepository.findById(id);
		Optional<Flight> flightOpt = flightRepository.findById(flightId);
		
		if(!passengerOpt.isPresent()) {}
		Passenger passenger = passengerOpt.get();
		
		if(!flightOpt.isPresent()) {}
		Flight flight = flightOpt.get();
		
		model.addAttribute("flight", flight);
		model.addAttribute("passenger", passenger);
		model.addAttribute("departureDate", departureDate);
		model.addAttribute("adultsCount", adultsCount);
		
		return "reservation-review";
	}
	
	@PostMapping("/checkout")
	public String createReservation(
			@RequestParam long passengerId,
			@RequestParam long flightId,
			@RequestParam int adultsCount,
			@RequestParam LocalDate departureDate,
			@RequestParam double totalPrice) {
		
		Reservation reservation = new Reservation(passengerId, flightId, departureDate, departureDate, adultsCount, totalPrice, BookingStatus.Pending);	
		reservationRepository.save(reservation);
		return "redirect:/checkout/" + reservation.getId();
		
	}
}
