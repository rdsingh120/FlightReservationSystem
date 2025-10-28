package com.flight.reservation.system.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@Entity
public class Passenger {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long passenger_id;
	
	@NotNull
	@Column(name="firstname", nullable = false)
	private String firstName;
	
	@NotNull
	@Column(name="lastname", nullable = false)
	private String lastName;
	
	private String nationality;
	
	@Column(name="passportnumber")
	private String passportNumber;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="issuedate")
	private LocalDate issueDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="expirydate")
	private LocalDate expiryDate;
	
	@NotNull
	@Email
	@Column(unique = true, nullable = false)
	private String email;
	
	@NotNull
	private String password;
	
	private String phonenumber;
	
	@Column(name="streetaddress")
	private String streetAddress;
	
	@Column(name="streetaddressline2")
	private String streetAddressLine2;
	private String city;
	
	private String province;
	
	@Column(name="postalcode")
	private String postalCode;
	
	private String country;
	
	public Passenger() {}

	public Passenger(String firstName, String lastName, @Email String email, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	public long getPassenger_id() {
		return passenger_id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getStreetAddressLine2() {
		return streetAddressLine2;
	}

	public void setStreetAddressLine2(String streetAddressLine2) {
		this.streetAddressLine2 = streetAddressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Passenger [passenger_id=").append(passenger_id).append(", firstName=").append(firstName)
				.append(", lastName=").append(lastName).append(", nationality=").append(nationality)
				.append(", passportNumber=").append(passportNumber).append(", issueDate=").append(issueDate)
				.append(", expiryDate=").append(expiryDate).append(", email=").append(email).append(", password=")
				.append(password).append(", phonenumber=").append(phonenumber).append(", streetAddress=")
				.append(streetAddress).append(", streetAddressLine2=").append(streetAddressLine2).append(", city=")
				.append(city).append(", province=").append(province).append(", postalCode=").append(postalCode)
				.append(", country=").append(country).append("]");
		return builder.toString();
	}
	
	

	
}
	
