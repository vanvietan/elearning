package com.luv2code.java14.elearning.controller.cart;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public interface CartController {
	
	@GetMapping(value="/cart/{userId}")
	public ResponseEntity<Object> getAllCourseByUserId(
			@PathVariable("userId") int userId
			);	
	
	@PostMapping(value = "/cart/{userId}/{courseId}")
	public ResponseEntity<Object> addCourseToCart(
			@PathVariable("courseId") int courseId,
			@PathVariable("userId") int userId
			);
	
	@DeleteMapping(value="/cart/{userId}/{courseId}")
	public ResponseEntity<Object> deleteCourseFromCart(
			@PathVariable("courseId") int courseId,
			@PathVariable("userId") int userId
			);
}
