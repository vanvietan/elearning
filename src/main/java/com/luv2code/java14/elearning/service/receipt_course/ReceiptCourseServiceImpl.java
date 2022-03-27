package com.luv2code.java14.elearning.service.receipt_course;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.java14.elearning.entity.course.Course;
import com.luv2code.java14.elearning.entity.receipt.Receipt;
import com.luv2code.java14.elearning.entity.receipt.ReceiptCourse;
import com.luv2code.java14.elearning.entity.receipt.ReceiptCourseKey;
import com.luv2code.java14.elearning.entity.user.User;
import com.luv2code.java14.elearning.repository.CourseRepository;
import com.luv2code.java14.elearning.repository.ReceiptCourseRepository;
import com.luv2code.java14.elearning.repository.ReceiptRepository;
import com.luv2code.java14.elearning.repository.UserRepository;

@Service
public class ReceiptCourseServiceImpl implements ReceiptCourseService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ReceiptCourseRepository receiptCourseRepository;
	
	@Autowired
	private ReceiptRepository receiptRepository;
	
	@Autowired
	private CourseRepository courseRepository;

	@Override
	public List<ReceiptCourse> findAll() {
		List<ReceiptCourse> receiptCourses = receiptCourseRepository.findAll();
		
		return receiptCourses;
	}
	
	@Override
	public void createReceiptCourse(int receiptId, int[] courseId) {
		Receipt receipt = receiptRepository.findById(receiptId)
				.orElseThrow(
				() -> new EntityNotFoundException("Receipt is not existed"));
		
		// Create Receipt_Course 
		ReceiptCourse rc = new ReceiptCourse();
		for (int c : courseId) {
			Course course = courseRepository.getById(c);
			ReceiptCourseKey key = new ReceiptCourseKey(c, receiptId);
			rc.setPrice(course.getPrice());
			rc.setKey(key);
			rc.setCourse(course);
			rc.setReceipt(receipt);
			receiptCourseRepository.save(rc);
		}
		
	}

}
