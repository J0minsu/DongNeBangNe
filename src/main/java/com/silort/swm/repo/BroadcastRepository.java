package com.silort.swm.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.silort.swm.model.Broadcast;

public interface BroadcastRepository extends CrudRepository<Broadcast, Integer>  {

	List<Broadcast> findBroadcastByCategoryIdAndBroadcastState(int categoryId, int broadcastState);
	
	List<Broadcast> findBroadcastByChannelId(int channelId);

	List<Broadcast> findBroadcastByBroadcastDateBetween(LocalDateTime start, LocalDateTime end);
	
	List<Broadcast> findBroadcastByBroadcastState(int broadcastState);
	
	Broadcast findById(int broadcastId);
}
