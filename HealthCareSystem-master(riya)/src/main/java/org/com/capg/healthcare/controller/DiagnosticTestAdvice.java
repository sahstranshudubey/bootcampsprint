package org.com.capg.healthcare.controller;

import java.time.LocalDateTime;

import org.com.capg.healthcare.dto.DiagnosticError;
import org.com.capg.healthcare.exception.AppointmentException;
import org.com.capg.healthcare.exception.TestException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class DiagnosticTestAdvice {

	@ExceptionHandler(AppointmentException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public DiagnosticError handleAppointException(AppointmentException ex) {
		return new DiagnosticError(HttpStatus.NOT_FOUND.toString(), ex.getMessage(), LocalDateTime.now().toString());
	}
	
	@ExceptionHandler(TestException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public DiagnosticError handleTestException(TestException ex) {
		return new DiagnosticError(HttpStatus.NOT_FOUND.toString(), ex.getMessage(), LocalDateTime.now().toString());
	}
}
