package com.silort.swm.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.silort.swm.model.Broadcast;
import com.silort.swm.repo.BroadcastRepository;
import com.silort.swm.repo.ChannelRepository;
import com.silort.swm.repo.UserRepository;
import com.silort.swm.repo.VideoRepository;



@RestController
@RequestMapping("api/broadcasts")
public class BroadcastController {

	
	static Logger logger = LoggerFactory.getLogger(BroadcastController.class);

	@Autowired
	private BroadcastRepository broadcastRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ChannelRepository channelRepository;
	
	@Autowired
	private VideoRepository videoRepository;
	
	@GetMapping(value = "/{broadcastId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Broadcast> findBroadcastById(@PathVariable int broadcastId) {
		//he
		logger.debug("Calling findBroadcastById( )");
	
		Broadcast broadcast = broadcastRepository.findById(broadcastId);
		
		return new ResponseEntity<Broadcast>(broadcast, HttpStatus.OK);
	}

	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Broadcast>> findAllBroadcast() {

		logger.debug("Calling findAllBroadcast( )");
		List<Broadcast> list = broadcastRepository.findAll();
		
		List<Broadcast> sendList = new ArrayList<Broadcast>();
		
		for(int i = 0; i < 5; i++) {
			sendList.add(list.get(i));
		}
		
		return new ResponseEntity<List<Broadcast>>(list, HttpStatus.OK);
	}
	
	@GetMapping(value = "/number/{number}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Broadcast>> findNumberBroadcast(@PathVariable int number) {
		

		logger.debug("Calling findNumberBroadcast( )");
		List<Broadcast> list = broadcastRepository.findAll();
		
		List<Broadcast> sendList = new ArrayList<Broadcast>();
		
		if(number > list.size())	number = list.size();
		
		for(int i = 0; i < number; i++)	sendList.add(list.get(i));
		
		return new ResponseEntity<List<Broadcast>>(sendList, HttpStatus.OK);
	}
	
	@GetMapping(value = "/category/{categoryId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Broadcast>> findBroadcastsByCategory(@PathVariable int categoryId) {

		logger.debug("Calling findBroadcastByCategory( )");
		
		List<Broadcast> list = broadcastRepository.findBroadcastByCategoryId(categoryId);
		
		return new ResponseEntity<List<Broadcast>>(list, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/channel/{channelId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Broadcast>> findBroadcastsByChannel(@PathVariable int channelId) {

		logger.debug("Calling findBroadcastByCategory( )");
		
		List<Broadcast> list = broadcastRepository.findBroadcastByChannelId(channelId);
		
		return new ResponseEntity<List<Broadcast>>(list, HttpStatus.OK);
	}
	
	@GetMapping(value = "/schedules", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Broadcast>> findBroadcastsByDay(@RequestParam("year")int year, @RequestParam("month")int month, @RequestParam("day")int day) {

		logger.debug("Calling findBroadcastByDay( )");

		LocalDateTime startTime = LocalDateTime.of(LocalDate.of(year, month, day), LocalTime.of(0, 0, 0));

		LocalDateTime endTime = LocalDateTime.of(LocalDate.of(year, month, day), LocalTime.of(23, 59, 59));
		
		
		List<Broadcast> list = broadcastRepository.findBroadcastByBroadcastDateBetween(startTime, endTime);
				
		
		return new ResponseEntity<List<Broadcast>>(list, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Void> postBroadcast(@RequestBody Broadcast broadcast) 
	{
		logger.debug("Calling postBroadcast( )");

		int channelId = (Integer) broadcast.getChannelId();
		int productId = (Integer) broadcast.getProductId();
		int categoryId = (Integer) broadcast.getCategoryId();
		String title = broadcast.getTitle();
		LocalDateTime time = broadcast.getBroadcastDate();
		int broadcastState = 0;
		String thumdnailUrl = broadcast.getThumbnailUrl();
		String url = broadcast.getUrl();

		broadcastRepository.save(new Broadcast(channelId, productId, categoryId,title,
				time, broadcastState, thumdnailUrl, url));

		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	
	@PutMapping("/off/{broadcastId}")
	public ResponseEntity<Void> offBroadcast(@PathVariable int broadcastId) {
		
		logger.debug("Calling offBroadcast( )");

		Broadcast offBroadcast = broadcastRepository.findById(broadcastId);
		offBroadcast.setBroadcastState(2);
		
		broadcastRepository.save(offBroadcast);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Void> updateBroadcast(@RequestBody Broadcast broadcast) {
		
		logger.debug("Calling updateBroadcast( )");

		Broadcast beforeBroadcast = broadcastRepository.findById(broadcast.getId());
		
		beforeBroadcast.setBroadcastDate(broadcast.getBroadcastDate());
		beforeBroadcast.setThumbnailUrl(broadcast.getThumbnailUrl());
		beforeBroadcast.setTitle(broadcast.getTitle());
		
		broadcastRepository.save(beforeBroadcast);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PutMapping(value = "/on")
	public ResponseEntity<Void> onBroadcast(@RequestParam("broadcastId") int broadcastId, @RequestParam("url") String url, @RequestParam("mediaId") String mediaId) {
		
		logger.debug("Calling onBroadcast( )");

		Broadcast broadcast = broadcastRepository.findById(broadcastId);
		
		broadcast.setMediaId(mediaId);
		broadcast.setUrl(url);
		broadcast.setBroadcastState(1);
		
		broadcastRepository.save(broadcast);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	

	
	
}
