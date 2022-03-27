package com.luv2code.java14.elearning.controller.library;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.java14.elearning.common.ResponseHandler;
import com.luv2code.java14.elearning.dto.CourseDTO;
import com.luv2code.java14.elearning.dto.LibraryDTO;
import com.luv2code.java14.elearning.service.library.LibraryService;

@RestController
@RequestMapping("/api")
public class LibraryControllerImpl implements LibraryController{
	
	@Autowired
	private LibraryService service;

	@Override
	public ResponseEntity<Object> getAllCourseByUserId(int userId) {
		
		List<CourseDTO> courses = service.getAllCourseByUserId(userId);
		
		return ResponseHandler.getResponse(courses,HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<Object> addCourseToLibrary(int courseId, int userId) {
		
		service.addCourseToLibrary(courseId, userId);
		
		return ResponseHandler.getResponse("Add course to library sucessfully", HttpStatus.OK);
	}


	@Override
	public ResponseEntity<Object> deleteCourseFromLibrary(int courseId, int userId) {
		
		service.deleteCourseFromLibrary(courseId, userId);
		
		return ResponseHandler.getResponse("Deleted Course in Library sucessfully", HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> rateTheCourse(int courseId, int userId, int rating) {
		
		LibraryDTO rateCourse = service.rateTheCourse(courseId, userId, rating);
		
		return ResponseHandler.getResponse(rateCourse,HttpStatus.OK);
	}

	
}
