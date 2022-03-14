package com.luv2code.java14.elearning.util.course;

import java.util.ArrayList;
import java.util.List;

import com.luv2code.java14.elearning.dto.course.CourseDTO;
import com.luv2code.java14.elearning.entity.course.Course;

public class CourseConverter {
	public static CourseDTO toCourseDTO(Course course) {
		
		return CourseDTO.builder()
				.id(course.getId())
				.courseName(course.getCourseName())
				.courseInfo(course.getCourseInfo())
				.rating(course.getRating())
				.price(course.getPrice())
				.build();
	}
	
	public static List<CourseDTO> toCourseDTOs(List<Course> courses){
		List<CourseDTO> courseDTOs = new ArrayList<>();
		
		for(Course course : courses) {
			courseDTOs.add(CourseConverter.toCourseDTO(course));
		}
		
		return courseDTOs;
	}
	
	public static Course toCourse(CourseDTO courseDTO) {
		return Course.builder()
				.id(courseDTO.getId())
				.courseName(courseDTO.getCourseName())
				.courseInfo(courseDTO.getCourseInfo())
				.rating(courseDTO.getRating())
				.price(courseDTO.getPrice())
				.build();
	}
}
