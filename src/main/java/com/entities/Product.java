package com.entities;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
//import java.util.List;
import java.util.function.Supplier;

import javax.persistence.CascadeType;
//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.lang.NonNull;

@Entity
@Table(name="Product")
public class Product {
	@Id 
	
	private String modelNumber;
	@NonNull
	private String productName;	
	@NonNull
	private String productCategoryName;// washing machine , TV,AC,SmartPhone	
    @NonNull
	private String dateofPurchase;
    @NonNull
	private int warrantyYears;
	@NonNull	 
	private String warrantyDate; 
	@OneToMany(cascade=CascadeType.ALL)
	private List<Complaint> complaints=new ArrayList<Complaint>();
	public String getModelNumber() {
		return modelNumber;
	}
	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCategoryName() {
		return productCategoryName;
	}
	public void setProductCategoryName(String productCategoryName) {
		this.productCategoryName = productCategoryName;
	}
	public String getDateofPurchase() {
		return dateofPurchase;
	}
	public void setDateofPurchase(String dateofPurchase) {
		this.dateofPurchase = dateofPurchase;
	}
	public int getWarrantyYears() {
		return warrantyYears;
	}
	public void setWarrantyYears(int warrentyYears) {
		this.warrantyYears = warrentyYears;
	}
	public String getWarrantyDate() {
		return warrantyDate;
	}
	public void setWarrantyDate(String warrantyDate) {
		this.warrantyDate = warrantyDate;
	}
	public List<Complaint> getComplaints() {
		return complaints;
	}
	public void setComplaints(Complaint complaints) {
		this.complaints.add(complaints) ;
	}
	@Override
	public String toString() {
		return "Product [modelNumber=" + modelNumber + ", productName=" + productName + ", productCategoryName="
				+ productCategoryName + ", dateofPurchase=" + dateofPurchase + ", warrantyYears=" + warrantyYears
				+ ", warrantyDate=" + warrantyDate + ", complaints=" + complaints + "]";
	}
	
	
	
	

}
