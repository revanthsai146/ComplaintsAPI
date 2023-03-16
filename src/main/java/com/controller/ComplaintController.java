package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.exceptions.InValidComplaintException;
//import com.entities.BookComplaint;
import com.entities.Complaint;
import com.entities.Engineer;
import com.entities.Product;
import com.service.ComplaintServiceImpl;
//import com.service.IComplaintServiceImpl;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/api")
public class ComplaintController {
	@Autowired
	ComplaintServiceImpl icomp;

	@GetMapping("/complaints")
	public List<Complaint> getComplaint() {
		List<Complaint> d = icomp.getComplaint();
		return d;
	}

	@PostMapping("/Complaints")
	public boolean bookComplaints(@RequestBody Complaint complaint) {
		boolean d = icomp.bookComplaints(complaint);
		return d;

	}

	@GetMapping("/getComplaint/{complaintId}")
	public ResponseEntity<Complaint> getComplaintt(@PathVariable int complaintId) throws InValidComplaintException {
		Complaint c1 = icomp.getComplaintt(complaintId);
		ResponseEntity re = new ResponseEntity<Complaint>(c1, HttpStatus.OK);
		return re;
	}

	@PutMapping("/updateComplaint/{complaintId}")
	public ResponseEntity<Complaint> updateComplaint(@PathVariable int complaintId, @RequestBody Complaint complaint)
			throws Throwable {
		Complaint a1 = icomp.updateComplaint(complaintId, complaint);
		ResponseEntity re = new ResponseEntity<Complaint>(a1, HttpStatus.OK);
		return re;
	}

	@GetMapping("/getAllComplaint/{clientId}")
	public ResponseEntity<List<Complaint>> getClientAllComplaints(@PathVariable String clientId) {
		List<Complaint> le = icomp.getClientAllComplaints(clientId);
		ResponseEntity re = new ResponseEntity<List<Complaint>>(le, HttpStatus.OK);
		return re;
	}

	@GetMapping("/getAllOpenComplaint/{clientId}")
	public ResponseEntity<List<Complaint>> getClientAllOpenComplaints(@PathVariable String clientId) {
		List<Complaint> le = icomp.getClientAllOpenComplaints(clientId);
		ResponseEntity re = new ResponseEntity<List<Complaint>>(le, HttpStatus.OK);
		return re;
	}

	@DeleteMapping(path = "/deleteCode/{complaintId}")
	public ResponseEntity<String> deleteComplaintById(@PathVariable int complaintId) {
		icomp.deleteComplaintById(complaintId);
		ResponseEntity re = new ResponseEntity("DELETED", HttpStatus.OK);
		return re;
	}
	@PostMapping("/saveProduct") 
	  public List<Product> saveProduct(@RequestBody List<Product> e2) { 
		  List<Product> d=icomp.saveProduct(e2); 
	  return d; 
	  }
	
	@PostMapping("/saveEngineer")
	public List<Engineer> savesEngineer(@RequestBody List<Engineer> e1) {
		List<Engineer> d = icomp.saveEngineer(e1);
		return d;
	}

	@GetMapping("/getEngineer/{complaintId}")
	public ResponseEntity<Engineer> getEngineer(@PathVariable int complaintId) throws InValidComplaintException {
		Engineer c1 = icomp.getEngineer(complaintId);
		ResponseEntity re = new ResponseEntity<Engineer>(c1, HttpStatus.OK);
		return re;
	}

	@GetMapping("/getProduct/{complaintId}")
	public ResponseEntity<Product> getProductByComplaint(@PathVariable int complaintId)
			throws InValidComplaintException {
		Product c1 = icomp.getProductByComplaint(complaintId);
		ResponseEntity re = new ResponseEntity<Product>(c1, HttpStatus.OK);
		return re;
	}

}
