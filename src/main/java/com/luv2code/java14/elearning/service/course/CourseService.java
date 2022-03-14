package com.luv2code.java14.elearning.service.course;

import java.util.List;

import org.springframework.stereotype.Service;

import com.luv2code.java14.elearning.dto.course.CourseDTO;
import com.luv2code.java14.elearning.dto.course.UpdateCourseDTO;
import com.luv2code.java14.elearning.entity.course.Course;

public interface CourseService {

	List<CourseDTO> getCourse(String courseKeyword);

	CourseDTO updateCourse(long id, UpdateCourseDTO dto);

	CourseDTO createCourse(CourseDTO dto);

	void deleteCourse(long id);

}
