package com.luv2code.java14.elearning.service.course;

import java.util.List;

import org.springframework.stereotype.Service;

import com.luv2code.java14.elearning.dto.CourseDTO;
import com.luv2code.java14.elearning.dto.UpdateCourseDTO;
import com.luv2code.java14.elearning.entity.course.Course;

public interface CourseService {

	void updateCourse(int id, UpdateCourseDTO dto);

	void createCourse(CourseDTO dto);

	void deleteCourse(int id);

	List<CourseDTO> getCourseByKeyword(String courseKeyword);
	
	CourseDTO getCourseById(int id);

}
