package org.com.capg.healthcare.controller;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import org.com.capg.healthcare.dto.*;
import org.com.capg.healthcare.exception.*;


@RestControllerAdvice
public class ScheduledAdvice {

	@ExceptionHandler(ScheduledException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public DiagnosticError handleAppointException(ScheduledException ex) {
	return new DiagnosticError(HttpStatus.NOT_FOUND.toString(), ex.getMessage(), LocalDateTime.now().toString());
	}
}
