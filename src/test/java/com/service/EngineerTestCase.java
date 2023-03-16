package com.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.entities.Complaint;
import com.entities.Engineer;
import com.repository.IComplaintRepository;
import com.repository.IEngineerRepository;

@SpringBootTest
class EngineerTestCase {

	@Autowired
	IEngineerServiceimpl engservice;
	
	@Autowired
	IComplaintService cs;
	
	@MockBean
	IEngineerRepository repo;
	
	@MockBean
	IComplaintRepository crepo;
	
	@Test
	void testGetAllOpenComplaints1() {
		Complaint c = new Complaint();
		c.setComplaintId(101);
		c.setProductModelNumber("J8");
		c.setComplaintName("Rajat");
		c.setStatus("open");
		c.setClientId("123");
		c.setEngineerId(909);
		
		Complaint c1 = new Complaint();
		c1.setComplaintId(104);
		c1.setProductModelNumber("J9");
		c1.setComplaintName("Deepak");
		c1.setStatus("resolved");
		c1.setClientId("123");
		c1.setEngineerId(98);
		
		List<Complaint> complaintList = new ArrayList<>();
		complaintList.add(c);
		complaintList.add(c1);
		
		Mockito.when(crepo.saveAll(complaintList)).thenReturn(complaintList);
		//assertThat(engservice.getAllOpenComplaints1(c.getEngineerId())).isEqualTo(c);
	}

//	@Test
//	void testGetResolvedComplaints() {
//		Complaint c = new Complaint();
//		c.setComplaintId(101);
//		c.setProductModelNumber("J8");
//		c.setComplaintName("Rajat");
//		c.setStatus("open");
//		c.setClientId("123");
//		c.setEngineerId(909);
//		
//		Complaint c1 = new Complaint();
//		c1.setComplaintId(104);
//		c1.setProductModelNumber("J9");
//		c1.setComplaintName("Deepak");
//		c1.setStatus("resolved");
//		c1.setClientId("123");
//		c1.setEngineerId(98);
//		
//		List<Complaint> complaintList = new ArrayList<>();
//		complaintList.add(c);
//		complaintList.add(c1);
//		
//		Mockito.when(crepo.saveAll(complaintList)).thenReturn(complaintList);
//		assertThat(engservice.getAllOpenComplaints()).isEqualTo(c1);
//	}
//
	@Test
	void testGetComplaints() {
		Complaint c1=new Complaint();
		c1.setClientId("str123");
		c1.setComplaintId(2);
		c1.setComplaintName("fan not worked");
		c1.setEngineerId(1);
		c1.setProductModelNumber("fan123");
		c1.setStatus("open");
		
		List<Complaint> l1=new ArrayList<Complaint>();
		
		l1.add(c1);
		Mockito.when(crepo.findAll()).thenReturn(l1);
		//assertThat(engservice.getComplaints(c1.getEngineerId())).isEqualTo(l1);	
		}

	@Test
	void testChangeComplaintStatus() {
		Complaint c = new Complaint();
		c.setComplaintId(1);
		c.setProductModelNumber("J8");
		c.setComplaintName("Rajat");
		c.setStatus("open");
		c.setClientId("123");
		c.setEngineerId(909);
		Optional<Engineer> c1 =  Optional.empty();
		Mockito.when(repo.findById(1)).thenReturn(c1);
		Mockito.when(crepo.save(c)).thenReturn(c);
		c.setComplaintId(1);
		c.setProductModelNumber("J8");
		c.setComplaintName("Rajat");
		c.setStatus("resolved");
		c.setClientId("123");
		c.setEngineerId(909);
		Mockito.when(crepo.save(c)).thenReturn(c);
		try {
			assertThat(engservice.changeComplaintStatus(c.getComplaintId())).isEqualTo(c.getComplaintId());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
