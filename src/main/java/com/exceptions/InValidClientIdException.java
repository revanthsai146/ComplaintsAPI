package com.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class InValidClientIdException extends Exception {

	public InValidClientIdException(String message){
	        super(message);
	    }
}
