package com.godknows.picpay.controllers.excepetionshandler;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.godknows.picpay.dtos.ExceptionDTO;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class ControllerExceptionHandler {
	
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity threadDuplicateEntry (DataIntegrityViolationException e) {
		ExceptionDTO exceptionDTO = new ExceptionDTO("User already registered.", "400");
		return ResponseEntity.badRequest().body(exceptionDTO);
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity thread404 (EntityNotFoundException e) {
		return ResponseEntity.badRequest().build();
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity threatGeneralExceptions (Exception e) {
		ExceptionDTO exceptionDTO = new ExceptionDTO(e.getMessage(), "500");
		return ResponseEntity.internalServerError().body(exceptionDTO);
	}

}
