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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.silort.swm.model.Messenger;
import com.silort.swm.model.MessengerText;
import com.silort.swm.repo.MessengerRepository;
import com.silort.swm.repo.MessengerTextRepository;

@RestController
@RequestMapping(value = "/api/messengers/text")
public class MessengerTextController {
	
	static Logger logger = LoggerFactory.getLogger(MessengerController.class);

	@Autowired
	private MessengerTextRepository messengerTextRepository;
	

	@Autowired
	private MessengerRepository messengerRepository;


	@GetMapping(value = "/{messengerId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<MessengerText>> findMessengerTextsById(@PathVariable int messengerId) {
		//he
		logger.debug("Calling get Messenger By Id");

		//해당 messenger 정보 가져온다.
		Messenger messenger = messengerRepository.findById(messengerId);
		
		//client에 넘겨줄 text들을 저장할 리스트 생성.
		List<MessengerText> list = new ArrayList<MessengerText>();
		
		//DB에서 텍스트들을 모조리 가져온다.
		Iterable<MessengerText> texts = messengerTextRepository.findByMessenger(messenger);
		
		//client에 넘겨줄 리스트에 값을 대입한다.
		texts.forEach(list::add);
		
		return new ResponseEntity<List<MessengerText>>(list, HttpStatus.OK);

	}

	@PostMapping
	public ResponseEntity<Void> postMessengerText(@RequestBody MessengerText messengerText) {
		logger.debug("Calling postMessenger( )");

		messengerTextRepository.save(messengerText);

		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

}
