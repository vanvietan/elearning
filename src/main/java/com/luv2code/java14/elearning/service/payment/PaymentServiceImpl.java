package com.luv2code.java14.elearning.service.payment;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.java14.elearning.dto.PaymentDTO;
import com.luv2code.java14.elearning.entity.payment.Payment;
import com.luv2code.java14.elearning.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentRepository repository;
	
	@Override
	public void createPayment(@Valid PaymentDTO paymentDTO) {

		Payment payment = new Payment();
		
		BeanUtils.copyProperties(paymentDTO, payment);
		
		repository.save(payment);
	}

}
