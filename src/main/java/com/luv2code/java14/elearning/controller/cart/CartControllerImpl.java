package com.luv2code.java14.elearning.controller.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.java14.elearning.common.ResponseHandler;
import com.luv2code.java14.elearning.dto.cart.CartCourseDTO;
import com.luv2code.java14.elearning.dto.course.CourseDTO;
import com.luv2code.java14.elearning.service.cart.CartService;

@RestController
@RequestMapping("/api")
public class CartControllerImpl implements CartController {
	
	@Autowired
	private CartService service;

	@Override
	public ResponseEntity<Object> getAllCartCourse(int cartId) {
		List<CourseDTO> courses = service.getAllCourseByCartId(cartId);
		
		return ResponseHandler.getResponse(courses,HttpStatus.OK);
	}

//	@Override
//	public ResponseEntity<Object> chooseCartCourse(int courseId,int cartId, BindingResult bindingResult) {
//		if(bindingResult.hasErrors()) {
//			return ResponseHandler.getErrorResponse(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
//		}
//		CartCourseDTO selectCourse = service.selectCourse(courseId, cartId);
//		
//		return ResponseHandler.getResponse(selectCourse,HttpStatus.OK);
//	}

	@Override
	public ResponseEntity<Object> deleteCartCourse(int courseId, int cartId) {
		
		service.deleteCartCourse(courseId, cartId);
		
		return ResponseHandler.getResponse("Deleted Course in Cart Successfull", HttpStatus.OK);
	}

//	@Override
//	public ResponseEntity<Object> totalPrice(int cartId) {
//		double totalPrice = service.totalPrice(cartId);
//		
//		return ResponseHandler.getResponse(totalPrice,HttpStatus.OK);
//	}
	
	
}
