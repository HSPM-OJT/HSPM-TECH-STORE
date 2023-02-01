package com.hspm.ojt.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST,code = HttpStatus.BAD_REQUEST,reason = "cause : Email is already exists")
public class EmailAlreadyExistException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9038718092673454266L;
	
	public EmailAlreadyExistException(String message) {
		super(message);
	}

}
