package com.luv2code.java14.elearning.dto.course;

import javax.validation.constraints.NotBlank;

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
public class UpdateCourseDTO {
	@NotBlank(message = "{Course name can not be blank")
	private String name;
	
	@NotBlank(message = "Course info can not be blank")
	private String courseInfo;

	@NotBlank(message = "Course price can not be blank")
	private int price;
}