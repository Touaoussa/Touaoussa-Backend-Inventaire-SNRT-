package com.inventry.project.Exception;

import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ControllerExceptionHandler {
	
	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<ErrorMessage> handleMethodArgumentNotValidException(SQLIntegrityConstraintViolationException e) {
		ErrorMessage emsg = new ErrorMessage("E004", "Code barre déja existé");
		new ResponseEntity<>(emsg, HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(emsg, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = BadRequestException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<ErrorMessage> handleBadRequestException(BadRequestException e) {
		ErrorMessage emsg = new ErrorMessage("E001", "test");
		//new ResponseEntity<>(emsg, HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(emsg, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = HttpMessageNotReadableException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<ErrorMessage> handlesBadRequestException(HttpMessageNotReadableException e) {
		ErrorMessage emsg = new ErrorMessage("E002", e.getMessage());
		new ResponseEntity<>(emsg, HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(emsg, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<ErrorMessage> handlesServerErrorException(NullPointerException e) {
		ErrorMessage emsg = new ErrorMessage("E003","test");
		new ResponseEntity<>(emsg, HttpStatus.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<>(emsg, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
}
