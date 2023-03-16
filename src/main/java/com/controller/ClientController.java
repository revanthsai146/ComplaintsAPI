package com.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.entities.Client;
import com.entities.Engineer;
import com.service.IClientServiceimpl;
@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping(path="/api")
public class ClientController {
	@Autowired
	IClientServiceimpl cs;   
	
	@PostMapping(path="/saveClient")
	public ResponseEntity<Client> saveClient(@RequestBody Client c)
	 { Client c1=cs.saveClient(c);
		ResponseEntity<Client> re=new ResponseEntity<Client>(c1,HttpStatus.ACCEPTED);
		return re;
	 }
	
	@GetMapping(path="/getClient/{clientId}")
	public  ResponseEntity<Client>  getClientByClientId(@PathVariable int clientId) throws Throwable
	{
		Client c1=cs.getClientByCLientId(clientId);
		ResponseEntity<Client> re=new ResponseEntity<Client>(c1,HttpStatus.OK);
		return re;
	}

	@GetMapping(path="/getAll")
	public ResponseEntity<List<Client>> getAllClients()
	{
		List<Client> c1=cs.getAllClients();
		ResponseEntity<List<Client>> re=new ResponseEntity<List<Client>>(c1,HttpStatus.OK);
		return re;
	}
	
	@GetMapping(path="/getEmp/{employeeId}")
	public ResponseEntity<Engineer> test(@PathVariable int employeeId) throws Throwable
	{
		Engineer e1=cs.getEngineerById(employeeId);
		ResponseEntity<Engineer> re=new ResponseEntity<Engineer>(e1,HttpStatus.OK);
	    return re;
	}
	
	@DeleteMapping(path="/removeClient/{c}")
	public ResponseEntity<Client> removeClient(@PathVariable Client c)
	{
		Client c1=cs.removeClient(c);
		ResponseEntity<Client> re=new ResponseEntity<Client>(c1,HttpStatus.OK);
		return  re;
	}
	
	@GetMapping(path="/getByDomain/{category}")
	public ResponseEntity<List<Engineer>> getEngineersByDomain(@PathVariable String category)
	{
	List<Engineer> le=cs.getEngineersByDomain(category);
	 ResponseEntity<List<Engineer>>	re= new ResponseEntity<List<Engineer>>(le,HttpStatus.OK);
	 return re;
	}
	
		/* done
		 * @GetMapping(path="/getClientByClientId/{clientId}") public
		 * ResponseEntity<Client> getClientByClientId(@PathVariable String clientId)
		 * throws InvalidClientIdException { Client c1=cs.getClientByCLientId(clientId);
		 * ResponseEntity re=new ResponseEntity<Client>(c1,HttpStatus.OK);
		 * 
		 * if(clientId!=null) {re=new ResponseEntity<Client>(c1,HttpStatus.OK);} else
		 * {re= new ResponseEntity<Client>(c1,HttpStatus.NOT_FOUND);}
		 * 
		 * return re; }
		 *done
		 * @GetMapping(path="/getEngineerById/{id}") public ResponseEntity<Engineer>
		 * getEngineerById(@PathVariable int id) throws InvalidEngineerIdException {
		 * Engineer c1=cs.getEngineerById(id); ResponseEntity re=new
		 * ResponseEntity<Engineer>(c1,HttpStatus.OK);
		 * 
		 * if(id>0) {re=new ResponseEntity<Engineer>(c1,HttpStatus.OK);} else {re= new
		 * ResponseEntity<Engineer>(c1,HttpStatus.NOT_FOUND);} return re; }
		 * 
		 * done
		 * @GetMapping(path="/getEngineersByDomain/{category}") public List<Engineer>
		 * getEngineersByDomain(@PathVariable String category) { List<Engineer>
		 * le=cs.getEngineersByDomain(category); return le; }
		 */
	
	/*
	 * @PutMapping(path="/chnageStatusOfComplaint") public ResponseEntity<String>
	 * chnageStatusOfComplaint(@RequestBody int complaintId) { String str="";
	 * ResponseEntity re=new ResponseEntity<Engineer>(c1,HttpStatus.OK); }
	 */
}