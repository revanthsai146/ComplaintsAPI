package com.dto;

public class LoginDto {
	private String email;
	private boolean isLoggedIn;
	private String role;
	
	
	public LoginDto() {
		super();
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isLoggedIn() {
		return isLoggedIn;
	}
	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "LoginDto [email=" + email + ", isLoggedIn=" + isLoggedIn + ", role=" + role + "]";
	}

	
	
	}