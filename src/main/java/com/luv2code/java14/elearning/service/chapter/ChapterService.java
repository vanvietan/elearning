package com.luv2code.java14.elearning.service.chapter;

import java.util.List;

import com.luv2code.java14.elearning.dto.chapter.ChapterDTO;

public interface ChapterService {

	void finishTheChapter(int userId, int courseId, int chapterId);

	List<ChapterDTO> getAllChaptersInCourse(int courseId);

}
