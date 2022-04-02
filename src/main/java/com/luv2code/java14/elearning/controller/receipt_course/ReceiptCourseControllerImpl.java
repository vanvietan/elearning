package com.luv2code.java14.elearning.controller.receipt_course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.java14.elearning.common.ResponseHandler;
import com.luv2code.java14.elearning.dto.ReceiptCourseDTO;
import com.luv2code.java14.elearning.entity.receipt.ReceiptCourse;
import com.luv2code.java14.elearning.service.receipt_course.ReceiptCourseService;

@RestController
@RequestMapping("/api")
public class ReceiptCourseControllerImpl implements ReceiptCourseController {
	
	@Autowired
	private ReceiptCourseService service;

	@Override
	public ResponseEntity<Object> findByReceiptId(int receiptId) {
		
		List<ReceiptCourseDTO> receiptCourses = service.findByReceiptId(receiptId);
		
		return ResponseHandler.getResponse(receiptCourses, HttpStatus.OK);
	}
	
	
}
