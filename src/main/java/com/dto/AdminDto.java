package com.dto;

public class AdminDto {
	private String fullName;
	private String emailId;
	private long contactNumber;
	private String password;
	public AdminDto() {
		super();
	}
	
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "AdminDto [fullName=" + fullName + ", emailId=" + emailId + ", contactNumber=" + contactNumber
				+ ", password=" + password + "]";
	}
	
}