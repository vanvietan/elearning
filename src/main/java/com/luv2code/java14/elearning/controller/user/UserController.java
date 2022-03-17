package com.luv2code.java14.elearning.controller.user;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.luv2code.java14.elearning.dto.user.UpdateUserDTO;
import com.luv2code.java14.elearning.dto.user.UserDTO;

public interface UserController {
	
	@GetMapping(value="/user")
	public ResponseEntity<Object> findAllUser();
	
	@GetMapping(value="/user/{userId}")
	public ResponseEntity<Object> getUser(
			 @PathVariable("userId") int id 
			);
	
	@PostMapping(value="/user")
	public ResponseEntity<Object> createUser(
			@Valid @RequestBody UserDTO userDTO,
			BindingResult bindingResult
			);
	
	@PutMapping(value="/user/{userId}")
	public ResponseEntity<Object> updateUser(
			@PathVariable("userId") int id,
			@Valid @RequestBody UpdateUserDTO updateUserDTO,
			BindingResult bindingResult
			);
	
	@DeleteMapping(value="/user/{userId}")
	public ResponseEntity<Object> deleteUser(
			@PathVariable("userId") int id
			);
}
