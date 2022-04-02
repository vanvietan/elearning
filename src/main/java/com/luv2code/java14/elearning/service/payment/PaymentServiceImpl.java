package com.luv2code.java14.elearning.service.payment;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.luv2code.java14.elearning.dto.PaymentCreateDTO;
import com.luv2code.java14.elearning.dto.PaymentDTO;
import com.luv2code.java14.elearning.entity.payment.Payment;
import com.luv2code.java14.elearning.entity.user.User;
import com.luv2code.java14.elearning.repository.PaymentRepository;
import com.luv2code.java14.elearning.repository.UserRepository;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired UserRepository userRepository;
	
	@Override
	public void createPayment(PaymentCreateDTO createPaymentDTO, int userId) {
		
		User user = userRepository.findById(userId)
				.orElseThrow(
				() -> new EntityNotFoundException("User is not existed"));
		
		Payment payment = new Payment();

		payment.setName(encoder.encode(createPaymentDTO.getName().toUpperCase()));
		payment.setSecurityCode(encoder.encode(createPaymentDTO.getSecurityCode()));
		payment.setNumber(encoder.encode(createPaymentDTO.getNumber()));
		payment.setExpiredDate(createPaymentDTO.getExpiredDate());
		payment.setUser(user);
		
		paymentRepository.save(payment);
	}

	@Override
	public List<PaymentDTO> getPayment(int userId) {

		User user = userRepository.findById(userId)
				.orElseThrow(
				() -> new EntityNotFoundException("User is not existed"));
		
		return user.getPayments()
				.stream()
				.map(up -> {
					PaymentDTO dto = new PaymentDTO();
					BeanUtils.copyProperties(up, dto);
					return dto;
				})
				.collect(Collectors.toList());
	}
	
	
	@Override
	public Optional<Payment> createPaymentBankingDTO(int paymentId) {
		
		return paymentRepository.findById(paymentId);
	}
}
