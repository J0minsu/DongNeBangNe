package com.silort.swm.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping(value = "/number/{number}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Video>> findNumberVideos(@PathVariable int number) {
		

		logger.debug("Calling findNumberVideos( )");
		List<Video> list = videoRepository.findAll();
		
		List<Video> sendList = new ArrayList<Video>();
		
		if(number > list.size())	number = list.size();
		
		for(int i = 0; i < number; i++)	sendList.add(list.get(i));
		
		return new ResponseEntity<List<Video>>(sendList, HttpStatus.OK);
	}
	
	@GetMapping(value = "/user/{userId}")
	public ResponseEntity<List<Video>> getVideoByUploader(@PathVariable int userId) {
		
		logger.debug("Call getVideoByUploader( )");
		
		List<Video> videos = videoRepository.findVideosByUploaderId(userId);
		
		return new ResponseEntity<List<Video>>(videos, HttpStatus.OK);
	}
	
	@GetMapping(value = "/category/{categoryId}")
	public ResponseEntity<List<Video>> getVideoByCategory(@PathVariable int categoryId) {
		
		logger.debug("Call getVideoByCategory( )");
		
		List<Video> videos = videoRepository.findVideosByCategoryId(categoryId);
		
		return new ResponseEntity<List<Video>>(videos, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/product/{productId}")
	public ResponseEntity<List<Video>> getVideoByProduct(@PathVariable int productId) {
		
		logger.debug("Call getVideoByProduct( )");
		
		List<Video> videos = videoRepository.findVideosByProductId(productId);
		
		return new ResponseEntity<List<Video>>(videos, HttpStatus.OK);
	}
	
	
	
	@GetMapping(value = "/{videoId}")
	public ResponseEntity<Video> getVideoById(@PathVariable int videoId) {
		
		logger.debug("Call getVideoByvideoId( )");
		
		Video video = videoRepository.findVideoById(videoId);
		
		return new ResponseEntity<Video>(video, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Video> saveVideo(@RequestParam("productId") int productId, @RequestParam("name") String name, @RequestParam("uploaderId") int uploaderId, @RequestParam("url") String url, @RequestParam("categoryId") int categoryId, @RequestParam("description") String description, @RequestParam("thumbnailUrl") String thumbnailUrl) {
		
		Video video = new Video(productId, name, uploaderId, url, description, categoryId, thumbnailUrl);
		
		videoRepository.save(video);
		
		return new ResponseEntity<Video>(video, HttpStatus.OK);
	}
	
	
	
	
	

}
