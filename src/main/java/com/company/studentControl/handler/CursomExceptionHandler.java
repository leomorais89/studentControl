package com.company.studentControl.handler;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.company.studentControl.service.exception.ResourceNotFoundException;

@ControllerAdvice
public class CursomExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest r){
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError error = new StandardError(Instant.now(), status.value(), "Recurso não encontrado", e.getMessage(), r.getRequestURI());
		return ResponseEntity.status(status).body(error);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidationError> validation(MethodArgumentNotValidException e, HttpServletRequest r){
		HttpStatus status = HttpStatus.NOT_FOUND;
		ValidationError error = new ValidationError(Instant.now(), status.value(), "Erro de Validação", e.getMessage(), r.getRequestURI());
		for (FieldError x : e.getBindingResult().getFieldErrors()) {
			error.getErrors().add(new FieldMessage(x.getField(), x.getDefaultMessage()));
		}
		return ResponseEntity.status(status).body(error);
	}

}
