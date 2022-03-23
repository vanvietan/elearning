package com.luv2code.java14.elearning.dto.chapter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@SuperBuilder
public class ChapterDTO {
	
	private int id;
	
	private String title;
	
	private String paragraph;
}
