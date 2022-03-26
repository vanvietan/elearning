package com.luv2code.java14.elearning.controller.chapter;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.luv2code.java14.elearning.dto.ChapterDTO;

public interface ChapterController {
	
	@PutMapping(value="/chapter/{userId}/{courseId}/{chapterId}")
	public ResponseEntity<Object> finishTheChapter(
			@PathVariable("userId") int userId,
			@PathVariable("courseId") int courseId,
			@PathVariable("chapterId") int chapterId
			);
	
	@GetMapping(value="/chapters/{courseId}")
	public ResponseEntity<Object> getAllChaptersInCourse(
			@PathVariable("courseId") int courseId
			);
	
	@GetMapping(value="/chapter/{chapterId}")
	public ResponseEntity<Object> getTheChapter(
			@PathVariable("chapterId") int chapterId
			);
	
	@PostMapping(value="/chapter/{courseId}")
	public ResponseEntity<Object> createChapterInCourse(
			@PathVariable("courseId") int courseId,
			@Valid @RequestBody ChapterDTO chapterDTO,
			BindingResult bindingResult
			);
	
	@PutMapping(value="/chapter/{chapterId}")
	public ResponseEntity<Object> updateChapter(
			@PathVariable("chapterId") int chapterId,
			@Valid @RequestBody ChapterDTO chapterDTO,
			BindingResult bindingResult
			
			);
	
	@DeleteMapping(value="/chapter/{chapterId}")
	public ResponseEntity<Object> deleteChapter(
			@PathVariable("chapterId") int chapterId
			);
		
}
