package com.luv2code.java14.elearning.entity.receipt;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ReceiptCourseKey implements Serializable{
	@Column(name="course_id")
	private int courseId;
	
	@Column(name="receipt_id")
	private int receiptId;
}
