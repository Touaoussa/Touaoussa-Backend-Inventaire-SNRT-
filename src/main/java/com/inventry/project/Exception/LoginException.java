package com.inventry.project.Exception;

public class LoginException extends Exception {
	
	public LoginException(String description) {
		super(description);
	}
	public LoginException(String code, String description) {
		super(description);
	}

}
