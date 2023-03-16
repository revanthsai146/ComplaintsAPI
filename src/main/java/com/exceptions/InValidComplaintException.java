package com.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class InValidComplaintException extends Exception
{
	public InValidComplaintException(String message){
	        super(message);
	    }
}
