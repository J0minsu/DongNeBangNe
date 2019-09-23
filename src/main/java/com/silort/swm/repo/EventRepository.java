package com.silort.swm.repo;

import org.springframework.data.repository.CrudRepository;

import com.silort.swm.model.Event;

public interface EventRepository extends CrudRepository<Event, Integer> {

}
