package com.luv2code.java14.elearning.dto;

import java.time.LocalDate;
import java.util.Date;

import javax.validation.constraints.NotBlank;

import com.luv2code.java14.elearning.entity.user.User;

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
public class PaymentDTO {
	
	private User user;
	
	@NotBlank(message="Username is mandatory")
	
	private String name;

	@NotBlank(message="Number is mandatory")
	private String number;
	
	@NotBlank(message="Security code is madatory")
	private String securityCode;

	@NotBlank(message="Date is mandatory")
	private LocalDate expiredDate;
}
