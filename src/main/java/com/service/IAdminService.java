package com.service;

import java.util.List;

import com.dto.AdminDto;
import com.dto.EngineerDto;
import com.entities.Admin;
import com.entities.Complaint;
import com.entities.Engineer;
import com.exceptions.InValidDomainException;
import com.exceptions.InvalidEngineerIdException;

public interface IAdminService {
	public List<Admin> getAdmins();
	public Admin addAdmin(AdminDto a);
	public Engineer addEngineer(EngineerDto e);
	public List<Engineer> getEngineers();
	public Engineer changeDomain(int engineerId,Engineer newDomain)throws InValidDomainException,InvalidEngineerIdException;
	public String removeEngineer(int engineerId)throws InvalidEngineerIdException;
	
	public List<Complaint> getComplaintsByProducts(String productCategoryName);
	//public List<Complaint> getComplaints(String status,String productCategoryName);
	
	//public Complaint replaceEngineerFromComplaint(int complaintId)throws InValidDomainException; // replace engineer from the complaint and allocate new engineer
	List<Complaint> getComplaints(String status);
	//Engineer addEngineer(Engineer e);
	Engineer getEngineer(int employeeId);
	
	
}