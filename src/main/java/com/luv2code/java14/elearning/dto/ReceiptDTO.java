package com.luv2code.java14.elearning.dto;

import java.time.LocalDateTime;

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
public class ReceiptDTO {

	private int id;
	
	private double totalPrice;
	
	private LocalDateTime createdAt;
}
