package com.facets.cloud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class InvalidConnectionException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -125542804797680792L;
	public InvalidConnectionException() {};
	public InvalidConnectionException(String message) {
		super(message);
	}
}
