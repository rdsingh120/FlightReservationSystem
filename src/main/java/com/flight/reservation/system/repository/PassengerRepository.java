package com.flight.reservation.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.reservation.system.model.Passenger;
import java.util.List;
import java.util.Optional;


public interface PassengerRepository extends JpaRepository<Passenger, Long> {
	Optional<Passenger> findByEmail(String email);
}
