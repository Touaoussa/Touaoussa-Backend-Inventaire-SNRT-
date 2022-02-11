package com.inventry.project.Exception;

import lombok.Data;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;


public class ErrorMessage {

	private String code;
	private String description;
	private Map<String,String> errors=new HashMap<>();
	 private HttpStatus status;

	public ErrorMessage() {
		super();
	}

	public ErrorMessage(String code, String description,HttpStatus status) {
		this.code = code;
		this.description = description;
		this.status=status;
	}

	public Map<String, String> getErrors() {
		return errors;
	}

	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	
	
	
}
