package com.luv2code.java14.elearning.dto.course;

import javax.validation.constraints.NotBlank;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UpdateCourseDTO {
	@NotBlank(message = "{course.name.not-blank}")
	private String courseName;
	
	@NotBlank(message = "{course.info.not-blank}")
	private String courseInfo;

	@NotBlank(message = "{course.price.not-blank}")
	private int price;

	@NotBlank(message = "{course.rating.not-blank}")
	private int rating;
}
