package com.luv2code.java14.elearning.entity.receipt;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.luv2code.java14.elearning.entity.course.Course;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name="receipt_course")
public class ReceiptCourse {
	
	@EmbeddedId
	private ReceiptCourseKey key;
	
	@ManyToOne
	@MapsId("courseId")
	@JoinColumn(name="course_id")
	private Course course;
	
	@ManyToOne
	@MapsId("receiptId")
	@JoinColumn(name="receipt_id")
	private Receipt receipt;
	
	@Column(name="price")
	private double price;
}
