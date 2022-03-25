package com.luv2code.java14.elearning.controller.chapter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.java14.elearning.common.ResponseHandler;
import com.luv2code.java14.elearning.dto.ChapterDTO;
import com.luv2code.java14.elearning.service.chapter.ChapterService;

@RestController
@RequestMapping("/api")
public class ChapterControllerImpl implements ChapterController {
	
	@Autowired
	private ChapterService service;

	@Override
	public ResponseEntity<Object> finishTheChapter(int userId, int courseId, int chapterId) {
		
		service.finishTheChapter(userId, courseId, chapterId);
		
		return ResponseHandler.getResponse("Finished Chapter " + chapterId,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> getAllChaptersInCourse(int courseId) {
		
		List<ChapterDTO> chapters = service.getAllChaptersInCourse(courseId);
		
		return ResponseHandler.getResponse(chapters,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> getTheChapter(int chapterId) {
		
		ChapterDTO chapter = service.getTheChapter(chapterId);
		
		return ResponseHandler.getResponse(chapter, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> createCourse() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Object> deleteChapter(int chapterId) {
		
		service.deleteChapter(chapterId);
		
		return ResponseHandler.getResponse("Deleted Course Successfully", HttpStatus.OK);
	}
	
}
