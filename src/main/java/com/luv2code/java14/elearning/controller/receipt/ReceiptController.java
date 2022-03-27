package com.luv2code.java14.elearning.controller.receipt;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface ReceiptController {

	@GetMapping(value="/receipt")
	public ResponseEntity<Object> findAllReceipt();
	
	@PostMapping(value="/receipt/{userId}")
	public ResponseEntity<Object> createReceipt(
			@PathVariable("userId") int userId,
			@RequestParam("courseId") int[] courseId
			);
}
