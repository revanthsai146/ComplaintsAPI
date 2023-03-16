package com.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)

public class InvalidCredentialsException extends Exception {
	public InvalidCredentialsException(String message){
        super(message);
    }


}