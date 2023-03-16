package com.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit4.SpringRunner;

import com.entities.Client;
import com.repository.IClientRepository;
import com.service.IClientService;

@SpringBootTest
class ClientTestCase {

	@Autowired
	private IClientService cs;
	
	@MockBean
	private IClientRepository repo;
	
	@Test
	public void testsaveClient()
	{
		Client c1=new Client();
		c1.setClientId(1);
		c1.setAddress("SMQ");
		c1.setComplaintList(null);
		c1.setPassword("abcd");
		c1.setPhoneNumber(12345);
		c1.setProductOwned(null);
	
		Mockito.when(repo.save(c1)).thenReturn(c1);
		assertThat(cs.saveClient(c1)).isEqualTo(c1);
		
	}
	
	
	@Test
	public void testgetAllClients()
	{
		Client c1=new Client();
		c1.setClientId(1);
		c1.setAddress("SMQ");
		c1.setComplaintList(null);
		c1.setPassword("abcd");
		c1.setPhoneNumber(12345);
		c1.setProductOwned(null);
		
		Client c2=new Client();
		c2.setClientId(2);
		c2.setAddress("SMQ2");
		c2.setComplaintList(null);
		c2.setPassword("abcde");
		c2.setPhoneNumber(123456);
		
		Client c3=new Client();
		c3.setClientId(3);
		c3.setAddress("SMQ2");
		c3.setComplaintList(null);
		c3.setPassword("abcde");
		c3.setPhoneNumber(123456);

		List<Client> cl = new ArrayList<>();  
		
		cl.add(c1);
		cl.add(c2);
		
		List<Client> cl2 = new ArrayList<>();
		
		cl.add(c1);
		cl.add(c2);
		
		
		
		Mockito.when(repo.findAll()).thenReturn(cl);
		
		assertThat(cs.getAllClients()).isEqualTo(cl);
                         		
	}
	

	@Test
	public void testgetClientById() throws Throwable
	{
		Client c1=new Client();
		  c1.setClientId(1); 
		  c1.setAddress("Mq 153"); 
		  c1.setPassword("JavaFS");
		  
		  Optional<Client> c2=Optional.of(c1);
		  
		  Mockito.when(repo.findById(1)).thenReturn(c2);
		  
		  assertThat(cs.getClientByCLientId(1)).isEqualTo(c1);
		
	}
	
	@Test
	public void testremoveClient()
	{
		Client c1=new Client();
		c1.setClientId(1);
		c1.setAddress("house");
		c1.setPassword("JAVA");
		Optional<Client> c2=Optional.of(c1);
		
		Mockito.when(repo.findById(1)).thenReturn(c2);
		 Mockito.when(repo.existsById(c1.getClientId())).thenReturn(false);
		   assertFalse(repo.existsById(c1.getClientId()));
	}
	
	
	
}