package com.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entities.Complaint;
import com.entities.Engineer;
import com.exceptions.InValidComplaintException;
import com.exceptions.InValidDomainException;
import com.exceptions.InvalidEngineerIdException;
import com.service.IEngineerService;
import com.service.IEngineerServiceimpl;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
@CrossOrigin
@RestController

public class EngineerController {
	
	@Autowired
	IEngineerServiceimpl engservice;
	
//	@GetMapping(path="/getComplaints")
//	public List<Complaint> getcomplaints1(){
//		List<Complaint> c1=engservice.getComplaints();
//		return c1;
//	}
	@GetMapping(path="/getallopencomplaints/{engineerId}")
	public List<Complaint> getAllOpenComplaints1(@PathVariable int  engineerId){
		List<Complaint> complaints = engservice.getAllOpenComplaints1(engineerId);
		return complaints;
	}
	
	@GetMapping(path="/resolvedcomplaints/{engineerId}")
	public List<Complaint> getResolvedComplaints1(@PathVariable int engineerId){
		List<Complaint> complaints = engservice.getResolvedComplaints1(engineerId);
		return complaints;
	}

	@GetMapping(path="/getComplaintsbyid/{engineerId}")
	public List<Complaint> getComplaintsbyid(int engineerId){
		List<Complaint> complaints = engservice.getComplaintsbyid(engineerId);
		return complaints;
	}
	 @GetMapping("/getComplaint/{complaintId}")
	  public ResponseEntity<Complaint> getComplaintt(@PathVariable int complaintId) throws InValidComplaintException {
	  Complaint c1=engservice.getComplaintt(complaintId);
	  ResponseEntity re=new ResponseEntity<Complaint>(c1,HttpStatus.OK); 
	  return re;
	  }
			
	 @PutMapping("/updateComplaintbyStatus/{complaintId}") 
	  public ResponseEntity<Complaint> updateComplaint( @PathVariable int complaintId,@RequestBody Complaint status) throws Throwable { 
		  Complaint a1=engservice.updateComplaintByStatus(complaintId,status); 
		  ResponseEntity re=new ResponseEntity<Complaint>(a1,HttpStatus.OK);
		  return re; 
		  }
	
}