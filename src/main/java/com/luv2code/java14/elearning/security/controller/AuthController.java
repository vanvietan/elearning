package com.luv2code.java14.elearning.security.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.luv2code.java14.elearning.security.dto.LoginDTO;

public interface AuthController {

	@PostMapping(value = "/login", produces = "application/json")
	public ResponseEntity<Object> login(
			@Valid @RequestBody LoginDTO dto, BindingResult bindingResult);
}
