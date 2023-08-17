package com.godknows.picpay.dtos;

import java.math.BigDecimal;

import com.godknows.picpay.entities.UserType;

public class UserDTO {
	
	private String firstName;
	private String lastName;
	private String document;
	private String email;
	private String password;
	private BigDecimal balance;
	private UserType userType;
	
	
	public UserDTO() {
	}


	public UserDTO( String firstName, String lastName, String document, String email, String password,
			BigDecimal balance,  UserType userType) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.document = document;
		this.email = email;
		this.password = password;
		this.balance = balance;
		this.userType = userType;
	}



	public String getFirstName() {
		return firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public String getDocument() {
		return document;
	}


	public String getEmail() {
		return email;
	}


	public String getPassword() {
		return password;
	}


	public BigDecimal getBalance() {
		return balance;
	}


	public UserType getUserType() {
		return userType;
	}
	
	
	
}
