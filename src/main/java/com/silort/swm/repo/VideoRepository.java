package com.silort.swm.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.silort.swm.model.Video;

public interface VideoRepository extends CrudRepository<Video, Integer> {

	
	List<Video> findAll();
	
	List<Video> findVideosByUploaderId(int userId);
}
