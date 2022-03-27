package com.luv2code.java14.elearning.service.library;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.java14.elearning.common.exception.NotFoundException;
import com.luv2code.java14.elearning.dto.CourseDTO;
import com.luv2code.java14.elearning.dto.LibraryDTO;
import com.luv2code.java14.elearning.entity.course.Course;
import com.luv2code.java14.elearning.entity.library.Library;
import com.luv2code.java14.elearning.entity.library.LibraryKey;
import com.luv2code.java14.elearning.entity.user.User;
import com.luv2code.java14.elearning.repository.CourseRepository;
import com.luv2code.java14.elearning.repository.LibraryRepository;
import com.luv2code.java14.elearning.repository.UserRepository;

@Service
@Transactional(rollbackFor = Exception.class)
public class LibraryServiceImpl implements LibraryService {
	
	@Autowired
	private LibraryRepository libraryRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired 
	private UserRepository userRepository;

	@Override
	public List<CourseDTO> getAllCourseByUserId(int userId) {
		User user = userRepository.findById(userId)
				.orElseThrow(
						() -> new EntityNotFoundException("User id not existed"));
	
		return user.getLibraries()
				.stream()
				.map(lc ->{
					CourseDTO dto = new CourseDTO();
					BeanUtils.copyProperties(lc.getCourse(), dto);
					return dto;
				})
				.collect(Collectors.toList());
	}

	@Override
	public void addCourseToLibrary(int courseId, int userId) {
		User user = userRepository.findById(userId)
				.orElseThrow(
						() -> new EntityNotFoundException("User id is not existed"));
		Course course = courseRepository.findById(courseId)
				.orElseThrow(
						() -> new EntityNotFoundException("Course id is not existed"));
		
		LibraryKey key = new LibraryKey(userId, courseId);
		Optional<Library> optLibraryCourse = libraryRepository.findById(key);
		if(optLibraryCourse.isPresent())
			return;
		
		Library libraryCourse = new Library();
		libraryCourse.setKey(key);
		libraryCourse.setUser(user);
		libraryCourse.setCourse(course);
		
		libraryRepository.save(libraryCourse);
		
	}

	@Override
	public void deleteCourseFromLibrary(int courseId, int userId) {
		LibraryKey key = new LibraryKey(userId,courseId);
		Optional<Library> optLibraryCourse = libraryRepository.findById(key);
		if(optLibraryCourse.isPresent())
			libraryRepository.deleteById(key);
		
	}

	@Override
	public LibraryDTO rateTheCourse(int courseId, int userId, int rating) {
		User user = userRepository.findById(userId)
				.orElseThrow(
						() -> new EntityNotFoundException("User id is not existed"));
		Course course = courseRepository.findById(courseId)
				.orElseThrow(
						() -> new EntityNotFoundException("Course id is not existed"));
		
		LibraryKey key = new LibraryKey(userId, courseId);
		Optional<Library> optLibraryCourse = libraryRepository.findById(key);
		if(!optLibraryCourse.isPresent()) {
			throw new NotFoundException("Can't rate your course");
		}
		Library rateCourse = optLibraryCourse.get();
		rateCourse.setRating(rating);
		libraryRepository.save(rateCourse);
		LibraryDTO dto = new LibraryDTO();
		BeanUtils.copyProperties(rateCourse, dto);
		return dto;
	}
	
}
