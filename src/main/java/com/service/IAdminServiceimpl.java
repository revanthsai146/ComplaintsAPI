package com.service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.lang.Throwable;
import java.sql.Date;import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.dto.AdminDto;
import com.dto.EngineerDto;
import com.entities.Admin;
import com.entities.Complaint;
import com.entities.Engineer;
import com.entities.Login;
import com.dto.LoginDto;
import com.exceptions.InValidDomainException;
import com.exceptions.InvalidEngineerIdException;
import com.repository.AdminRepository;
import com.repository.IComplaintRepository;
//import com.cg.model.Product;
//import com.exception.InValidClientIdException;
//import com.repository.IComplaintRepository;
//import com.repository.IEngineerRepository;
//import com.repository.IProductRepository;
import com.repository.IEngineerRepository;
import com.repository.IProductRepository;@Service


public class IAdminServiceimpl implements IAdminService{
@Autowired
AdminRepository adminrepo;

@Autowired
IEngineerRepository repo;
@Autowired
IComplaintRepository icr;
@Autowired
IProductRepository repoe;
@Override
public Engineer addEngineer(EngineerDto e) {
	
	Engineer eng=new Engineer();
	eng.setEngineerName(e.getEngineerName());
	eng.setDomain(e.getDomain());
	eng.setEmail(e.getEmail());
	eng.setPassword(e.getPassword());
	
	Login l=new Login();
	l.setEmail(e.getEmail());
	l.setPassword(e.getPassword());
	l.setRole("Engineer");
	l.setLoggedIn(false);
	eng.setLogin(l);


	repo.save(eng);
	return eng;
	
	
}
@Override
public Engineer changeDomain(int engineerId, Engineer engineer) throws InValidDomainException, InvalidEngineerIdException {
	Engineer c=new Engineer();
	Engineer id=repo.findById(engineerId).orElseThrow();
	id.setDomain(engineer.getDomain());
	id.setEngineerName(engineer.getEngineerName());
	id.setPassword(engineer.getPassword());
	
	
	
	repo.save(id);
	
	return id;
	
}
@Override
public String removeEngineer(int engineerId) throws InvalidEngineerIdException {
	Engineer c=new Engineer();
	Engineer id=repo.findById(engineerId).orElseThrow();
	repo.delete(id);
	return "deleted";
	
}
@Override
public List<Complaint> getComplaintsByProducts(String productCategoryName) {
	List<Complaint> lc1=icr.getComplaintsByProducts(productCategoryName);
	return lc1;	
}
@Override
public List<Complaint> getComplaints(String status) {
	List<Complaint> lc1=icr.getComplaints(status);
	return lc1;	
}
/*
 * @Override public Complaint replaceEngineerFromComplaint(int complaintId)
 * throws InValidDomainException { Complaint
 * a1=icr.findById(complaintId).orElseThrow();
 * 
 * 
 * 
 * 
 * }
 */
@Override
public List<Admin> getAdmins() {
	List<Admin> ad=adminrepo.findAll();
	return ad;
}
@Override
public Admin addAdmin(AdminDto a) {
	
	
    Admin ad=new Admin();
    ad.setFullName(a.getFullName());
	ad.setEmailId(a.getEmailId());
	ad.setContactNumber(a.getContactNumber());
	ad.setPassword(a.getPassword());
	Login l=new Login();
	
	l.setEmail(a.getEmailId());
	l.setPassword(a.getPassword());
	l.setRole("Admin");
	l.setLoggedIn(false);
	
	ad.setLogin(l);

	

	adminrepo.save(ad);
	return ad;
}
@Override
public List<Engineer> getEngineers() {
	// TODO Auto-generated method stub
	List<Engineer> en=repo.findAll();
	return en;
}
@Override
public Engineer getEngineer(int employeeId) {
	Engineer a1=repo.findById(employeeId).orElseThrow();	
	    
	return a1;
}
}