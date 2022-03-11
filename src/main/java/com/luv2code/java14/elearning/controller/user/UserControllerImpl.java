package com.luv2code.java14.elearning.controller.user;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.java14.elearning.common.ResponseHandler;
import com.luv2code.java14.elearning.dto.user.UpdateUserDTO;
import com.luv2code.java14.elearning.dto.user.UserDTO;
import com.luv2code.java14.elearning.service.user.UserService;
import com.luv2code.java14.elearning.util.user.EmailValidation;

@RestController
@RequestMapping("/api")
public class UserControllerImpl implements UserController {
	
	private UserService service;
	
	@Autowired
	public UserControllerImpl(UserService theUserService) {
		service = theUserService;
	}
	
	@Override
	public ResponseEntity<Object> findAllUser() {
		List<UserDTO> users = service.findAll();	
		return ResponseHandler.getResponse(users, HttpStatus.OK); 	
	}

	//getUser là tìm 1 User và xuất ra DTO
	
	@Override
	public ResponseEntity<Object> getUser(int id) {
		
		UserDTO getUser = service.getUser(id);
	
		return ResponseHandler.getResponse(getUser, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> createUser(@Valid UserDTO userDTO, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return ResponseHandler.getErrorResponse(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
		}
		
		UserDTO createdUser = service.createUser(userDTO);
		
		return ResponseHandler.getResponse(createdUser,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> updateUser(int id, @Valid UpdateUserDTO updateUserDTO, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return ResponseHandler.getErrorResponse(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
		}
		UserDTO updatedUser = service.updateUser(id, updateUserDTO);
		
		return ResponseHandler.getResponse(updatedUser, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> deleteUser(int id) {
		
		service.deleteUser(id);
		
		return ResponseHandler.getResponse("Deleted User Sucessfully", HttpStatus.OK);
	}

}
