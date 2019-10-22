package com.silort.swm.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.silort.swm.model.Video;
import com.silort.swm.repo.VideoRepository;

@RestController
@RequestMapping("/api/videos")
public class VideoController {

	
	static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private VideoRepository videoRepository;
	
	@GetMapping
	public ResponseEntity<List<Video>> getVideos() {
	
		logger.debug("Call getVideos( )");
		List<Video> videos = videoRepository.findAll();
		
		return new ResponseEntity<List<Video>>(videos, HttpStatus.OK);
	}
	
	@GetMapping(value = "/user/{userId}")
	public ResponseEntity<List<Video>> getVideoByUploader(@PathVariable int userId) {
		
		logger.debug("Call getVideoByUploader( )");
		
		List<Video> videos = videoRepository.findVideosByUploaderId(userId);
		
		return new ResponseEntity<List<Video>>(videos, HttpStatus.OK);
	}
}
