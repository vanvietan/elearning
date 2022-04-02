package com.luv2code.java14.elearning.service.receipt_course;

import java.util.List;

import com.luv2code.java14.elearning.dto.ReceiptCourseDTO;

public interface ReceiptCourseService {

	void createReceiptCourse(int receiptId, int[] courseId);

	List<ReceiptCourseDTO> findByReceiptId(int receiptId);

}
