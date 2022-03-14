package com.luv2code.java14.elearning.controller.course;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.java14.elearning.dto.course.CourseDTO;
import com.luv2code.java14.elearning.dto.course.UpdateCourseDTO;

public interface CourseController {

	@GetMapping(value = "/get")
	public ResponseEntity<Object> getCourse(
			@RequestParam("keyword") String courseKeyword
			);
	
	@PostMapping(value = "/post")
	public ResponseEntity<Object> createCourse(
			@Valid @RequestBody CourseDTO dto,
				BindingResult bindingResult
			);
	
	@PutMapping(value = "/update/{id}")
	public ResponseEntity<Object> updateCourse(
			@PathVariable("courseId") long id,
			@Valid @RequestBody UpdateCourseDTO dto,
				BindingResult bindingResult
			);

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Object> deleteCourse(
			@PathVariable("courseId") long id
			);	
}
