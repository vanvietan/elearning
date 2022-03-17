package com.luv2code.java14.elearning.controller.cart;


import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;



public interface CartController {
	
	@GetMapping(value="/cart/{cartId}")
	public ResponseEntity<Object> getAllCartCourse(
			@PathVariable("cartId") int cartId
			);
	
//	@PutMapping(value="/cart/{courseId}/{cartId}")
//	public ResponseEntity<Object> chooseCartCourse(
//			@PathVariable("courseId") int courseId,
//			@PathVariable("cartId") int cartId,
//			BindingResult bindingResult
//			);
	
	@DeleteMapping(value="/cart/{courseId}/{cartId}")
	public ResponseEntity<Object> deleteCartCourse(
			@PathVariable("courseId") int courseId,
			@PathVariable("cartId") int cartId
			);
	
//	@PutMapping(value="/cart/{cartId}")
//	public ResponseEntity<Object> totalPrice(
//			@PathVariable("cartId") int cartId
//			);
	
}
