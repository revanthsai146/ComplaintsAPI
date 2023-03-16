package com.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class InValidDomainException extends Exception {
	public InValidDomainException(String message){
        super(message);
    }

}
