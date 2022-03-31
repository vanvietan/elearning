package com.luv2code.java14.elearning.dto;

import com.luv2code.java14.elearning.entity.course.Course;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ReceiptCourseDTO {

	private Course course;
	
	private double price;
	
	public int getCourseId() {
		
		return this.course.getId();
	}
	
}
