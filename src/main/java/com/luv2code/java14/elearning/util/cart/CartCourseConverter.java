package com.luv2code.java14.elearning.util.cart;

import com.luv2code.java14.elearning.dto.cart.CartCourseDTO;
import com.luv2code.java14.elearning.entity.cart.CartCourse;

public class CartCourseConverter {
	
	public static CartCourseDTO toCartCourseDTO(CartCourse cartCourse) {
		
		return CartCourseDTO.builder()
				.id(cartCourse.getId())
				.price(cartCourse.getPrice())
				.build();
	}
}
