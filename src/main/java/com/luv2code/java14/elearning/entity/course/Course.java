package com.luv2code.java14.elearning.entity.course;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.luv2code.java14.elearning.entity.cart.CartCourse;
import com.luv2code.java14.elearning.entity.chapter.Chapter;
import com.luv2code.java14.elearning.entity.chapter.UserChapterProgress;
import com.luv2code.java14.elearning.entity.library.LibraryCourse;
import com.luv2code.java14.elearning.entity.receipt.ReceiptCourse;
import com.luv2code.java14.elearning.entity.user.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name="course")
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name" , nullable = false)
	private String name;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@Column(name="course_info")
	private String courseInfo;
	
	@Column(name="price", nullable = false)
	private int price;
	
	@Column(name="rating")
	private int rating;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="course_id")
	private List<Chapter> chapters;
	
	@OneToMany(mappedBy="course")
	private Set<LibraryCourse> ratings;
	
	@OneToMany(mappedBy="course")
	private Set<CartCourse> tickChoose;
	
	@OneToMany(mappedBy="course")
	private Set<ReceiptCourse> prices;
	
	@OneToMany(mappedBy="course")
	private Set<UserChapterProgress> tickProgress; 
	
	
	//add convenience methods for adding chapters
	
	public void add(Chapter tempChapter) {
		if(chapters ==null) {
			chapters = new ArrayList<>();
		}
		chapters.add(tempChapter);
	}
}
