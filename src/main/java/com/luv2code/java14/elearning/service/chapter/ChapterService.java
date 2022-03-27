package com.luv2code.java14.elearning.service.chapter;

import java.util.List;

import javax.validation.Valid;

import com.luv2code.java14.elearning.dto.ChapterDTO;

public interface ChapterService {

	void finishTheChapter(int userId, int courseId, int chapterId);

	List<ChapterDTO> getAllChaptersInCourse(int courseId);

	ChapterDTO getTheChapter(int chapterId);

	void deleteChapter(int chapterId);

	ChapterDTO createChapterInCourse(int courseId,ChapterDTO chapterDTO);

	ChapterDTO updateChapter(int chapterId, ChapterDTO chapterDTO);

}
