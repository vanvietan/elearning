package com.luv2code.java14.elearning.service.video;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.java14.elearning.dto.VideoDTO;
import com.luv2code.java14.elearning.entity.chapter.Chapter;
import com.luv2code.java14.elearning.entity.chapter.Video;
import com.luv2code.java14.elearning.repository.ChapterRepository;
import com.luv2code.java14.elearning.repository.VideoRepository;

@Service
public class VideoServiceImpl implements VideoService {

	@Autowired
	private VideoRepository videoRepository;
	
	@Autowired
	private ChapterRepository chapterRepository;
	
	@Override
	public List<VideoDTO> findAll() {
		
		List<Video> videos = videoRepository.findAll();
		List<VideoDTO> dtos = new ArrayList<>();
		for(Video video : videos) {
			VideoDTO dto = new VideoDTO();
			BeanUtils.copyProperties(video, dto);
			dtos.add(dto);
		}
		
		return dtos;
	}


	@Override
	public VideoDTO getVideo(int videoId) {
		
		Video video = videoRepository.findById(videoId)
				.orElseThrow(
						() -> new EntityNotFoundException("Can't find the video id"));
		VideoDTO dto = new VideoDTO();
		BeanUtils.copyProperties(video, dto);
		
		return dto;
	}


	@Override
	public VideoDTO addVideoToChapter(int chapterId, VideoDTO videoDTO) {
		
		Chapter chapter = chapterRepository.findById(chapterId)
				.orElseThrow(
						() -> new EntityNotFoundException("Can't find the chapter id"));
		
		if(chapter.getVideo() != null)
			throw new RuntimeException("Chapter already had a video!!!");
			
		Video video = new Video();
		BeanUtils.copyProperties(videoDTO, video);
		
		chapter.setVideo(video);
		chapterRepository.save(chapter);
//		videoRepository.save(video);
		
		VideoDTO dto = new VideoDTO();
		BeanUtils.copyProperties(video, dto);
		
		return dto;
	}


	@Override
	public VideoDTO updateVideo(int videoId, VideoDTO videoDTO) {
		Video video = videoRepository.findById(videoId)
				.orElseThrow(
						() -> new EntityNotFoundException("Can't find the video id"));
		if(!video.getInfo().equals(videoDTO.getInfo()))
			video.setInfo(videoDTO.getInfo());
		
		if(!video.getFilepath().equals(videoDTO.getFilepath()))
			video.setFilepath(videoDTO.getFilepath());
		
		if(!video.getTimeframe().equals(videoDTO.getTimeframe()))
			video.setTimeframe(videoDTO.getTimeframe());
		
		videoRepository.save(video);
		VideoDTO dto = new VideoDTO();
		BeanUtils.copyProperties(video, dto);
		
		return dto;
	}


	@Override
	public void deleteVideo(int videoId) {
		Video video = videoRepository.findById(videoId)
				.orElseThrow(
						() -> new EntityNotFoundException("Can't find the video id"));
		videoRepository.deleteById(videoId);
	}

}
