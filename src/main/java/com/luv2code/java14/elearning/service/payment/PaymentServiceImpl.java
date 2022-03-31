package com.luv2code.java14.elearning.service.payment;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
	public void createPayment(@Valid PaymentDTO paymentDTO, int userId) {
		
		User user = userRepository.findById(userId)
				.orElseThrow(
				() -> new EntityNotFoundException("User is not existed"));

		LocalDate date = LocalDate.now();
		
		if (paymentDTO.getExpiredDate().isAfter(date)) {
			return;
		}
		
		Payment payment = new Payment();
		
		BeanUtils.copyProperties(paymentDTO, payment);
		payment.setName(encoder.encode(paymentDTO.getName()));
		payment.setSecurityCode(encoder.encode(paymentDTO.getSecurityCode()));
		payment.setNumber(encoder.encode(paymentDTO.getNumber()));
		payment.setUser(user);
		
		paymentRepository.save(payment);
	}

	@Override
	public List<PaymentDTO> getPayment(int userId) {

		User user = userRepository.findById(userId)
				.orElseThrow(
				() -> new EntityNotFoundException("User is not existed"));
		
//		Optional<Payment> payment = paymentRepository.findById(userId);
		
		return user.getPayments()
				.stream()
				.map(up -> {
					PaymentDTO dto = new PaymentDTO();
					BeanUtils.copyProperties(up, dto);
					return dto;
				})
				.collect(Collectors.toList());
	}

}
