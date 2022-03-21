package com.luv2code.java14.elearning.controller.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.java14.elearning.common.ResponseHandler;
import com.luv2code.java14.elearning.dto.course.CourseDTO;
import com.luv2code.java14.elearning.service.cart.CartService;

@RestController
@RequestMapping("/api")
public class CartControllerImpl implements CartController {

	@Autowired
	private CartService service;

	@Override
	public ResponseEntity<Object> addCourseToCart(int courseId, int userId) {
		
		service.addCourseToCart(courseId, userId);
		
		return ResponseHandler.getResponse("Add course to cart successfully", HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> getAllCourseByUserId(int userId) {
		
		List<CourseDTO> courses = service.getAllCourseByUserId(userId);
		
		return ResponseHandler.getResponse(courses,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> deleteCourseFromCart(int courseId, int userId) {
		
		service.deleteCourseFromCart(courseId, userId);
		
		return ResponseHandler.getResponse("Deleted Course in Cart Successfull", HttpStatus.OK);
	}
	
}
