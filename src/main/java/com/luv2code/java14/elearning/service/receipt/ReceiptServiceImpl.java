package com.luv2code.java14.elearning.service.receipt;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.java14.elearning.dto.ReceiptDTO;
import com.luv2code.java14.elearning.entity.course.Course;
import com.luv2code.java14.elearning.entity.receipt.Receipt;
import com.luv2code.java14.elearning.entity.receipt.ReceiptCourse;
import com.luv2code.java14.elearning.entity.user.User;
import com.luv2code.java14.elearning.repository.CourseRepository;
import com.luv2code.java14.elearning.repository.ReceiptCourseRepository;
import com.luv2code.java14.elearning.repository.ReceiptRepository;
import com.luv2code.java14.elearning.repository.UserRepository;
import com.luv2code.java14.elearning.service.receipt_course.ReceiptCourseService;

@Service
public class ReceiptServiceImpl implements ReceiptService {

	@Autowired
	private ReceiptRepository receiptRepository;
	
	@Autowired 
	private UserRepository userRepository;
	
	@Autowired
	private ReceiptCourseService receiptCourseService;
	
	@Autowired
	private ReceiptCourseRepository receiptCourseRepository;
	
	@Autowired
	private CourseRepository courseRepository;

	@Override
	public ReceiptDTO createReceipt(int userId, int[] courseId) {
		
		LocalDateTime createdAt = LocalDateTime.now(); 
		
		// Create temporarily Receipt
		User user = userRepository.findById(userId)
				.orElseThrow(
				() -> new EntityNotFoundException("User is not existed"));
		
		
		for (int cId : courseId) {
			Course course = courseRepository.findById(cId)
					.orElseThrow(
					() -> new EntityNotFoundException("Course is not existed"));
		}
		
		Receipt receipt = new Receipt();
		receipt.setTotalPrice(0);
		receipt.setUser(user);
		receipt.setCreatedAt(createdAt);
		receiptRepository.save(receipt);
		
		// Create Receipt_Course 
		receiptCourseService.createReceiptCourse(receipt.getId(), courseId);
		
		// Get list of Receipt_Course by Receipt ID
		List<ReceiptCourse> receiptCourse = receiptCourseRepository.getReceiptCourse(receipt.getId());
		
		// Update price for Receipt_Course
		double totalPrice = 0;
		for (ReceiptCourse rc : receiptCourse) {
			totalPrice += rc.getPrice();
		}
		receipt.setTotalPrice(totalPrice);
		receiptRepository.save(receipt);
		
		ReceiptDTO rDTO = new ReceiptDTO();
		BeanUtils.copyProperties(receipt, rDTO);
		return rDTO;
		
	}

	@Override
	public List<ReceiptDTO> findReceiptByUserId(int userId) {
		User user = userRepository.findById(userId)
				.orElseThrow(
				() -> new EntityNotFoundException("User is not existed"));
		
		return user.getReceipts()
				.stream()
				.map(ur -> {
					ReceiptDTO dto = new ReceiptDTO();
					BeanUtils.copyProperties(ur, dto);
					return dto;
				})
				.collect(Collectors.toList());
	}
}
