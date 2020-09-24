package org.com.capg.healthcare.controller;

import java.time.LocalDateTime;

import org.com.capg.healthcare.dto.DiagnosticError;
import org.com.capg.healthcare.exception.AppointmentException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;




@RestControllerAdvice
public class AppointmentTestAdvice {
	
	
	/***************************************************************************************************
	 * Method       handleAppointmentExceptiona
	 * Description   To handle the exception and displaying particular Http Status message.
	 * 
	 * Created By    sahstranshu dubey
	 * Created Date   22-sept-2020
     ****************************************************************************************************/
	

	@ExceptionHandler(AppointmentException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public DiagnosticError handleAppointException(AppointmentException ex) {
		return new DiagnosticError(HttpStatus.NOT_FOUND.toString(), ex.getMessage(), LocalDateTime.now().toString());
	}
	
}
