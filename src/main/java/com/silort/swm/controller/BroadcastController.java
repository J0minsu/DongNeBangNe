package com.silort.swm.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.silort.swm.model.Broadcast;
import com.silort.swm.repo.BroadcastRepository;
import com.silort.swm.repo.UserRepository;

@RestController
@RequestMapping("api/broadcastings")
public class BroadcastController {

	
	static Logger logger = LoggerFactory.getLogger(ContractController.class);

	@Autowired
	private BroadcastRepository broadcastRepository;
	
	@Autowired
	private UserRepository userRepository;

	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Optional<Broadcast>> findBroadcastById(@PathVariable int broadcastId) {

		logger.debug("Calling findBroadcastById( )");
		Optional<Broadcast> broadcast = broadcastRepository.findById(broadcastId);
		
		return new ResponseEntity<Optional<Broadcast>>(broadcast, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{broadcastId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Optional<Broadcast>> findBroadcastById(@PathVariable int broadcastId) {

		logger.debug("Calling findBroadcastById( )");
		Optional<Broadcast> broadcast = broadcastRepository.findById(broadcastId);
		
		return new ResponseEntity<Optional<Broadcast>>(broadcast, HttpStatus.OK);
	}
}
