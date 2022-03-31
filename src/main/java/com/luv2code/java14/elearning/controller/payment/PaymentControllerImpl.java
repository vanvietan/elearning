package com.luv2code.java14.elearning.controller.payment;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.java14.elearning.common.ResponseHandler;
import com.luv2code.java14.elearning.dto.PaymentDTO;
import com.luv2code.java14.elearning.entity.payment.Payment;
import com.luv2code.java14.elearning.service.payment.PaymentService;

@RestController
@RequestMapping("/api")
public class PaymentControllerImpl implements PaymentController {

	@Autowired
	private PaymentService service;
	
	@Override
	public ResponseEntity<Object> createPayment(int userId, @Valid PaymentDTO paymentDTO) {
		
		service.createPayment(paymentDTO, userId);
		
		return ResponseHandler.getResponse("Create payment successfully", HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> getPayment(int userId) {
		
		List<PaymentDTO> payment = service.getPayment(userId);
		
		return ResponseHandler.getResponse(payment, HttpStatus.OK);
	}
}
