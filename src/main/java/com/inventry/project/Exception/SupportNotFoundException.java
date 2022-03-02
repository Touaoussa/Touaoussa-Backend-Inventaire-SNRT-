package com.inventry.project.Exception;

public class SupportNotFoundException extends Exception{

	public SupportNotFoundException(String description) {
		super(description);
	}
	
	public SupportNotFoundException(String code, String description) {
		super(description);
	}
	
}
