package com.luv2code.java14.elearning.service.cart;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.java14.elearning.common.exception.NotFoundException;
import com.luv2code.java14.elearning.dto.cart.CartCourseDTO;
import com.luv2code.java14.elearning.dto.course.CourseDTO;
import com.luv2code.java14.elearning.entity.cart.CartCourse;
import com.luv2code.java14.elearning.entity.course.Course;
import com.luv2code.java14.elearning.repository.cart.CartRepository;
import com.luv2code.java14.elearning.repository.course.CourseRepository;
import com.luv2code.java14.elearning.util.cart.CartCourseConverter;
import com.luv2code.java14.elearning.util.course.CourseConverter;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private CourseRepository courseRepository;

	@Override
	public List<CourseDTO> getAllCourseByCartId(int cartId) {
		
		//Tìm * trong bảng cart_course thỏa mãn cartId
		List<CartCourse> cartCourses = cartRepository.getAllCourseByCartId(cartId);
		
		//Add danh sách courseIds từ bảng cart_course
		List<Integer> courseIds = new ArrayList<>();
		for(CartCourse c : cartCourses) {
			courseIds.add(c.getCourse().getId());
		}
		
		//Mang danh sách courseIds qua bảng course lấy hết thông tin
		List<Course> courses = courseRepository.findAllById(courseIds);
		
		
		return CourseConverter.toCourseDTOs(courses);
	}
//	@Override
//	public CartCourseDTO selectCourse(int courseId, int cartId) {
//		Optional<CartCourse> cartCourseOpt = cartRepository.findByCourseIdCartId(courseId, cartId);
//		if(!cartCourseOpt.isPresent()) {
//			throw new NotFoundException("CourseId or CartId is not correct");
//		}
//		CartCourse chooseCourse = cartCourseOpt.get();
//		
//		if(chooseCourse.isTickChoose() == false) {
//			chooseCourse.setTickChoose(true);
//		} else {
//			chooseCourse.setTickChoose(false);
//		}
//		CartCourse chosenCourse = cartRepository.save(chooseCourse);
//		
//		return CartCourseConverter.toCartCourseDTO(chosenCourse);
//	}
	

	@Override
	public void deleteCartCourse(int courseId, int cartId) {
		Optional<CartCourse> cartCourseOpt = cartRepository.findByCourseIdCartId(courseId, cartId);
		if(!cartCourseOpt.isPresent()) {
			throw new NotFoundException("CourseId or CartId is not correct");
		}
		cartRepository.delete(cartCourseOpt.get());
	}
//	@Override
//	public Double totalPrice(int cartId) {
//		List<CartCourse> cartCourse = cartRepository.findTickedCourse(cartId, true);
//		
//		List<Integer> courseIds = new ArrayList<>();
//		for(CartCourse cart : cartCourse) {
//			courseIds.add(cart.getCourse().getId());
//		}
//		double totalPrice = 0;
//		List<Course> courses = courseRepository.findAllById(courseIds);
//		for(Course course : courses) {
//			totalPrice += course.getPrice();
//		}
//		
//		return totalPrice;
//	}

	
	

}
