package com.luv2code.java14.elearning.controller.video;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.luv2code.java14.elearning.dto.VideoDTO;

public interface VideoController {
	
	@GetMapping(value="/video")
	public ResponseEntity<Object> findAllVideo();
	
	@GetMapping(value="/video/{videoId}")
	public ResponseEntity<Object> getVideo(
			@PathVariable("videoId") int videoId
			);
	
	@PostMapping(value="/video/{chapterId}")
	public ResponseEntity<Object> addVideoToChapter(
			@PathVariable("chapterId") int chapterId,
			@Valid @RequestBody VideoDTO videoDTO,
			BindingResult bindingResult
			);
	
	@PutMapping(value="/video/{videoId}")
	public ResponseEntity<Object> updateVideo(
			@PathVariable("videoId") int videoId,
			@Valid @RequestBody VideoDTO videoDTO,
			BindingResult bindingResult
			);
	
	@DeleteMapping(value="/video/{videoId}")
	public ResponseEntity<Object> deleteVideo(
			@PathVariable("videoId") int videoId
			);
}
