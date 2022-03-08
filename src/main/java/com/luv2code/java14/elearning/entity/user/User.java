package com.luv2code.java14.elearning.entity.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.luv2code.java14.elearning.entity.chapter.UserChapterProgress;
import com.luv2code.java14.elearning.entity.course.Course;
import com.luv2code.java14.elearning.entity.payment.Payment;
import com.luv2code.java14.elearning.entity.receipt.Receipt;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name" , nullable = false)
	private String name;
	
	@Column(name="email", nullable = false, unique = true)
	private String email;
	
	@Column(name="username", nullable = false, unique = true)
	private String username;
	
	@Column(name="password", nullable = false)
	private String password;
	
	@ManyToOne
	@JoinColumn(name="role_id")
	private Role role;
	
	@OneToMany(mappedBy="user",
			cascade= {CascadeType.PERSIST, CascadeType.MERGE,
					CascadeType.DETACH, CascadeType.REFRESH })
	private List<Course> courses;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	private List<Payment> payments;
	
	@OneToMany(mappedBy="user",
			cascade= {CascadeType.PERSIST, CascadeType.MERGE,
					CascadeType.DETACH, CascadeType.REFRESH })
	private List<Receipt> receipts;
	
	@OneToMany(mappedBy="user")
	private Set<UserChapterProgress> tickProgress; 
	
	
	//add convenience methods for bi-directional relationship padding courses 
	public void add(Course tempCourse) {
		if(courses == null) {
			courses = new ArrayList<>();
		}
		courses.add(tempCourse);
		tempCourse.setUser(this);
	}
	
	//add convenience methods for adding payment
	public void add(Payment tempPayment) {
		if(payments == null) {
			payments = new ArrayList<>();
		}
		payments.add(tempPayment);
	}
	
	//add helper method for bi-directional relationship adding receipt
	
	public void add(Receipt tempReceipt) {
		if(receipts == null) {
			receipts = new ArrayList<>();
		}
		
		receipts.add(tempReceipt);
		tempReceipt.setUser(this);
		
	}
	
}