package com.luv2code.java14.elearning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.luv2code.java14.elearning.entity.library.Library;
import com.luv2code.java14.elearning.entity.library.LibraryKey;

@Repository
public interface LibraryRepository extends JpaRepository<Library, LibraryKey>{
	
	@Query(value="SELECT rating FROM library_course WHERE course_id =?",nativeQuery=true)
	List<Library> findAllRatingByUserInTheCourse(int courseId);
	
	@Query(value="SELECT AVG(rating) FROM library_course WHERE course_id =?",nativeQuery=true)
	double averageRatingOfTheCourse(int courseId);

}
