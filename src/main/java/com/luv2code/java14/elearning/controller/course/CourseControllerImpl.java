package com.luv2code.java14.elearning.controller.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.java14.elearning.common.ResponseHandler;
import com.luv2code.java14.elearning.dto.course.CourseDTO;
import com.luv2code.java14.elearning.service.course.CourseService;

@RestController
@RequestMapping("/api")
public class CourseControllerImpl implements CourseController {
	
	@Autowired
	private CourseService service;

	@Override
	public ResponseEntity<Object> getCourseById(int id) {
		CourseDTO getCourse = service.getCourseById(id);
		return ResponseHandler.getResponse(getCourse,HttpStatus.OK);
	}

}
