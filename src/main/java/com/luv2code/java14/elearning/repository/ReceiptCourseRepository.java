package com.luv2code.java14.elearning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.luv2code.java14.elearning.entity.receipt.ReceiptCourse;
import com.luv2code.java14.elearning.entity.receipt.ReceiptCourseKey;

@Repository
public interface ReceiptCourseRepository extends JpaRepository<ReceiptCourse, Integer> {

	@Query(value="SELECT * FROM receipt_course WHERE receipt_id = ?1", nativeQuery = true)
	List<ReceiptCourse> getReceiptCourse(int id);
}
