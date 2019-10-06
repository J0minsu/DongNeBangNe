package com.silort.swm.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.silort.swm.model.Broadcast;

public interface BroadcastRepository extends CrudRepository<Broadcast, Integer>  {

	List<Broadcast> findBroadcastByCategoryId(int categoryId);

	List<Broadcast> findBroadcastByBroadcastDateStartingWith(LocalDateTime yearMonthDay);
	
	Broadcast findById(int broadcastId);
}
