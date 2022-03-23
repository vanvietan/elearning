package com.luv2code.java14.elearning.controller.library;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

public interface LibraryController {
	
	@GetMapping(value="/library/{userId}")
	public ResponseEntity<Object>getAllCourseByUserId(
			@PathVariable("userId") int userId
			);
	
	@PostMapping(value="/library/{userId}/{courseId}")
	public ResponseEntity<Object> addCourseToLibrary(
			@PathVariable("courseId") int courseId,
			@PathVariable("userId") int userId
			);
	
	@DeleteMapping(value="/library/{userId}/{courseId}")
	public ResponseEntity<Object> deleteCourseFromLibrary(
			@PathVariable("courseId") int courseId,
			@PathVariable("userId") int userId
			);
	
	@PutMapping(value="/library/{userId}/{courseId}/{rating}")
	public ResponseEntity<Object> rateTheCourse(
			@PathVariable("courseId") int courseId,
			@PathVariable("userId") int userId,
			@PathVariable("rating") int rating
			);
	
	@GetMapping(value="/library/{userId}/{courseId}")
	public ResponseEntity<Object> userLearningProgress(
			@PathVariable("userId") int userId,
			@PathVariable("courseId") int courseId
			);
}
