package com.service;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.dto.EngineerDto;
import com.entities.Complaint;
import com.entities.Engineer;



public interface IEngineerService {

	
	public List<Complaint> getAllOpenComplaints1(int engineerId);
	public List<Complaint> getResolvedComplaints1(int engineerId);
	public List<Complaint> getComplaintsbyid(int engineerId);
	//public List<Complaint> getComplaints();
	 public Complaint getComplaintt(int complaintId);
	 public Complaint updateComplaintByStatus(int complaintId , Complaint complaint);
	// public Complaint updateComplaint(int engineerId , Complaint complaint); // returns updated Status;	
}