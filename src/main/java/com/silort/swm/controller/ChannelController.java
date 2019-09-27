package com.silort.swm.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.silort.swm.model.Cart;
import com.silort.swm.model.CartProduct;
import com.silort.swm.model.Channel;
import com.silort.swm.repo.ChannelRepository;

@RestController
@RequestMapping("api/channel")
public class ChannelController {
	

	static Logger logger = LoggerFactory.getLogger(ChannelController.class);
	
	@Autowired
	private ChannelRepository channelRepository;
	
//	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<List<Channel>> findChannelByRecommandation() {
//		
//	}
	
	@GetMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Channel> findChannelByUserId(@PathVariable int userId) {
		// he
		logger.debug("Calling findChannelByUserId( )");

		Channel channel = channelRepository.findByUserId(userId);

		return new ResponseEntity<Channel>(channel, HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<Void> postChannel(@RequestBody Channel channel) {
		logger.debug("Calling postChannel( )");

		channelRepository.save(channel);
		
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Void> updateChannel(@RequestBody Channel channel) {
		
		Channel updateChannel = channelRepository.findByUserId(channel.getUserId());
		
		updateChannel.setCategoryId(channel.getCategoryId());
		updateChannel.setCity(channel.getCity());
		updateChannel.setCost(channel.getCost());
		updateChannel.setDescription(channel.getDescription());
		updateChannel.setDong(channel.getDong());
		updateChannel.setEngagementRating(channel.getEngagementRating());
		updateChannel.setFollowerNumber(channel.getFollowerNumber());
		updateChannel.setGu(channel.getGu());
		updateChannel.setRating(channel.getRating());
		
		channelRepository.save(updateChannel);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
