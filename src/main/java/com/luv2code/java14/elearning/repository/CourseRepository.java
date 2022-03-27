package com.luv2code.java14.elearning.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.luv2code.java14.elearning.entity.course.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

	Optional<Course> findByName(String courseName);

	@Modifying
	@Query(value="SELECT * FROM course WHERE name LIKE '%?1%'", nativeQuery = true)
	List<Course> findByKeyword(String courseKeyword);
	
}
