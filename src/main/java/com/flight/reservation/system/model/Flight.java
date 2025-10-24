package com.flight.reservation.system.model;

import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Flight {
	
	@Id
	@Column(name = "flight_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "airline_name")
	private String airlineName;
	
	@Column(name = "departure_time")
	@DateTimeFormat(pattern = "hh-mm-ss")
	private LocalTime departureTime;
	
	@Column(name = "arrival_time")
	@DateTimeFormat(pattern = "hh-mm-ss")
	private LocalTime arrivalTime;
	
	@Column(name = "origin")
	private String origin;
	
	@Column(name = "destination")
	private String destination;
	
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
