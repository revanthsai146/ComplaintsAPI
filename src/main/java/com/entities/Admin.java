package com.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
//import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="admin_table")
public class Admin {
	@Id
	@GeneratedValue
	
	private int adminId; // work like as employee id
	//@NotEmpty(message = "must have to fill password")
	//@Size(min = 8,message="password should have atleast 8 characters")
	private String fullName;
	private String password;
	//@NotNull(message="contact number should have to fill")
	//@Size(min = 10,max=10,message="password should have atleast 10 integers")

	private long contactNumber;
	//@NotEmpty(message = "must have to fill emailId")
	//@Email(message="please give the valid email")

	private String emailId;
	/*
	 * @OneToMany(cascade=CascadeType.ALL) private List<Engineer> engineer;
	 * 
	 * @OneToMany(cascade=CascadeType.ALL) private List<Complaint> complaint;
	 * 
	 * @OneToMany(cascade=CascadeType.ALL) private List<Product> product;
	 */
	 //@OneToMany(cascade=CascadeType.ALL) private List<Complaint> complaint;
	@JsonIgnore
	@OneToOne(cascade=CascadeType.ALL) 
	private Login login;

	public Admin() {
		super();
	}


	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	
	public String getFullName() {
		return fullName;
	}


//	public void setFullName(String fullName) {
//		this.fullName = fullName;
//	}


	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", fullName=" + fullName + ", password=" + password + ", contactNumber="
				+ contactNumber + ", emailId=" + emailId + ", login=" + login + "]";
	}


	public void setFullName(String fullName) {
		// TODO Auto-generated method stub
			this.fullName = fullName;

	}
}