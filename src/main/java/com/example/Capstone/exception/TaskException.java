package com.example.Capstone.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value= HttpStatus.NOT_FOUND)

public class TaskException extends RuntimeException {
private static final long serialVersionUID = 1L;
	
	
	public TaskException(String message) {
    	super(message);
    }
}
