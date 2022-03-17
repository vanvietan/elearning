package com.luv2code.java14.elearning.service.cart;

import java.util.List;


import com.luv2code.java14.elearning.dto.cart.CartCourseDTO;
import com.luv2code.java14.elearning.dto.course.CourseDTO;

public interface CartService {

	List<CourseDTO> getAllCourseByCartId(int cartId);

	void deleteCartCourse(int courseId, int cartId);

//	CartCourseDTO selectCourse(int courseId, int cartId);
	
//	Double totalPrice(int cartId);

	

}
