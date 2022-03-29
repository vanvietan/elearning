package com.luv2code.java14.elearning.dto;

import java.util.Date;

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
public class PaymentDTO {

	private int id;
	
	@NotBlank(message="Username is mandatory")
	private String name;

	@NotBlank(message="Number is mandatory")
	private int number;

	@NotBlank(message="Security Code is mandatory")
	private int securityCode;

	@NotBlank(message="Date is mandatory")
	private Date expiredDate;
}
