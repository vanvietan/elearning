package com.luv2code.java14.elearning.service.cart;

import java.util.List;

import com.luv2code.java14.elearning.dto.course.CourseDTO;

public interface CartService {

	void addCourseToCart(int courseId, int userId);

	List<CourseDTO> getAllCourseByUserId(int userId);

	void deleteCourseFromCart(int courseId, int cartId);
}
