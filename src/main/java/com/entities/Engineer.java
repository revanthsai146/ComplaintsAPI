package com.entities;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Engineer {
	@Id
	@GeneratedValue
	private int employeeId;
	// treat like login id
	@NotEmpty(message = "Password cannot be empty")
	@Size(min = 5, max = 16, message = "Enter Valid Password ")
	private String password;
	@Column(name = "engineerName", length = 40, nullable = false)
	private String engineerName;
	@NotNull(message = "Domain Should Not Be Null") 
	private String domain;
	private String email;// like washing machine , AC, Mobile phone
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@JsonIgnore
	@OneToOne(cascade=CascadeType.ALL) 
	private Login login;
	@OneToMany(cascade=CascadeType.ALL)
	//@JoinColumn(name="engineerId",referencedColumnName="employeeId")
	private List<Complaint> complaints=new ArrayList<Complaint>();
	//@ManyToOne(cascade=CascadeType.ALL)
	//private Admin admin;
	
//	public Admin getAdmin() {
//		return admin;
//	}
//	public void setAdmin(Admin admin) {
//		this.admin = admin;
//	}
	public Engineer() {
		super();
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	public List<Complaint> getComplaints() {
		return complaints;
	}
	public void setComplaints(Complaint complaints) {
		this.complaints.add(complaints) ;
	}
	@Override
	public String toString() {
		return "Engineer [employeeId=" + employeeId + ", password=" + password + ", engineerName=" + engineerName
				+ ", domain=" + domain + ", email=" + email + ", login=" + login + ", complaints=" + complaints + "]";
	}
}
	