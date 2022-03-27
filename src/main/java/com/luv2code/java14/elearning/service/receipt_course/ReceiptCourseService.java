package com.luv2code.java14.elearning.service.receipt_course;

import java.util.List;

import com.luv2code.java14.elearning.entity.receipt.ReceiptCourse;

public interface ReceiptCourseService {

	List<ReceiptCourse> findAll();

	void createReceiptCourse(int receiptId, int[] courseId);

}
