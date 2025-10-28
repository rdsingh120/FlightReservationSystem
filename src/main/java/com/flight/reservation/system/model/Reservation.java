package com.flight.reservation.system.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Reservation {
	
	@Id
	@Column(name = "reservation_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Column(name = "passenger_id", nullable = false)
	private long passengerId;
	
	@NotNull
	@Column(name = "flight_id", nullable = false)
	private long flightId;
	
	@NotNull
	@Column(name = "booking_date", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate bookingDate;
	
	@NotNull
	@Column(name = "departure_date", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate departureDate;
	
	@NotNull
	@Column(name = "no_of_passengers", nullable = false)
	private int passengerCount;
	
	@NotNull
	@Column(name = "total_price")
	private double totalPrice;
	
	@NotNull
	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private BookingStatus status;
	
	public enum BookingStatus { Pending, Confirmed, Canceled }


	public Reservation() {
	}
	
	public Reservation(long passengerId, long flightId, LocalDate bookingDate, LocalDate departureDate,
			int passengerCount, double totalPrice, BookingStatus status) {
		this.passengerId = passengerId;
		this.flightId = flightId;
		this.bookingDate = bookingDate;
		this.departureDate = departureDate;
		this.passengerCount = passengerCount;
		this.totalPrice = totalPrice;
		this.status = status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(long passengerId) {
		this.passengerId = passengerId;
	}

	public long getFlightId() {
		return flightId;
	}

	public void setFlightId(long flightId) {
		this.flightId = flightId;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public LocalDate getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}

	public int getPassengerCount() {
		return passengerCount;
	}

	public void setPassengerCount(int passengerCount) {
		this.passengerCount = passengerCount;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public BookingStatus getStatus() {
		return status;
	}

	public void setStatus(BookingStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Reservation [id=").append(id).append(", passengerId=").append(passengerId).append(", flightId=")
				.append(flightId).append(", bookingDate=").append(bookingDate).append(", departureDate=")
				.append(departureDate).append(", passengerCount=").append(passengerCount).append(", totalPrice=")
				.append(totalPrice).append(", status=").append(status).append("]");
		return builder.toString();
	}

	
	
		
	
}
