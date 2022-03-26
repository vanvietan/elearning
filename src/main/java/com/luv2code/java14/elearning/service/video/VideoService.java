package com.luv2code.java14.elearning.service.video;

import java.util.List;

import javax.validation.Valid;

import com.luv2code.java14.elearning.dto.VideoDTO;

public interface VideoService {

	List<VideoDTO> findAll();

	VideoDTO getVideo(int videoId);

	VideoDTO addVideoToChapter(int chapterId, VideoDTO videoDTO);

	VideoDTO updateVideo(int videoId, VideoDTO videoDTO);

	void deleteVideo(int videoId);


}
