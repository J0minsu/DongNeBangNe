package com.silort.swm.controller;

import java.time.LocalDateTime;

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

import com.silort.swm.model.Broadcast;
import com.silort.swm.model.Cart;
import com.silort.swm.repo.BroadcastRepository;
import com.silort.swm.repo.CartRepository;
import com.silort.swm.repo.ChannelRepository;
import com.silort.swm.repo.UserRepository;

@RestController
@RequestMapping("api/carts")
public class CartController {


	static Logger logger = LoggerFactory.getLogger(CartController.class);

	@Autowired
	private CartRepository cartRepository;
	
	
	@GetMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cart> findCartByUserId(@PathVariable int userId) {
		//he
		logger.debug("Calling findCartByUserId( )");
	
		Cart cart = cartRepository.findCartByUserId(userId);
		
		return new ResponseEntity<Cart>(cart, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Void> postCart() 
	{
		logger.debug("Calling postBroadcast( )");

		Cart postCart = new Cart();
		postCart.setPrice(0);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
}
