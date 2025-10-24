package com.flight.reservation.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flight.reservation.system.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
