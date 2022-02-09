package com.inventry.project.Exception;

import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<ErrorMessage> handleMethodArgumentNotValidException(SQLIntegrityConstraintViolationException e) {
		ErrorMessage emsg = new ErrorMessage("E004", "Code barre déja existé");
		new ResponseEntity<>(emsg, HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(emsg, HttpStatus.BAD_REQUEST);
	}

}
