package com.luv2code.java14.elearning.entity.chapter;

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
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name="user_chapter")
public class UserChapterProgress {
	
	@EmbeddedId
	private UserChapterKey key;
	
	@ManyToOne
	@MapsId("userId")
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne
	@MapsId("courseId")
	@JoinColumn(name="course_id")
	private Course course;
	
	@ManyToOne
	@MapsId("chapterId")
	@JoinColumn(name="chapter_id")
	private Chapter chapter;
	
	@Column(name="tick")
	private int tickProgress;
}
