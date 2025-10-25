package com.flight.reservation.system.controller;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
			@RequestParam String departureDate,
			@RequestParam int adultsCount,
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
		
		Reservation reservation = new Reservation(passengerId, flightId, LocalDate.now(), departureDate, adultsCount, totalPrice, BookingStatus.Pending);	
		reservationRepository.save(reservation);
		return "redirect:/checkout/" + passengerId + "/" + reservation.getId();
	}
	
	@PostMapping("/reservations/cancel/{passengerId}/{reservationId}")
	public String cancelReservation(@PathVariable long passengerId, @PathVariable long reservationId) {
		Optional<Reservation> reservationOpt = reservationRepository.findById(reservationId);
		if(!reservationOpt.isPresent()) { return "redirect:/reservations/" + passengerId;}
			Reservation reservation = reservationOpt.get();
			reservation.setStatus(BookingStatus.Canceled);
			reservationRepository.save(reservation);
			return "redirect:/reservations/" + passengerId;		
	}
	
	@PostMapping("/change-departure-date/{passengerId}/{reservationId}")
	public String changeDepartureDate(@PathVariable Long passengerId, @PathVariable Long reservationId, @RequestParam LocalDate departureDate , Model model) {
		Optional<Passenger> passengerOpt = passengerRepository.findById(passengerId);
		Optional<Reservation> reservationOpt = reservationRepository.findById(reservationId);
	    
	    if(reservationOpt.isPresent()) {
	    	Reservation reservation = reservationOpt.get();
	    	if(reservation.getBookingDate().plusDays(10).isBefore(LocalDate.now())) {
	    		return "redirect:/reservations/" + passengerId;
	    	}
	    	reservation.setDepartureDate(departureDate);
	    	reservationRepository.save(reservation);
	    }
	    
	    if(!passengerOpt.isPresent()) {}
	    Passenger passenger = passengerOpt.get();
	    model.addAttribute("passenger", passenger);
	    
		return "redirect:/reservations/" + passengerId;
	}
	
	@PostMapping("/payment-completed/{passengerId}/{reservationId}")
	public String paymentCompleted(@PathVariable long passengerId, @PathVariable long reservationId, Model model) {
		Passenger passenger = passengerRepository.findById(passengerId).get();
		model.addAttribute("passenger", passenger);
		
		Reservation reservation = reservationRepository.findById(reservationId).get();
		reservation.setStatus(BookingStatus.Confirmed);
		reservationRepository.save(reservation);
		return "payment-completed";
	}
}
