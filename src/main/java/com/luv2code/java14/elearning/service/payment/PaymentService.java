package com.luv2code.java14.elearning.service.payment;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.luv2code.java14.elearning.dto.PaymentBankingDTO;
import com.luv2code.java14.elearning.dto.PaymentCreateDTO;
import com.luv2code.java14.elearning.dto.PaymentDTO;
import com.luv2code.java14.elearning.entity.payment.Payment;

public interface PaymentService {

	List<PaymentDTO> getPayment(int userId);

	void createPayment(PaymentCreateDTO createPaymentDTO, int userId);

	PaymentBankingDTO getPaymentBanking(int paymentId);

}
