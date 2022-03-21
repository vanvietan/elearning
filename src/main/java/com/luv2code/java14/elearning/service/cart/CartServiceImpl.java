package com.luv2code.java14.elearning.service.cart;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.java14.elearning.common.exception.DuplicateCourseException;
import com.luv2code.java14.elearning.common.exception.NotFoundException;
import com.luv2code.java14.elearning.dto.course.CourseDTO;
import com.luv2code.java14.elearning.entity.cart.UserCourse;
import com.luv2code.java14.elearning.entity.cart.UserCourseKey;
import com.luv2code.java14.elearning.entity.course.Course;
import com.luv2code.java14.elearning.entity.user.User;
import com.luv2code.java14.elearning.repository.cart.UserCourseRepository;
import com.luv2code.java14.elearning.repository.course.CourseRepository;
import com.luv2code.java14.elearning.repository.user.UserRepository;

@Service
@Transactional(rollbackFor = Exception.class)
public class CartServiceImpl implements CartService {
	
	@Autowired 
	private UserCourseRepository userCourseRepository;
	
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
		
		UserCourseKey key = new UserCourseKey(userId, courseId);
		Optional<UserCourse> optUserCourse = userCourseRepository.findById(key);
		if (optUserCourse.isPresent())
			return;
		
		UserCourse userCourse = new UserCourse();
		userCourse.setKey(key);
		userCourse.setUser(user);
		userCourse.setCourse(course);
		userCourse.setPrice(course.getPrice());
		
		userCourseRepository.save(userCourse);
	}
	
	@Override
	public List<CourseDTO> getAllCourseByUserId(int userId) {
		User user = userRepository.findById(userId)
				.orElseThrow(
				() -> new EntityNotFoundException("User is not existed"));
		
//		Set<UserCourse> userCourses = user.getUserCourses();
//		List<CourseDTO> dtos = new ArrayList<>();
//		for (UserCourse uc : userCourses) {
//			Course course = uc.getCourse();
//			CourseDTO dto = new CourseDTO();
//			BeanUtils.copyProperties(course, dto);
//			dtos.add(dto);
//		}
		
		return user.getUserCourses()
				.stream()
				.map(uc -> {
					CourseDTO dto = new CourseDTO();
					BeanUtils.copyProperties(uc.getCourse(), dto);
					return dto;
				})
				.collect(Collectors.toList());
		
//		return dtos;
	}
	
	@Override
	public void deleteCourseFromCart(int courseId, int userId) {
		UserCourseKey key = new UserCourseKey(userId, courseId);
		Optional<UserCourse> optUserCourse = userCourseRepository.findById(key);
		if (optUserCourse.isPresent())
			userCourseRepository.deleteById(key);
		
	}
}
