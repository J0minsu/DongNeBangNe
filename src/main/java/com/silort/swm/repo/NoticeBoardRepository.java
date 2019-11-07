package com.silort.swm.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.silort.swm.model.NoticeBoard;

public interface NoticeBoardRepository extends CrudRepository<NoticeBoard, Integer> {

	NoticeBoard findById(int id);
	
	List<NoticeBoard> findAll();
	
}
