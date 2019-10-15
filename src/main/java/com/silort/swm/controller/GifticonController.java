package com.silort.swm.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.silort.swm.model.Gifticon;
import com.silort.swm.repo.GifticonRepository;

@RestController
@RequestMapping("api/gifticons")
public class GifticonController {

	

	static Logger logger = LoggerFactory.getLogger(BroadcastController.class);
	
	@Autowired
	private GifticonRepository gifticonRepository;

	
	@GetMapping(value = "/user/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Gifticon>> findGifticonsByUser(@RequestParam int userId) {

		logger.debug("Calling findGifticonsByUser( )");
		
		List<Gifticon> gifticons = gifticonRepository.findGifticonsByUserId(userId);
		
		return new ResponseEntity<List<Gifticon>>(gifticons, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{gifticonId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Gifticon> findGifticonById(@RequestParam int gifticonId) {

		logger.debug("Calling findGifticonById( )");
		
		Gifticon gifticon = gifticonRepository.findGifticonById(gifticonId);
		
		return new ResponseEntity<Gifticon>(gifticon, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Gifticon> postGifticon(@RequestBody Gifticon gifticon) {
		logger.debug("Calling postGifticon( )");

		gifticon.setIsUsing(0);

		gifticonRepository.save(gifticon);
		
		return new ResponseEntity<Gifticon>(gifticon, HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Gifticon> usingGifticon(@RequestParam int gifticonId) {
		logger.debug("Calling usingGifticon");
		
		Gifticon gifticon = gifticonRepository.findGifticonById(gifticonId);
		
		if(gifticon.getIsUsing() == 1) {
			gifticon.setText("alreadyUsing");
			return new ResponseEntity<Gifticon>(gifticon, HttpStatus.BAD_REQUEST);
		}
		
		
		if((Period.between(gifticon.getIssueAt().plusMonths(3).toLocalDate(),
							LocalDateTime.now().toLocalDate()).getMonths() > 2)) {
			
			gifticon.setIsUsing(1);
			gifticon.setText("timeOver");
			gifticonRepository.save(gifticon);
			return new ResponseEntity<Gifticon>(gifticon, HttpStatus.BAD_REQUEST);
		}
		
		gifticon.setIsUsing(1);
		gifticon.setUsedAt(LocalDateTime.now());
		gifticon.setText("success");
		
		gifticonRepository.save(gifticon);
		
		return new ResponseEntity<Gifticon>(gifticon, HttpStatus.OK);
		
	}
	
	

	
}
