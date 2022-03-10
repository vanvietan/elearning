package com.luv2code.java14.elearning.entity.payment;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name="payment")
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
//	private int userId;
	
	@Column(name="name", nullable= false)
	private String name;
	
	@Column(name="number", nullable= false)
	private int number;
	
	@Column(name="security_code", nullable= false)
	private int securityCode;
	
	@Column(name="expired_date", nullable= false)
	private Date expiredDate;
	
	
}
