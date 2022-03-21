package com.luv2code.java14.elearning.service.library;

import java.util.List;

import com.luv2code.java14.elearning.dto.course.CourseDTO;

public interface LibraryService {

	List<CourseDTO> getAllCourseByUserId(int userId);

	void addCourseToLibrary(int courseId, int userId);

	void deleteCourseFromLibrary(int courseId, int userId);

}
