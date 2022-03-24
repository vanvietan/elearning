package com.luv2code.java14.elearning.service.cart;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.java14.elearning.dto.course.CourseDTO;
import com.luv2code.java14.elearning.entity.cart.Cart;
import com.luv2code.java14.elearning.entity.cart.CartKey;
import com.luv2code.java14.elearning.entity.course.Course;
import com.luv2code.java14.elearning.entity.user.User;
import com.luv2code.java14.elearning.repository.cart.CartRepository;
import com.luv2code.java14.elearning.repository.course.CourseRepository;
import com.luv2code.java14.elearning.repository.user.UserRepository;

@Service
@Transactional(rollbackFor = Exception.class)
public class CartServiceImpl implements CartService {
	
	@Autowired 
	private CartRepository cartRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired 
	private UserRepository userRepository;
	
	@Override
	public void addCourseToCart(int courseId, int userId) {
		User user = userRepository.findById(userId)
				.orElseThrow(
				() -> new EntityNotFoundException("User is not existed"));
		
		Course course = courseRepository.findById(courseId)
				.orElseThrow(
				() -> new EntityNotFoundException("Course is not existed"));
		
		CartKey key = new CartKey(userId, courseId);
		Optional<Cart> optUserCourse = cartRepository.findById(key);
		if (optUserCourse.isPresent())
			return;
		
		Cart cartCourse = new Cart();
		cartCourse.setKey(key);
		cartCourse.setUser(user);
		cartCourse.setCourse(course);
		cartCourse.setPrice(course.getPrice());
		
		cartRepository.save(cartCourse);
	}
	
	@Override
	public List<CourseDTO> getAllCourseByUserId(int userId) {
		User user = userRepository.findById(userId)
				.orElseThrow(
				() -> new EntityNotFoundException("User is not existed"));
		
//		Set<CartCourse> cartCourses = cart.getCartCourses();
//		List<CourseDTO> dtos = new ArrayList<>();
//		for (CartCourse uc : cartCourses) {
//			Course course = uc.getCourse();
//			CourseDTO dto = new CourseDTO();
//			BeanUtils.copyProperties(course, dto);
//			dtos.add(dto);
//		}
//		return dtos;		
		
		return user.getCarts()
				.stream()
				.map(uc -> {
					CourseDTO dto = new CourseDTO();
					BeanUtils.copyProperties(uc.getCourse(), dto);
					return dto;
				})
				.collect(Collectors.toList());
	}
	
	@Override
	public void deleteCourseFromCart(int courseId, int userId) {
		CartKey key = new CartKey(userId, courseId);
		Optional<Cart> optUserCourse = cartRepository.findById(key);
		if (optUserCourse.isPresent())
			cartRepository.deleteById(key);
		
	}
}
