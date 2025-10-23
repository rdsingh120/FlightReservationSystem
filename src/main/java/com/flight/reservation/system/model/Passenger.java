package com.flight.reservation.system.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.jsf.FacesContextUtils;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;

@Entity
public class Passenger {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long passenger_id;
	private String name;
	private String nationality;
	
	@Column(name="passportnumber")
	private String passportNumber;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="issuedate")
	private LocalDate issueDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="expirydate")
	private LocalDate expiryDate;
	
	@Email
	@Column(unique = true, nullable = false)
	private String email;
	
	private String password;
	private String phonenumber;
	private String address;
	
	

	public Passenger() {
	}

	public Passenger(String name, @Email String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}

	
	
	public Passenger(String name, String nationality, String passportNumber, LocalDate issueDate, LocalDate expiryDate,
			@Email String email, String password, String phonenumber, String address) {
		this.name = name;
		this.nationality = nationality;
		this.passportNumber = passportNumber;
		this.issueDate = issueDate;
		this.expiryDate = expiryDate;
		this.email = email;
		this.password = password;
		this.phonenumber = phonenumber;
		this.address = address;
	}

	
	public long getPassenger_id() {
		return passenger_id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	public LocalDate getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Passenger [passenger_id=").append(passenger_id).append(", name=").append(name)
				.append(", nationality=").append(nationality).append(", passportNumber=").append(passportNumber)
				.append(", issueDate=").append(issueDate).append(", expiryDate=").append(expiryDate).append(", email=")
				.append(email).append(", password=").append(password).append(", phonenumber=").append(phonenumber)
				.append(", address=").append(address).append("]");
		return builder.toString();
	}
	
	
	
	
}
