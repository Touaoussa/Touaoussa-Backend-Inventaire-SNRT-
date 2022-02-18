package com.inventry.project.Exception;

public class TokenException extends RuntimeException{
	private static final long serialVersionUID = 2L;
	
	public TokenException() {
		
	}
	public TokenException(String code, String description) {
		super(description);
	}
}
