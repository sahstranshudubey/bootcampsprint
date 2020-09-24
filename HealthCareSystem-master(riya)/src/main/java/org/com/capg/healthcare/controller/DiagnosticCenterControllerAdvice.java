package org.com.capg.healthcare.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.LocalDateTime;

import org.com.capg.healthcare.dto.ErrorMessage;
import org.com.capg.healthcare.exception.*;

@RestController
@RestControllerAdvice
public class DiagnosticCenterControllerAdvice {

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(NameAlreadyExistException.class)
	public ErrorMessage handleNameAlreadyExistException(NameAlreadyExistException ex)
	{
	 return new ErrorMessage(HttpStatus.BAD_REQUEST.toString(), ex.getMessage(), LocalDateTime.now().toString());
	       //To Handle CenterName Already Exist Exception	
	}
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(CenterNotFoundException.class)
	public ErrorMessage handleCenterNotFoundException(CenterNotFoundException ex)
	{
	  return new ErrorMessage(HttpStatus.NOT_FOUND.toString(), ex.getMessage(), LocalDateTime.now().toString());
		
	}
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(TestNotFoundException.class)
	public ErrorMessage handleTestNotFoundException(TestNotFoundException ex)
	{
	  return new ErrorMessage(HttpStatus.NOT_FOUND.toString(), ex.getMessage(), LocalDateTime.now().toString());
		
	}
	
	
}