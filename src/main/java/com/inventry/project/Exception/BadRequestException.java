package com.inventry.project.Exception;

public class BadRequestException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BadRequestException(String code, String description) {
		super(description);
	}
	
}
