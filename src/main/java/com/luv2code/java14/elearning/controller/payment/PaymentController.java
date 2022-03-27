package com.luv2code.java14.elearning.controller.payment;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.luv2code.java14.elearning.dto.PaymentDTO;

public interface PaymentController {

	@PostMapping(value="/payment")
	public ResponseEntity<Object> createPayment(
			@Valid @RequestBody PaymentDTO paymentDTO,
			BindingResult bindingResult
			);
}
