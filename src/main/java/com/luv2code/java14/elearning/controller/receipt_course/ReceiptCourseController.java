package com.luv2code.java14.elearning.controller.receipt_course;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface ReceiptCourseController {

	@GetMapping(value="/receipt_course/{receiptId}")
	public ResponseEntity<Object> findByReceiptId(
			@PathVariable("receiptId") int receiptId
			);
}
