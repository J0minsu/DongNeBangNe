package com.silort.swm.controller;

import java.net.URI;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
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
import org.springframework.web.client.RestTemplate;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.silort.swm.model.Broadcast;
import com.silort.swm.model.Channel;
import com.silort.swm.model.User;
import com.silort.swm.repo.BroadcastRepository;
import com.silort.swm.repo.ChannelRepository;
import com.silort.swm.repo.UserRepository;



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
	
	@GetMapping(value = "/schedules", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Broadcast>> findBroadcastsByDay(@RequestParam("year")int year, @RequestParam("month")int month, @RequestParam("day")int day) {

		logger.debug("Calling findBroadcastByDay( )");
//		
//		int year = Integer.valueOf(y);
//		int month = Integer.valueOf(m);
//		int day = Integer.valueOf(d);
		
		LocalDate localDate = LocalDate.of(year, month, day);
		
		
		System.out.println("니나니뇨..!" + localDate);
		
		List<Broadcast> list = broadcastRepository.findBroadcastByBroadcastDateStartingWith(localDate);
		
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
	
	@PostMapping("/on/{broadcastId}")
	public ResponseEntity<String> onBroadcast(@RequestBody int broadcastId) {
		
		logger.debug("Calling onBroadcast( )");

		Broadcast onBroadcast = broadcastRepository.findById(broadcastId);
		onBroadcast.setBroadcastState(1);
		
		broadcastRepository.save(onBroadcast);
		
		RestTemplate restTemplate = new RestTemplate(); 
		HttpHeaders headers = new HttpHeaders();
		
		Channel channel = channelRepository.findById(onBroadcast.getChannelId());
		User user = userRepository.findUserById(channel.getUserId());
		
		headers.set("action", "start");
		headers.set("user", user.getName());
		headers.set("channel_id", String.format("%d", channel.getId()));
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity entity = new HttpEntity("parameters", headers);
		
		URI url = URI.create("https://1szpyu5xq7.execute-api.ap-northeast-2.amazonaws.com/media/bylive"); 


		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
		
		JsonParser parser = new JsonParser();
		
		//JsonArray array = (JsonArray)parser.parse(response.getBody());
		
		JsonObject object = (JsonObject)parser.parse(response.getBody());
		
		String broadcastUrl = object.get("source_url").getAsString();
		
		return new ResponseEntity<String>(broadcastUrl, HttpStatus.OK);
	}
	
	@PostMapping("/off/{broadcastId}")
	public ResponseEntity<Void> offBroadcast(@RequestBody int broadcastId) {
		
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
	

	
	
}
