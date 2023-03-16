package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.exceptions.InValidClientIdException;
import com.exceptions.InvalidEngineerIdException;
import com.entities.Client;
import com.entities.Complaint;
import com.entities.Engineer;
@Service
public interface IClientService {

	Client saveClient(Client c);

	Client getClientByCLientId(int clientId) throws Throwable;
	
	List<Client> getAllClients();
	
	Engineer getEngineerById(int id) throws InvalidEngineerIdException, Throwable;
   
	Client removeClient(Client c);
    
	List<Engineer> getEngineersByDomain(String category);
	

	String changeStatusOfComplaint(Complaint c);
	
	
}