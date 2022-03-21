package com.luv2code.java14.elearning.dto.course;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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
public class CourseDTO {

	private int id;
	
	@NotBlank
	@Size(max = 20)
	private String courseName;
	
	@NotBlank
	private String courseInfo;
	
	@NotBlank
	private double price;
	
	@NotBlank
	private int rating;
}
