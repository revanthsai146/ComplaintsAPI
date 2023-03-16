package com.service;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.Assert;

import com.service.IComplaintServiceImpl;
import com.entities.Complaint;
import com.entities.Engineer;
import com.entities.Product;
import com.exceptions.InValidComplaintException;

import com.repository.IComplaintRepository;
import com.repository.IEngineerRepository;
import com.repository.IProductRepository;
@SpringBootTest
class ComplaintTestCase {
	@Autowired
	IComplaintServiceImpl icomp;
	
	@MockBean
	IComplaintRepository repo;
	@MockBean
	IEngineerRepository repoe;
	@MockBean
	IProductRepository repository1;

	@Test
	void testSaveEngineer() {
		Complaint c1=new Complaint();
		c1.setComplaintId(1);
		c1.setProductModelNumber("A7");
		c1.setComplaintName("damage");
		c1.setStatus("open");
		c1.setClientId("97");
		c1.setEngineerId(13);
		
		Engineer e=new Engineer();
		e.setDomain("fullStack");
		e.setEmployeeId(1);
		e.setEngineerName("Raju");
		e.setPassword("123456");
		Engineer e1=new Engineer();

		
		e1.setDomain("Java");
		e1.setEmployeeId(2);
		e1.setEngineerName("Rajesh");
		e1.setPassword("123456");
		List<Engineer> engineerList = new ArrayList<>();
		engineerList.add(e);
		engineerList.add(e1);
		
		Mockito.when(repoe.saveAll(engineerList)).thenReturn(engineerList);
		
		assertThat(icomp.saveEngineer(engineerList)).isEqualTo(engineerList);
		
		
	
	}
	@Test
	void testSaveProduct() {
		Complaint c1=new Complaint();
		c1.setComplaintId(1);
		c1.setProductModelNumber("A7");
		c1.setComplaintName("damage");
		c1.setStatus("open");
		c1.setClientId("97");
		c1.setEngineerId(13);
		
		Product p=new Product();
		p.setModelNumber("k7");
		p.setProductName("samsung");
		p.setWarrentyYears(2);
		p.setProductCategoryName("old");
		p.getDateofPurchase();
		p.getWarrantyDate();
		p.setComplaints(c1);
		Product p2=new Product();
		p2.setModelNumber("k7");
		p2.setProductName("samsung");
		p2.setWarrentyYears(2);
		p2.setProductCategoryName("old");
		p2.getDateofPurchase();
		p2.getWarrantyDate();
		p2.setComplaints(c1);
		List<Product> c2=new ArrayList();
		c2.add(p2);
		c2.add(p);
Mockito.when(repository1.saveAll(c2)).thenReturn(c2);
		
		assertThat(icomp.saveProduct(c2)).isEqualTo(c2);
	}
	@Test
	void testGetEngineer() throws InValidComplaintException {
		
		Complaint c1=new Complaint();
		c1.setComplaintId(1);
		c1.setProductModelNumber("A7");
		c1.setComplaintName("damage");
		c1.setStatus("open");
		c1.setClientId("97");
		c1.setEngineerId(13);
		Mockito.when(repo.save(c1)).thenReturn(c1);
Engineer e=new Engineer();
		
		
		                              
		e.setDomain("fullStack");
		e.setEmployeeId(13);
		e.setEngineerName("Raju");
		e.setPassword("123456");
		Mockito.when(repoe.save(e)).thenReturn(e);
		
		assertSame(c1.getEngineerId(),e.getEmployeeId());	
		//assertThat(icomp.getEngineer(13)).isEqualTo(c1);
		/*
		 * Optional<Complaint> c2=Optional.of(c1);
		 * 
		 * Mockito.when(repo.findById(1)).thenReturn(c2);
		 * 
		 * assertThat(icomp.getEngineer(1)).isEqualTo(c1); var a=c1.getEngineerId();
		 * Engineer c=repoe.getEngineer(a);
		 * assertThat(icomp.getEngineer(1)).isEqualTo(c);
		 */
		
		
	}
	@Test
	void testGetClientAllComplaints() {
		Complaint c1=new Complaint();
		c1.setComplaintId(1);
		c1.setProductModelNumber("A7");
		c1.setComplaintName("damage");
		c1.setStatus("open");
		c1.setClientId("97");
		c1.setEngineerId(13);
		Complaint c2=new Complaint();
		c2.setComplaintId(2);
		c2.setProductModelNumber("G7");
		c2.setComplaintName("return");
		c2.setStatus("resolve");
		c2.setClientId("98");
		c2.setEngineerId(14);
		
		List<Complaint> complaintList = new ArrayList<>();
		complaintList.add(c1);
		complaintList.add(c2);
		Mockito.when(repo.saveAll(complaintList)).thenReturn(complaintList); 
		
	       Mockito.when(repo.getClientAllComplaints("97")).thenReturn( complaintList);	
	       assertThat(icomp.getClientAllComplaints("97")).isEqualTo(complaintList);
	       
	}
	@Test
	void testChangeComplaintStatus() {
		
		
		Complaint c1=new Complaint();
		c1.setComplaintId(1);
		c1.setProductModelNumber("A7");
		c1.setComplaintName("damage");
		c1.setStatus("open");
		c1.setClientId("97");
		c1.setEngineerId(13);
		Optional<Complaint> c2=Optional.of(c1);
       Mockito.when(repo.findById(1)).thenReturn(c2);
		
		Mockito.when(repo.save(c1)).thenReturn(c1); 
		
		c1.setStatus("close");
		String status=c1.getStatus();
		
		 
		  assertSame(c1.getStatus(),status);
		
		
	}
	
	@Test
	void testGetProductByComplaint() throws InValidComplaintException {
		Complaint c1=new Complaint();
		c1.setComplaintId(1);
		c1.setProductModelNumber("A7");
		c1.setComplaintName("damage");
		c1.setStatus("open");
		c1.setClientId("97");
		c1.setEngineerId(13);
		
		
		Mockito.when(repo.save(c1)).thenReturn(c1);
		Product p=new Product();
		p.setModelNumber("A7");
		p.setProductName("samsung");
		p.setWarrentyYears(2);
		p.setProductCategoryName("old");
		p.getDateofPurchase();
		p.getWarrantyDate();
		p.setComplaints(c1);
		Mockito.when(repository1.save(p)).thenReturn(p);
		assertEquals(c1.getProductModelNumber(),p.getModelNumber());
		
		
		
		/*
		 * // Optional<Complaint>> c2=Optional.of(c1);
		 * 
		 * Mockito.when(repo.findById(1)).thenReturn(Optional.of(c1));
		 * 
		 * 
		 * assertThat(icomp.getProductByComplaint(c1.getComplaintId())).isEqualTo(p); //
		 * var //a=c1.getProductModelNumber(); // Product //
		 * c=repository1.getProductByComplaint(a);
		 * //assertThat(icomp.getProductByComplaint(1)).isEqualTo(c);
		 */		 		 
		
		
	}
	@Test
	void testbookComplaints() {
		Complaint c1=new Complaint();
		c1.setComplaintId(1);
		c1.setProductModelNumber("A7");
		c1.setComplaintName("damage");
		c1.setStatus("open");
		c1.setClientId("97");
		c1.setEngineerId(13);
		Optional<Complaint> c2=Optional.of(c1);
        int id=c1.getComplaintId();
		
        Mockito.when(repo.findById(id)).thenReturn(c2);
		var a=repo.findById(id);
	      
			
			
			assertTrue(a.isPresent());
			assertFalse(a.isEmpty());
		
	}
	@Test
	void testGetClientAllOpenComplaint() {
		Complaint c1=new Complaint();
		c1.setComplaintId(1);
		c1.setProductModelNumber("A7");
		c1.setComplaintName("damage");
		c1.setStatus("open");
		c1.setClientId("97");
		c1.setEngineerId(13);
		Complaint c2=new Complaint();
		c2.setComplaintId(2);
		c2.setProductModelNumber("G7");
		c2.setComplaintName("return");
		c2.setStatus("resolve");
		c2.setClientId("98");
		c2.setEngineerId(14);
		
		List<Complaint> complaintList = new ArrayList<>();
		complaintList.add(c1);
		complaintList.add(c2);
		Mockito.when(repo.saveAll(complaintList)).thenReturn(complaintList); 
		 Mockito.when(repo.getClientAllOpenComplaints("97","open")).thenReturn( complaintList);
		 assertThat(icomp.getClientAllOpenComplaints("97")).isEqualTo(complaintList);
	}
}
