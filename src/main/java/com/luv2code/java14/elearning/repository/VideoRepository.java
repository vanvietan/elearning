package com.luv2code.java14.elearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luv2code.java14.elearning.entity.chapter.Video;

@Repository
public interface VideoRepository extends JpaRepository<Video, Integer> {

}
