package com.luv2code.java14.elearning.service.receipt;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public Receipt createReceipt(int userId, int[] courseId) {
		
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

		// Find recently created Receipt by User Id
		Receipt r = receiptRepository.findReceiptCreatedByUserId(userId, createdAt);
		
		// Create Receipt_Course 
		receiptCourseService.createReceiptCourse(r.getId(), courseId);
		
		// Get list of Receipt_Course by Receipt ID
		List<ReceiptCourse> receiptCourse = receiptCourseRepository.getReceiptCourse(r.getId());
		
		// Update price for Receipt_Course
		double totalPrice = 0;
		for (ReceiptCourse rc : receiptCourse) {
			totalPrice += rc.getPrice();
		}
		r.setTotalPrice(totalPrice);
		
		return r;
		
	}

	@Override
	public List<Receipt> findAll() {
		
		return receiptRepository.findAll();
	}
}
