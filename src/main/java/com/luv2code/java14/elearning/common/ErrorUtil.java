package com.luv2code.java14.elearning.common;

import java.util.LinkedList;
import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

public class ErrorUtil {
	
	public static Object showError(BindingResult bindingResult) {
		List<String> errorMessages = new LinkedList<String>();
		List<ObjectError> errors = bindingResult.getAllErrors();
		
		for(ObjectError error : errors) {
			errorMessages.add(error.getDefaultMessage());
		}
		
		return errorMessages;
	}
}
