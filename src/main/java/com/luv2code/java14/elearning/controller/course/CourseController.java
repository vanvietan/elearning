package com.luv2code.java14.elearning.controller.course;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface CourseController {

	@GetMapping(value="/course/{courseId}")
	public ResponseEntity<Object> getCourseById(
			 @PathVariable("userId") int id 
			);
}
