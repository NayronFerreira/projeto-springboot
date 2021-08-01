package com.projetoCurso.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.projetoCurso.services.exceptions.DataBaseException;
import com.projetoCurso.services.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFoundException (ResourceNotFoundException e, HttpServletRequest request){
		String error= "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), error, request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	@ExceptionHandler(DataBaseException.class)
	public ResponseEntity<StandardError> dataBaseException (DataBaseException e, HttpServletRequest request){
		String error= "Database error";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(Instant.now(), status.value(), error, request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}
