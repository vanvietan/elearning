package com.luv2code.java14.elearning.entity.cart;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class CartKey implements Serializable{
	@Column(name="user_id")
	private int userId;
	
	@Column(name="course_id")
	private int courseId;
}
