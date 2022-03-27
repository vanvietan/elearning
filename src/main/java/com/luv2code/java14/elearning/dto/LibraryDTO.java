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
public class LibraryDTO {
	
	private Course course;
	
	private int rating;
}
