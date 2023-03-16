package com.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Login")

public class Login{
	
	@Id
	@GeneratedValue
	private int loginId;
	
	private String email;
	
	@NotEmpty(message="Password cannot be Empty")
	private String password;
	
	private String role;
	
	@JsonIgnore
	private boolean isLoggedIn;
	
	//@JsonIgnore
	//@OneToOne
	/*
	 * private Users users;
	 * 
	 * public int getLoginId() { return loginId; }
	 */


	public void setLoginId(int loginId) {
		this.loginId = loginId;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
	

	public boolean isLoggedIn() {
		return isLoggedIn;
	}

	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}



	@Override
	public String toString() {
		return "Login [loginId=" + loginId + ", email=" + email + ", password=" + password + ", role=" + role
				+ ", isLoggedIn=" + isLoggedIn + "]";
	}

	




	
	
	
	
}