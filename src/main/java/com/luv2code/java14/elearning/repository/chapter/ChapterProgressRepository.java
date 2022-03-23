package com.luv2code.java14.elearning.repository.chapter;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.luv2code.java14.elearning.entity.chapter.UserChapterKey;
import com.luv2code.java14.elearning.entity.chapter.UserChapterProgress;

@Repository
public interface ChapterProgressRepository extends JpaRepository<UserChapterProgress, UserChapterKey> {

	@Query(value="SELECT * FROM user_chapter WHERE user_id = ?1 AND course_id = ?2", nativeQuery =true)
	List<UserChapterProgress> findUserTicks(int userId, int courseId);

}
