package com.luv2code.java14.elearning.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.luv2code.java14.elearning.entity.user.User;
import com.luv2code.java14.elearning.security.annotation.CardExpiration;
import com.luv2code.java14.elearning.security.annotation.CardNumber;

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
public class PaymentCreateDTO {
	
	private User user;
	
	@NotBlank(message="Username is mandatory")
	private String name;

	@NotBlank(message="Number is mandatory")
	@CardNumber
	private String number;
	
	@NotBlank(message="Security code is madatory")
	@Size(max = 3, min = 3)
	private String securityCode;

	@NotBlank(message="Date is mandatory")
	@CardExpiration
	private String expiredDate;
}
