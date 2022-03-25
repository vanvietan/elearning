package com.luv2code.java14.elearning.controller.course;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.java14.elearning.common.ResponseHandler;
import com.luv2code.java14.elearning.dto.CourseDTO;
import com.luv2code.java14.elearning.dto.UpdateCourseDTO;
import com.luv2code.java14.elearning.entity.course.Course;
import com.luv2code.java14.elearning.service.course.CourseService;

@RestController
@RequestMapping("/api")
public class CourseControllerImpl implements CourseController {

	@Autowired
	private CourseService service;

	@Override
	public ResponseEntity<Object> getCourseByKeyword(String courseKeyword) {
		List<CourseDTO> result = service.getCourseByKeyword(courseKeyword);
		return ResponseHandler.getResponse(result, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> createCourse(@Valid CourseDTO dto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseHandler.getErrorResponse(bindingResult, HttpStatus.BAD_REQUEST);
		}
		service.createCourse(dto);
		
		return ResponseHandler.getResponse("create course successly", HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> updateCourse(int id, @Valid UpdateCourseDTO dto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseHandler.getErrorResponse(bindingResult, HttpStatus.BAD_REQUEST);
		}
		
		service.updateCourse(id, dto);
		
		return ResponseHandler.getResponse("update course successfully", HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> deleteCourse(int id) {
		
		service.deleteCourse(id);
		
		return ResponseHandler.getResponse("Deleted role successfully", HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity<Object> getCourseById(int id) {
		CourseDTO getCourse = service.getCourseById(id);
		return ResponseHandler.getResponse(getCourse,HttpStatus.OK);
	}
}
