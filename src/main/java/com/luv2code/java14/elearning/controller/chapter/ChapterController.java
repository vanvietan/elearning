package com.luv2code.java14.elearning.controller.chapter;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

public interface ChapterController {
	
	@PutMapping(value="/chapter/{userId}/{courseId}/{chapterId}")
	public ResponseEntity<Object> finishTheChapter(
			@PathVariable("userId") int userId,
			@PathVariable("courseId") int courseId,
			@PathVariable("chapterId") int chapterId
			);
	
	@GetMapping(value="/chapter/{courseId}")
	public ResponseEntity<Object> getAllChaptersInCourse(
			@PathVariable("courseId") int courseId
			);
	
	@GetMapping(value="/chapter/{chapterId}")
	public ResponseEntity<Object> getTheChapter(
			@PathVariable("chapterId") int chapterId
			);
	
	@PostMapping(value="/chapter/{courseId}")
	public ResponseEntity<Object> createCourse();
	
	
	@DeleteMapping(value="/chapter/{chapterId}")
	public ResponseEntity<Object> deleteChapter(
			@PathVariable("chapterId") int chapterId
			);
		
}
