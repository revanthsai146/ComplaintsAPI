package com.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.advices.InvalidCredentialsException;
import com.dto.LoginDto;
import com.entities.Login;
import com.exceptions.InvalidCredentialsException;
import com.service.LoginServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/Abc")
public class LoginController {
	@Autowired
	LoginServiceImpl loginservice;
	private LoginDto logindto;
	
	private static Logger logger = LogManager.getLogger();
	
	@PostMapping("/login")
	public ResponseEntity<LoginDto> login(@RequestBody Login login) throws InvalidCredentialsException
	{
		LoginDto dto=loginservice.login(login);
		return new ResponseEntity<>(dto,HttpStatus.OK);
	}
	
	@PatchMapping("/logout/{email}")
	public ResponseEntity<LoginDto> logout(@PathVariable("email") String Email) throws InvalidCredentialsException{
		logger.info(Email);
		LoginDto dto=loginservice.logout(Email);
		return new ResponseEntity<>(dto,HttpStatus.OK);
		
	}
	
}