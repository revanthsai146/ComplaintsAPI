package com.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.lang.NonNull;

@Entity
public class Client {
	@Id
	@GeneratedValue
	//@Column(name="clientId")
	@NonNull
	private int clientId;
	@NonNull
	private String password;
	private String address;
	@NonNull
	private long phoneNumber;
		
	@OneToMany(targetEntity = Product.class,cascade=CascadeType.ALL)
	//@JoinColumn(name="clientId_fk",referencedColumnName = "clientId")
	 private List<Product> productOwned;
		  
	@OneToMany(cascade = CascadeType.ALL)
	// @JoinColumn(name="clientId",referencedColumnName = "clientId")
	 private List<Complaint> complaintList; // client can view all complaints
		 
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	  public List<Product> getProductOwned() 
	  { return productOwned; } 
	  
	  public void setProductOwned(List<Product> productOwned) 
	  { this.productOwned =
	  productOwned; }
	  
	  
	  public List<Complaint> getComplaintList() 
	  { return complaintList; } 
	  
	  public void setComplaintList(List<Complaint> complaintList)
	  { this.complaintList =
	  complaintList; }
	  
	  @Override 
	  public String toString() { return "Client [clinetId=" + clientId +
	  ", password=" + password + ", address=" + address + ", phoneNumber=" +
	  phoneNumber + ", productOwned=" + productOwned + ", complaintList=" + "]"; }
	 
	
	
}
