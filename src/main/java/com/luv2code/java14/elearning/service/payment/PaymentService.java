package com.luv2code.java14.elearning.service.payment;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.luv2code.java14.elearning.dto.PaymentDTO;
import com.luv2code.java14.elearning.entity.payment.Payment;

public interface PaymentService {

	void createPayment(@Valid PaymentDTO paymentDTO, int userId);

	List<PaymentDTO> getPayment(int userId);

}
