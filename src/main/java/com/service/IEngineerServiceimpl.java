package com.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.lang.Throwable;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.exceptions.InValidClientIdException;
import com.exceptions.InvalidEngineerIdException;
import com.dto.EngineerDto;
import com.entities.Complaint;
import com.entities.Engineer;
import com.repository.IComplaintRepository;
import com.repository.IEngineerRepository;

@Service
public class IEngineerServiceimpl implements IEngineerService {
	@Autowired
	IEngineerRepository repo;
	@Autowired
	IComplaintRepository icr;

	
	
	@Override
	public List<Complaint> getAllOpenComplaints1(int engineerId) {
		
		List<Complaint> l1 = icr.getAllOpenComplaints1(engineerId);
		return l1;
	}

	@Override
	public List<Complaint> getResolvedComplaints1(int engineerId){
		
		List<Complaint> l1 = icr.getResolvedComplaints1(engineerId);
		return l1;
	}

	@Override
	public List<Complaint> getComplaintsbyid(int engineerId) {
		
		List<Complaint> l1 = icr.getComplaints1(engineerId);
		return l1;
	}
	
//	@Override
//	  public Complaint updateComplaint(int engineerId , Complaint complaint) {
//		
//		  Complaint a1=icr.findById(engineerId).orElseThrow();
//		  a1.setStatus(complaint.getStatus());
//		  a1.setProductModelNumber(complaint.getProductModelNumber());
//		  a1.setClientId(complaint.getClientId());
//		  a1.setComplaintId(complaint.getComplaintId());
//		  a1.setEngineerId(complaint.getEngineerId());
//		  a1.setComplaintName(complaint.getComplaintName());
//		  return icr.save(a1);
//	  }

//	@Override
//	public String changeComplaintStatus(int engineerId) throws Throwable {
//		Supplier s1=()->new InvalidEngineerIdException("Id does not Exist");
//		Complaint c1 = icr.findById(engineerId).orElseThrow(s1);
//		if (c1.getStatus().equalsIgnoreCase("open") ){
//			c1.setStatus("resolved");
//			icr.save(c1);
//		}
//		return "status updated";
//	}
//
//	@Override
//	public List<Complaint> getComplaints() {
//		List<Complaint> c1=icr.findAll();// TODO Auto-generated method stub
//		return c1;
//	}
	 @Override 
	 
	  public Complaint updateComplaintByStatus(int complaintId , Complaint complaint) {
		  Complaint a1=icr.findById(complaintId).orElseThrow();
		 if(a1.getStatus().equalsIgnoreCase("open"))
		  a1.setStatus("resolved");
		 else if(a1.getStatus().equalsIgnoreCase("resolved"))
			 a1.setStatus("open");
		  return icr.save(a1);
	  }
	 @Override
		public Complaint getComplaintt(int complaintId) {
			Complaint a1=icr.findById(complaintId).orElseThrow();
			return a1;
		}

	
}