package com.luv2code.java14.elearning.service.course;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.java14.elearning.common.exception.InvalidCourseException;
import com.luv2code.java14.elearning.dto.CourseDTO;
import com.luv2code.java14.elearning.dto.UpdateCourseDTO;
import com.luv2code.java14.elearning.entity.course.Course;
import com.luv2code.java14.elearning.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository repository;
	
	@Override
	public List<CourseDTO> getCourseByKeyword(String courseKeyword) {
		
		List<Course> courses = repository.findAll();
		
		List<CourseDTO> result = new LinkedList<CourseDTO>();
		
		if(courseKeyword.isBlank()) {
			result.equals(courses);
		} else {
			for (Course course : courses) {
				if(course.getName().contains(courseKeyword) 
						|| course.getInfo().contains(courseKeyword)) {
					BeanUtils.copyProperties(courses, result);;
				}
			}	
		}
		
		return result;
	}

	@Override
	public void createCourse(CourseDTO dto) {
		Course course = new Course();
		
		BeanUtils.copyProperties(dto, course);
		
		repository.save(course);
	}


	@Override
	public void updateCourse(int id, UpdateCourseDTO dto) {
		Optional<Course> courseOpt = repository.findById(id);
		
		Course course = new Course();
		
		if (!course.getName().equals(dto.getName())) {		
			if (repository.findByName(dto.getName()).isPresent()){
				throw new InvalidCourseException("Course name has been used.");
			}
			
			course.setName(dto.getName());
		}
		
		course.setInfo(dto.getInfo());
		course.setPrice(dto.getPrice());
		course.setRating(dto.getRating());
		
		repository.save(course);
	}


	@Override
	public void deleteCourse(int id) {
		Optional<Course> courseOpt = repository.findById(id);
		
		if (!courseOpt.isPresent())
			throw new InvalidCourseException("Role ID is not existed.");
		
		repository.delete(courseOpt.get());
	}

	@Override
	public CourseDTO getCourseById(int id) {
		Optional<Course> courseOpt = repository.findById(id);
		if(!courseOpt.isPresent()) {
			throw new InvalidCourseException("Course id is not valid");
		}
		CourseDTO dto = new CourseDTO();
		BeanUtils.copyProperties(courseOpt, dto);
		return dto;
	}
}
