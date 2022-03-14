package com.luv2code.java14.elearning.service.course;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.java14.elearning.common.exception.InvalidCourseException;
import com.luv2code.java14.elearning.common.exception.NotFoundException;
import com.luv2code.java14.elearning.dto.course.CourseDTO;
import com.luv2code.java14.elearning.dto.course.UpdateCourseDTO;
import com.luv2code.java14.elearning.entity.course.Course;
import com.luv2code.java14.elearning.repository.course.CourseRepository;
import com.luv2code.java14.elearning.util.course.CourseConverter;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository repository;
	
	@Override
	public List<CourseDTO> getCourse(String courseKeyword) {
		List<Course> courses = repository.findAll();
		
		List<Course> result = new LinkedList<Course>();
		
		if(courseKeyword.isBlank()) {
			result = courses;
		} else {
			for (Course course : courses) {
				if(course.getCourseName().contains(courseKeyword) 
						|| course.getCourseInfo().contains(courseKeyword)) {
					result.add(course);
				}
			}	
		}
		
//		List<CourseDTO> courseDTO = CourseConverter.toCourseDTOs(result);
		return CourseConverter.toCourseDTOs(result);
	}


	@Override
	public CourseDTO createCourse(CourseDTO dto) {
		Course course = CourseConverter.toCourse(dto);
		
		Course createdCourse = repository.save(course);
		
		return CourseConverter.toCourseDTO(createdCourse);
	}


	@Override
	public CourseDTO updateCourse(long id, UpdateCourseDTO dto) {
		Optional<Course> courseOpt = repository.findById(id);
		
		Course course = courseOpt.get();
		
		if (!course.getCourseName().equals(dto.getCourseName())) {		
			course.setCourseName(dto.getCourseName());
		}
		
		course.setCourseInfo(dto.getCourseInfo());
		
		course.setPrice(dto.getPrice());
		
		Course updatedCourse = repository.save(course);
		
		return CourseConverter.toCourseDTO(updatedCourse);
	}


	@Override
	public void deleteCourse(long id) {
		Optional<Course> courseOpt = repository.findById(id);
		
		if (!courseOpt.isPresent())
			throw new InvalidCourseException("Role ID is not existed.");
		
		repository.delete(courseOpt.get());
	}
	

}
