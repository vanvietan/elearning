package com.luv2code.java14.elearning.service.payment;

import javax.validation.Valid;

import com.luv2code.java14.elearning.dto.PaymentDTO;

public interface PaymentService {

	void createPayment(@Valid PaymentDTO paymentDTO);

}
