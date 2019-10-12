package com.silort.swm.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.silort.swm.model.Event;

public interface EventRepository extends CrudRepository<Event, Integer> {

	
	List<Event> findEventsByUserId(int userId);
	
	Event findById(int eventId);
}
