package com.luv2code.java14.elearning.repository.chapter;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.luv2code.java14.elearning.entity.chapter.Chapter;

public interface ChapterRepository extends JpaRepository<Chapter, Integer> {

	@Query(value="SELECT * FROM chapter WHERE course_id = ?", nativeQuery =true)
	List<Chapter> findByCourseId(int courseId);


}
