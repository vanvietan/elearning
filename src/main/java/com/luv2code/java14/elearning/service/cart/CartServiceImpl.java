package com.luv2code.java14.elearning.service.cart;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.java14.elearning.common.exception.DuplicateCourseException;
import com.luv2code.java14.elearning.common.exception.NotFoundException;
import com.luv2code.java14.elearning.dto.course.CourseDTO;
import com.luv2code.java14.elearning.entity.cart.CartCourse;
import com.luv2code.java14.elearning.entity.course.Course;
import com.luv2code.java14.elearning.entity.user.User;
import com.luv2code.java14.elearning.repository.cart.CartRepository;
import com.luv2code.java14.elearning.repository.course.CourseRepository;
import com.luv2code.java14.elearning.repository.user.UserRepository;
import com.luv2code.java14.elearning.util.course.CourseConverter;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired 
	private CartRepository cartRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired 
	private UserRepository userRepository;

//	private DataSource dataSource;
//	private JdbcTemplate jdbcTemplateObject;
//	
//	public void setDataSource(DataSource dataSource) {
//		this.dataSource = dataSource;
//		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
//	}
	
	@Override
	public void addCourseToCart(int courseId, int userId) {
		User user = userRepository.findById(userId)
				.orElseThrow(
				() -> new EntityNotFoundException("User is not existed"));
		
		Course course = courseRepository.findById(courseId)
				.orElseThrow(
				() -> new EntityNotFoundException("Course is not existed"));
		
		List<CartCourse> cartCourseOpt = cartRepository.findAll();
		
		for(CartCourse cartCourse : cartCourseOpt) {
			if(cartCourse.getUser().getId() == userId &&
					cartCourse.getCourse().getId() == courseId) {
				throw new DuplicateCourseException("Cart already have this Course");
				} else {
					cartRepository.addCourseToCart(courseId, userId);
				}
			}
	}
	
	@Override
	public List<CourseDTO> getAllCourseByUserId(int userId) {
		
		//Tìm * trong bảng cart_course thỏa mãn cartId
		List<CartCourse> cartCourses = cartRepository.getAllCourseByUserId(userId);
		
		//Add danh sách courseIds từ bảng cart_course
		List<Integer> courseIds = new ArrayList<>();
		for(CartCourse c : cartCourses) {
			courseIds.add(c.getCourse().getId());
		}
		
		//Mang danh sách courseIds qua bảng course lấy hết thông tin
		List<Course> courses = courseRepository.findAllById(courseIds);
		
		
		return CourseConverter.toCourseDTOs(courses);
	}
	
	@Override
	public void deleteCourseFromCart(int courseId, int userId) {
		Optional<CartCourse> cartCourseOpt = cartRepository.findByCourseIdCartId(courseId, userId);
		if(!cartCourseOpt.isPresent()) {
			throw new NotFoundException("CourseId or UserId is incorrect");
		}
		cartRepository.delete(cartCourseOpt.get());
	}
}
