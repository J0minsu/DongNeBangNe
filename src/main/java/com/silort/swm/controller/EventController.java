package com.silort.swm.controller;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.silort.swm.model.Event;
import com.silort.swm.repo.EventRepository;
import com.silort.swm.repo.ProductRepository;

@RestController
@RequestMapping("api/events")
public class EventController {

	static Logger logger = LoggerFactory.getLogger(CartController.class);

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private EventRepository eventRepository;

	@GetMapping(value = "user/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Event>> findEventsByUserId(@PathVariable int userId) {
		// he
		logger.debug("Calling findEventsByUserId( )");

		List<Event> events = eventRepository.findEventsByUserId(userId);
		
		return new ResponseEntity<List<Event>>(events, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{eventId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Event> findEventByEventId(@PathVariable int eventId) {
		// he
		logger.debug("Calling findEventByEventId( )");

		Event event = eventRepository.findEventByEventId(eventId);
		
		return new ResponseEntity<Event>(event, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Event> postEvent(@RequestBody Event event) {
		logger.debug("Calling postEvent( )");

		String eventString = event.toString();
		
		if(eventString.contains("null")) 
			return new ResponseEntity<Event>(event, HttpStatus.BAD_REQUEST);
		
		eventRepository.save(event);
		
		return new ResponseEntity<Event>(event, HttpStatus.CREATED);
	}
	
	@PutMapping("{eventId}")
	public ResponseEntity<Event> updateEvent(@RequestBody Event event) {
		logger.debug("Calling updateEvent( )");
		
		eventRepository.save(event);
		
		return new ResponseEntity<Event>(event, HttpStatus.OK);
		
	}
	
	
	
}
