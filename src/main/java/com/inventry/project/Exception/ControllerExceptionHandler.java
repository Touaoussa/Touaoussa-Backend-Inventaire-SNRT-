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
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
//@Order(Ordered.LOWEST_PRECEDENCE)
public class ControllerExceptionHandler  {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage> handleException(Exception e) {
		ErrorMessage emsg = new ErrorMessage("E000", "Erreur",HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(emsg, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(LoginException.class)
	public ResponseEntity<ErrorMessage> LoginException(Exception e) {
		ErrorMessage emsg = new ErrorMessage("E001", e.getMessage(),HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(emsg, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(DuplicateCDBException.class)
	public ResponseEntity<ErrorMessage> DuplicateCDBException(Exception e) {
		
		ErrorMessage emsg = new ErrorMessage("E002", e.getMessage(),HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(emsg, HttpStatus.BAD_REQUEST);
	}
	
	

	@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> methodArgumentNotValidException(MethodArgumentNotValidException e) {
		String message = e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
		ErrorMessage emsg = new ErrorMessage("E003", message,HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(emsg, HttpStatus.BAD_REQUEST);
    }
	
	
	
	
	@ExceptionHandler(SupportNotFoundException.class)
	public ResponseEntity<ErrorMessage> SupportNotFoundException(SupportNotFoundException e) {
		ErrorMessage emsg = new ErrorMessage("E004", e.getMessage(),HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(emsg, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(value = BadRequestException.class)
	public ResponseEntity<ErrorMessage> handleBadRequestException(BadRequestException e) {
		ErrorMessage emsg = new ErrorMessage("E001", e.getMessage(),HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(emsg, HttpStatus.BAD_REQUEST);
	} 
	

	/*@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<ErrorMessage> handleMethodArgumentNotValidException(SQLIntegrityConstraintViolationException e) {
		ErrorMessage emsg = new ErrorMessage("E004", "Code barre déja existé", HttpStatus.BAD_REQUEST);
		new ResponseEntity<>(emsg, HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(emsg, HttpStatus.BAD_REQUEST);
	}*/


/*	@ExceptionHandler(NullPointerException.class) 
	public ResponseEntity<ErrorMessage> handlesServerErrorException(NullPointerException e) {
		ErrorMessage emsg = new ErrorMessage("E003",e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		new ResponseEntity<>(emsg, HttpStatus.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<>(emsg, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@ExceptionHandler(value = HttpMessageNotReadableException.class)
	public ResponseEntity<ErrorMessage> handlesBadRequestException(HttpMessageNotReadableException e) {
		ErrorMessage emsg = new ErrorMessage("E002", e.getMessage(), HttpStatus.BAD_REQUEST);
		new ResponseEntity<>(emsg, HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(emsg, HttpStatus.BAD_REQUEST);
	}
	*/
	@ExceptionHandler(value = TokenException.class)
	public ResponseEntity<ErrorMessage> handleBadRequestException(TokenException e) {
		ErrorMessage emsg = new ErrorMessage("E007","Token Expiré",HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(emsg, HttpStatus.BAD_REQUEST);
	} 
	
	@ExceptionHandler(value = UsernameNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleUsernameNotFoundExceptionException(UsernameNotFoundException e) {
		ErrorMessage emsg = new ErrorMessage("E008","le mot de passe ou l'utilisateur est  erroné",HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(emsg, HttpStatus.BAD_REQUEST);
	} 
	
	
	
	
}
