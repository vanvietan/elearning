package com.luv2code.java14.elearning.controller.receipt_course;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public interface ReceiptCourseController {

	@GetMapping(value="/receipt_course")
	public ResponseEntity<Object> findAllReceiptCourse();
}
