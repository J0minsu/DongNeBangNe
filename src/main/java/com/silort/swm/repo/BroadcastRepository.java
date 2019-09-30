package com.silort.swm.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.silort.swm.model.Broadcast;

public interface BroadcastRepository extends CrudRepository<Broadcast, Integer>  {

	List<Broadcast> findBroadcastByCategoryId(int categoryId);

	@Query("from Broadcast b where lower(b.brod_date) and b.brod_date < ':yearMonthDay'")
	List<Broadcast> findBroadcastByDay(@Param("yearMonthDay")String yearMonthDay);
	
	Broadcast findById(int broadcastId);
}
