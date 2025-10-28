package com.flight.reservation.system.model;

import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Flight {
	
	@Id
	@Column(name = "flight_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Column(name = "airline_name")
	private String airlineName;
	
	@NotNull
	@Column(name = "departure_time")
	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime departureTime;
	
	@NotNull
	@Column(name = "arrival_time")
	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime arrivalTime;
	
	@NotNull
	@Column(name = "origin")
	private String origin;
	
	@NotNull
	@Column(name = "destination")
	private String destination;
	
	@NotNull
	@Column(name = "price")
	private double price;
	
	

	public long getId() {
		return id;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public LocalTime getDepartureTime() {
		return departureTime;
	}

	public LocalTime getArrivalTime() {
		return arrivalTime;
	}

	public String getOrigin() {
		return origin;
	}

	public String getDestination() {
		return destination;
	}

	public double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Flight [id=").append(id).append(", airlineName=").append(airlineName).append(", departureTime=")
				.append(departureTime).append(", arrivalTime=").append(arrivalTime).append(", origin=").append(origin)
				.append(", destination=").append(destination).append(", price=").append(price).append("]");
		return builder.toString();
	}
	
	
	
	
}
