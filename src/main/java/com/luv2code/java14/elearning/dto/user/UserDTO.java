package com.luv2code.java14.elearning.dto.user;


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
public class UserDTO {
	
	private int id;
	
	@NotBlank(message="Username is mandatory")
	@Size(max = 20)
	private String username;
	
	@NotBlank(message="Email is mandatory")
	@Size(max=255)
	private String email;
	
	@NotBlank(message="Password is mandatory")
	@Size(min = 4, max = 20)
	private String password;
	
	@NotBlank(message="Retype your Password please")
	@Size(min = 4, max = 20)
	private String retypePassword;
	
	@NotBlank(message="Name is mandatory")
	@Size(min = 3, max = 255)
	private String name;
}
