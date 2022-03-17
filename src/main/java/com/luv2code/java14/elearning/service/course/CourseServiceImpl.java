package com.luv2code.java14.elearning.service.course;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.java14.elearning.common.exception.InvalidCourseException;
import com.luv2code.java14.elearning.dto.course.CourseDTO;
import com.luv2code.java14.elearning.entity.course.Course;
import com.luv2code.java14.elearning.repository.course.CourseRepository;
import com.luv2code.java14.elearning.util.course.CourseConverter;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseRepository repository;
	
	@Override
	public CourseDTO getCourseById(int id) {
		Optional<Course> courseOpt = repository.findById(id);
		if(!courseOpt.isPresent()) {
			throw new InvalidCourseException("Course id is not valid");
		}
		Course course = courseOpt.get();
		
				return CourseConverter.toCourseDTO(course);
	}

}
