package com.luv2code.java14.elearning.service.chapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.java14.elearning.common.exception.NotFoundException;
import com.luv2code.java14.elearning.dto.chapter.ChapterDTO;
import com.luv2code.java14.elearning.entity.chapter.Chapter;
import com.luv2code.java14.elearning.entity.chapter.UserChapterKey;
import com.luv2code.java14.elearning.entity.chapter.UserChapterProgress;
import com.luv2code.java14.elearning.entity.course.Course;
import com.luv2code.java14.elearning.entity.user.User;
import com.luv2code.java14.elearning.repository.chapter.ChapterProgressRepository;
import com.luv2code.java14.elearning.repository.chapter.ChapterRepository;
import com.luv2code.java14.elearning.repository.course.CourseRepository;
import com.luv2code.java14.elearning.repository.user.UserRepository;

@Service
@Transactional(rollbackFor = Exception.class)
public class ChapterServiceImpl implements ChapterService {
	
	@Autowired
	private ChapterRepository chapterRepository;
	
	@Autowired
	private ChapterProgressRepository chapterProgressRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired 
	private UserRepository userRepository;
	

	@Override
	public void finishTheChapter(int userId, int courseId, int chapterId) {
		User user = userRepository.findById(userId)
				.orElseThrow(
						() -> new EntityNotFoundException("User id is not existed"));
		Course course = courseRepository.findById(courseId)
				.orElseThrow(
						() -> new EntityNotFoundException("Course id is not existed"));
		//bổ sung chapter id exception
		//
		UserChapterKey key = new UserChapterKey(userId, courseId, chapterId);
		Optional<UserChapterProgress> opt = chapterProgressRepository.findById(key);
		if(!opt.isPresent())
			throw new NotFoundException("Can't tick a finished course");
		UserChapterProgress finishedChapter = opt.get();
		finishedChapter.setTickProgress(1);
		chapterProgressRepository.save(finishedChapter);

	}

	@Override
	public List<ChapterDTO> getAllChaptersInCourse(int courseId) {
		List<Chapter> chapters = chapterRepository.findByCourseId(courseId);
		List<ChapterDTO> dtos = new ArrayList<>();
		BeanUtils.copyProperties(chapters, dtos);
		return dtos;
	}

}
