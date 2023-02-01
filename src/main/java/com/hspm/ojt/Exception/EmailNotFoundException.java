package com.hspm.ojt.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,code = HttpStatus.NOT_FOUND,reason = "cause : Cannot Find Email")
public class EmailNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3724096216485891959L;

	public EmailNotFoundException(String message) {
		super(message);
	}
}
