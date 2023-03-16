package com.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class InvalidEngineerIdException extends Exception {
	public InvalidEngineerIdException(String message){
        super(message);
    }
}
