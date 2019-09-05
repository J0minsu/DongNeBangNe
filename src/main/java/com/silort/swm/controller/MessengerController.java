package com.silort.swm.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.silort.swm.model.Messenger;
import com.silort.swm.model.User;
import com.silort.swm.repo.MessengerRepository;
import com.silort.swm.repo.MessengerTextRepository;
import com.silort.swm.repo.UserRepository;

@RestController
@RequestMapping(value = "/api/messengers")
public class MessengerController {

	static Logger logger = LoggerFactory.getLogger(MessengerController.class);

	@Autowired
	private MessengerRepository messengerRepository;

	@Autowired
	private MessengerTextRepository messengerTextRepository;

	@Autowired
	private UserRepository userRepository;

	@GetMapping(value = "/{messengerId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Messenger> findMessengerById(@PathVariable int messengerId) {

		logger.debug("Calling get Messenger By Id");

		Messenger messenger = messengerRepository.findById(messengerId);

		return new ResponseEntity<Messenger>(messenger, HttpStatus.OK);

	}

	@GetMapping(value = "/user/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Messenger>> findMessengerByUserId(@PathVariable String sellerId) {

		logger.debug("Calling get Product By Seller");

		List<Messenger> list = new ArrayList<>();

		// user1 search
		Iterable<Messenger> iterable = messengerRepository
				.findByUser1(userRepository.findUserByNo(userRepository.findNoById(sellerId)));

		// user2 search
		iterable.forEach(list::add);
		iterable = messengerRepository.findByUser2(userRepository.findUserByNo(userRepository.findNoById(sellerId)));
		iterable.forEach(list::add);

		return new ResponseEntity<List<Messenger>>(list, HttpStatus.OK);

	}

	@PostMapping
	public ResponseEntity<Void> postMessenger(@RequestBody Messenger messenger) {
		logger.debug("Calling postMessenger( )");

		messengerRepository.save(messenger);

		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/{messengerId}")
	public ResponseEntity<Void> deleteMessenger(@PathVariable int messengerId) {

		logger.debug("Calling deleteMessenger( )");
		messengerRepository.deleteById(messengerId);

		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping(value = "/user/{userId}")
	public ResponseEntity<Void> deleteMessngerByUser(@PathVariable String userId) {

		logger.debug("Calling deleteMessengerByUser( )");
		List<Messenger> list = new ArrayList<>();

		// user1 search
		Iterable<Messenger> iterable = messengerRepository
				.findByUser1(userRepository.findUserByNo(userRepository.findNoById(userId)));

		// user2 search
		iterable.forEach(list::add);
		iterable = messengerRepository.findByUser2(userRepository.findUserByNo(userRepository.findNoById(userId)));
		iterable.forEach(list::add);

		for (Messenger messenger : list) {
			messengerRepository.deleteById(messenger.getId());
		}

		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);

	}
	// TestTestTest

	@GetMapping(value = "/{sellerId}/{influencerId}")
	public ModelAndView createChatting(@PathVariable(value = "sellerId") String sellerId,
			@PathVariable(value = "influencerId") String influencerId) {
		//he
		User seller = userRepository.findUserByNo(userRepository.findNoById(sellerId));
		User influencer = userRepository.findUserByNo(userRepository.findNoById(influencerId));

		ModelAndView view = new ModelAndView("chatting");

		List<Messenger> list = new ArrayList<>();

		Iterable<Messenger> iterable = messengerRepository.findAll();

		iterable.forEach(list::add);

		boolean trigger = true;

		if (trigger) {
			for (Messenger messenger : list) {
				if (messenger.getUser1().equals(seller)) {
					if (messenger.getUser2().equals(influencer)) {
						view.addObject("messengerTexts", messengerTextRepository.findByMessenger(messenger));
						trigger = false;
					}
				}
			}
		}
		if (trigger) {
			Messenger messenger = new Messenger(seller, influencer);
			messengerRepository.save(messenger);
			view.addObject("messengerTexts", messengerTextRepository.findByMessenger(messenger));
		}

		return view;
	}
}
