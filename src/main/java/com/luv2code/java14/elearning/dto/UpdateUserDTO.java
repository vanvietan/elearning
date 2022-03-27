package com.luv2code.java14.elearning.dto;

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
public class UpdateUserDTO {
	
	@NotBlank
	@Size(max = 20)
	private String username;
	
	@NotBlank
	private String email;
	
	@NotBlank
	@Size(min = 4)
	private String password;
	
	@NotBlank
	@Size(min = 3)
	private String name;
	
	
}
