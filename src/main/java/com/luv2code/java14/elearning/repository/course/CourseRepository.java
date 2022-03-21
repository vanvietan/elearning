package com.luv2code.java14.elearning.repository.course;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luv2code.java14.elearning.entity.course.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

	Optional<Course> findByName(String courseName);
}
