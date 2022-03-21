package com.luv2code.java14.elearning.entity.cart;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.luv2code.java14.elearning.entity.course.Course;
import com.luv2code.java14.elearning.entity.user.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name= "user_course")
@Getter
@Setter
@NoArgsConstructor
public class Cart {
	@EmbeddedId
	private CartKey key;
	
	@ManyToOne
	@MapsId("userId")
    @JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@MapsId("courseId")
    @JoinColumn(name = "course_id")
	private Course course;
	
	@Column(name = "price")
	private Double price;
	
}
