package com.silort.swm.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.silort.swm.model.Broadcast;

public interface BroadcastRepository extends CrudRepository<Broadcast, Integer>  {

	List<Broadcast> findBroadcastByCategoryId(int categoryId);
	
	@Query("select * from Broadcast b where lower(b.brod_date) like '?%'1")
	List<Broadcast> findBroadcastByDay(int yearMonthDay);
	
	Broadcast findById(int broadcastId);
}
