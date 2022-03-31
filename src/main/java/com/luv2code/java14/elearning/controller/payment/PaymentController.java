package com.luv2code.java14.elearning.controller.payment;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.luv2code.java14.elearning.dto.PaymentDTO;

public interface PaymentController {

	@GetMapping(value="/payment/{userId}")
	public ResponseEntity<Object> getPayment(
			@PathVariable(value="userId") int userId
			);
	
	@PostMapping(value="/payment/{userId}")
	public ResponseEntity<Object> createPayment(
			@PathVariable(value="userId") int userId,
			@Valid @RequestBody PaymentDTO paymentDTO
			);
}
