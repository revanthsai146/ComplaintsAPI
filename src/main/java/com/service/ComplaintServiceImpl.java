package com.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.exceptions.InValidComplaintException;
//import com.entities.BookComplaint;
import com.entities.Complaint;
import com.entities.Engineer;
import com.entities.Product;
//import com.repository.BookComplaintRepository;
import com.repository.IComplaintRepository;
import com.repository.IEngineerRepository;
import com.repository.IProductRepository;

@Service
public class ComplaintServiceImpl implements IComplaintService {
	@Autowired
	IComplaintRepository repo;
	@Autowired
	IEngineerRepository repoe;
	@Autowired
	IProductRepository repository1;

	@Override
	public List<Complaint> getComplaint() {
		List<Complaint> p = repo.findAll();
		return p;
	}

	@Override
	public boolean bookComplaints(Complaint complaint) {
		repo.save(complaint);
		int id = complaint.getComplaintId();
		var a = repo.findById(id);
		System.out.println(id);
		if (a.isPresent()) {
			return true;
		} else {
			return false;
		}
	}

//  @Override 
//	  public Complaint changeComplaintStatus(int complaintId, Complaint complaint) throws Throwable 
//     { 
//	  Complaint a1=repo.findById(complaintId).orElseThrow();
//	 // a1.setComplaint(complaint); 
//	  return repo.save(a1); 
//	  
//     }
//	  //Complaint a =repo.findById(complaintId).orElseThrow();
////	  if(a.getComplaint()== complaint) {
////		return "successfully updated" ;
////		} 
////	  else { 
////	    return "failed"; 
////	    }				
////	  }
	@Override
	public Complaint updateComplaint(int complaintId, Complaint complaint) {
		Complaint a1 = repo.findById(complaintId).orElseThrow();
		a1.setStatus(complaint.getStatus());
		a1.setProductModelNumber(complaint.getProductModelNumber());
		a1.setClientId(complaint.getClientId());
		a1.setComplaintId(complaint.getComplaintId());
		a1.setEngineerId(complaint.getEngineerId());
		a1.setComplaintName(complaint.getComplaintName());
		return repo.save(a1);
	}

	@Override
	public List<Complaint> getClientAllComplaints(String clientId) {
		List<Complaint> lc1 = repo.getClientAllComplaints(clientId);
		return lc1;
	}

	@Override
	public List<Complaint> getClientAllOpenComplaints(String clientId) {
		List<Complaint> lc1 = repo.getClientAllOpenComplaints(clientId, "open");
		return lc1;
	}

	@Override
	public List<Engineer> saveEngineer(List<Engineer> e1) {
		repoe.saveAll(e1);
		return e1;
	}

	@Override
	public Engineer getEngineer(int complaintId) throws InValidComplaintException {
		Complaint a1 = repo.findById(complaintId).orElseThrow();
		var employeeId = a1.getEngineerId();
		Engineer c = repoe.getEngineer(employeeId);
		return c;
	}

	@Override
	public List<Product> saveProduct(List<Product> e2) {
		repository1.saveAll(e2);
		return e2;
	}

	@Override
	public Product getProductByComplaint(int complaintId) throws InValidComplaintException {
		Complaint a1 = repo.findById(complaintId).orElseThrow();
		var modelNumber=a1.getProductModelNumber();
		Product c=repository1.getProductByComplaint1(modelNumber);
		return c;
		
	}

	@Override
	public String deleteComplaintById(int complaintId) {

		repo.deleteById(complaintId);
		return "Data DELETE";
	}

	@Override
	public Complaint getComplaintt(int complaintId) {
		Complaint a1 = repo.findById(complaintId).orElseThrow();
		return a1;
	}
}
