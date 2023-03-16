package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.exceptions.InValidComplaintException;
//import com.entities.BookComplaint;
import com.entities.Complaint;
import com.entities.Engineer;
import com.entities.Product;




@Service
public interface IComplaintService {
	
	public boolean bookComplaints(Complaint complaint);
	
    public Engineer getEngineer(int complaintId)throws InValidComplaintException;

   // Complaint changeComplaintStatus(int complaintId, Complaint status) throws Throwable;
    List<Complaint> getClientAllComplaints(String clientId);
    List<Complaint> getClientAllOpenComplaints(String clientId);
    Product getProductByComplaint(int complaintId) throws InValidComplaintException;

	
	List<Complaint> getComplaint();
	
	String deleteComplaintById(int complaintId);
	Complaint getComplaintt(int complaintId);
	Complaint updateComplaint(int complaintId, Complaint complaint);

	List<Engineer> saveEngineer(List<Engineer> e1);

	List<Product> saveProduct(List<Product> e2);

	//boolean bookComplaints(BookComplaint complaint);
}
