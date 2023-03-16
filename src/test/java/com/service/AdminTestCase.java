package com.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.entities.Complaint;
import com.entities.Engineer;
import com.repository.IComplaintRepository;
import com.repository.IEngineerRepository;
import com.repository.IProductRepository;

class AdminTestCase {
	@Autowired
	IAdminServiceimpl iadmin;
	
	@MockBean
	IComplaintRepository icr;
	@MockBean
	IEngineerRepository repo;
	@MockBean
	IProductRepository repoe;

	@Test
	@PostConstruct
	void testAddEngineer() {
		
		Engineer c=new Engineer();
		c.setDomain("engineer");
		c.setEmployeeId(1);
		//c.setComplaints(c1);
		c.setEngineerName("eng");
		c.setPassword("bbb");
		
		
       Mockito.when(repo.save(c)).thenReturn(c);
		
		assertThat(iadmin.addEngineer(c)).isEqualTo(c);
		
		
	}

}
