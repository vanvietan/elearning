package com.luv2code.java14.elearning.service.receipt_course;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.java14.elearning.dto.ReceiptCourseDTO;
import com.luv2code.java14.elearning.entity.course.Course;
import com.luv2code.java14.elearning.entity.receipt.Receipt;
import com.luv2code.java14.elearning.entity.receipt.ReceiptCourse;
import com.luv2code.java14.elearning.entity.receipt.ReceiptCourseKey;
import com.luv2code.java14.elearning.repository.CourseRepository;
import com.luv2code.java14.elearning.repository.ReceiptCourseRepository;
import com.luv2code.java14.elearning.repository.ReceiptRepository;

@Service
public class ReceiptCourseServiceImpl implements ReceiptCourseService {
	
	@Autowired
	private ReceiptCourseRepository receiptCourseRepository;
	
	@Autowired
	private ReceiptRepository receiptRepository;
	
	@Autowired
	private CourseRepository courseRepository;

	@Override
	public List<ReceiptCourseDTO> findByReceiptId(int receiptId) {
		
		Receipt receipt = receiptRepository.findById(receiptId)
				.orElseThrow(
						() -> new EntityNotFoundException("Receipt is not existed"));
		
		return receipt.getReceiptCourses()
				.stream()
				.map(rc -> {
					ReceiptCourseDTO dto = new ReceiptCourseDTO();
					BeanUtils.copyProperties(rc, dto);
					return dto;
				})
				.collect(Collectors.toList());
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
