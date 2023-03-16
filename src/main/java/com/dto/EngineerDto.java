package com.dto;

public class EngineerDto {
	
	private String engineerName;
	private String domain;
	private String password;
	private String email;
	public EngineerDto() {
		super();
	}
	public String getEngineerName() {
		return engineerName;
	}
	public void setEngineerName(String engineerName) {
		this.engineerName = engineerName;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "EngineerDto [engineerName=" + engineerName + ", domain=" + domain + ", password=" + password
				+ ", email=" + email + "]";
	}
	
}