package com.luv2code.java14.elearning.controller.video;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.java14.elearning.common.ResponseHandler;
import com.luv2code.java14.elearning.dto.VideoDTO;
import com.luv2code.java14.elearning.service.video.VideoService;

@RestController
@RequestMapping("/api")
public class VideoControllerImpl implements VideoController {

	@Autowired
	private VideoService service;
	
	@Override
	public ResponseEntity<Object> findAllVideo() {
		
		List<VideoDTO> videos = service.findAll();
		
		return ResponseHandler.getResponse(videos,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> getVideo(int videoId) {
		
		VideoDTO video = service.getVideo(videoId);
		
		return ResponseHandler.getResponse(video,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> addVideoToChapter(int chapterId, @Valid VideoDTO videoDTO, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return ResponseHandler.getErrorResponse(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
		}
		
		VideoDTO createdVideo = service.addVideoToChapter(chapterId, videoDTO);
		
		return ResponseHandler.getResponse(createdVideo,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> updateVideo(int videoId, @Valid VideoDTO videoDTO, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return ResponseHandler.getErrorResponse(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
		}
		VideoDTO updateVideo = service.updateVideo(videoId, videoDTO);
		
		return ResponseHandler.getResponse(updateVideo, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> deleteVideo(int videoId) {
		
		service.deleteVideo(videoId);
		
		return ResponseHandler.getResponse("Deleted Video Successfully",HttpStatus.OK);
	}
	
	
}
