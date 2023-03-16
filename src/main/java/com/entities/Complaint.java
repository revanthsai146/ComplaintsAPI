package com.entities;

import java.util.function.Supplier;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
public class Complaint {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int complaintId;

	private String productModelNumber; // complaint product model number, Model Number from Product Class

	private String complaintName;

	private String status; // open , resolve online , resolve after home visit , resolved , closed
	// note : engineer cannot open or close the complaint
	// @ManyToOne(targetEntity = Client.class,cascade=CascadeType.ALL)
	private int clientId;
	//@Column(name="engineerId")
	private int engineerId;
	public int getComplaintId() {
		return complaintId;
	}
	public void setComplaintId(int complaintId) {
		this.complaintId = complaintId;
	}
	public String getProductModelNumber() {
		return productModelNumber;
	}
	public void setProductModelNumber(String productModelNumber) {
		this.productModelNumber = productModelNumber;
	}
	public String getComplaintName() {
		return complaintName;
	}
	public void setComplaintName(String complaintName) {
		this.complaintName = complaintName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public int getEngineerId() {
		return engineerId;
	}
	public void setEngineerId(int engineerId) {
		this.engineerId = engineerId;
	}
	@Override
	public String toString() {
		return "Complaint [complaintId=" + complaintId + ", productModelNumber=" + productModelNumber
				+ ", complaintName=" + complaintName + ", status=" + status + ", clientId=" + clientId + ", engineerId="
				+ engineerId + "]";
	}
	
	

}
