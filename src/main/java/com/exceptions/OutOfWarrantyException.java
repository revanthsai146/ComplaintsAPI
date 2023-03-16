package com.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class OutOfWarrantyException extends Exception{
	public OutOfWarrantyException(String message){
        super(message);
    }
}
