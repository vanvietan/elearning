package com.luv2code.java14.elearning.service.course;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.java14.elearning.common.exception.InvalidCourseException;
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
	public List<CourseDTO> getCourseByKeyword(String courseKeyword) {
		
		List<Course> courses = repository.findAll();
		
		List<Course> result = new LinkedList<Course>();
		
		if(courseKeyword.isBlank()) {
			result.equals(courses);
		} else {
			for (Course course : courses) {
				if(course.getName().contains(courseKeyword) 
						|| course.getCourseInfo().contains(courseKeyword)) {
					result.add(course);
				}
			}	
		}
		
		return CourseConverter.toCourseDTOs(result);
	}

	@Override
	public CourseDTO createCourse(CourseDTO dto) {
		Course course = CourseConverter.toCourse(dto);
		
		Course createdCourse = repository.save(course);
		
		return CourseConverter.toCourseDTO(createdCourse);
	}


	@Override
	public CourseDTO updateCourse(int id, UpdateCourseDTO dto) {
		Optional<Course> courseOpt = repository.findById(id);
		
		Course course = courseOpt.get();
		
		if (!course.getName().equals(dto.getCourseName())) {		
			if (repository.findByName(dto.getCourseName()).isPresent()){
				throw new InvalidCourseException("Course name has been used.");
			}
			
			course.setName(dto.getCourseName());
		}
		
		course.setCourseInfo(dto.getCourseInfo());
		
		course.setPrice(dto.getPrice());
		
		course.setRating(dto.getRating());
		
		Course updatedCourse = repository.save(course);
		
		return CourseConverter.toCourseDTO(updatedCourse);
	}


	@Override
	public void deleteCourse(int id) {
		Optional<Course> courseOpt = repository.findById(id);
		
		if (!courseOpt.isPresent())
			throw new InvalidCourseException("Role ID is not existed.");
		
		repository.delete(courseOpt.get());
	}


	@Override
	public CourseDTO getCourse(int courseId) {

		Course course = repository.getById(courseId);
		
		return CourseConverter.toCourseDTO(course);
	}

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
