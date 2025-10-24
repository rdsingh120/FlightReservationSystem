package com.flight.reservation.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.reservation.system.model.Flight;
import java.util.List;


public interface FlightRepository extends JpaRepository<Flight, Long> {
	List<Flight> findByOriginAndDestination(String origin, String destination);
}
