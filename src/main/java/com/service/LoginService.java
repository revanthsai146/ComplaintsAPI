package com.service;

import java.util.List;

import com.exceptions.InvalidCredentialsException;
import com.dto.LoginDto;
import com.entities.Login;

public interface LoginService {
	
	LoginDto login(Login login) throws InvalidCredentialsException;
	
	LoginDto logout(String email) throws InvalidCredentialsException;
}