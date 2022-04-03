package com.luv2code.java14.elearning.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.luv2code.java14.elearning.common.ResponseHandler;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = {NotFoundException.class})
	public Object handleNotFoundException(NotFoundException e) {
		return ResponseHandler.getErrorResponse(e.getMessage()
				, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = {Exception.class})
	public Object handleUnexpectedException(Exception e) {
		
		return ResponseHandler.getErrorResponse(e.getMessage()
				, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = {RuntimeException.class})
	public Object handleElearningRuntimeException(RuntimeException e) {
		return ResponseHandler.getErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
