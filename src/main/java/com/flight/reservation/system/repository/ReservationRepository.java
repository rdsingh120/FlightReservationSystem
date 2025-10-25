package com.flight.reservation.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.reservation.system.model.Reservation;
import java.util.List;


public interface ReservationRepository extends JpaRepository<Reservation, Long> {
	List<Reservation> findByPassengerId(long passengerId);
}
