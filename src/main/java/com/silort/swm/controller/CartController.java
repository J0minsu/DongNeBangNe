package com.silort.swm.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.silort.swm.model.Cart;
import com.silort.swm.model.Order;
import com.silort.swm.model.User;
import com.silort.swm.repo.CartRepository;
import com.silort.swm.repo.OrderRepository;
import com.silort.swm.repo.UserRepository;

@RestController
@RequestMapping("api/carts")
public class CartController {

	static Logger logger = LoggerFactory.getLogger(CartController.class);

	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@GetMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cart> findCartByUserId(@PathVariable int userId) {
		// he
		logger.debug("Calling findCartByUserId( )");

		Cart cart = cartRepository.findCartById(userId);

		return new ResponseEntity<Cart>(cart, HttpStatus.OK);
	}

	@PostMapping(value = "/{userId}")
	public ResponseEntity<Void> postCart(@PathVariable int userId) {
		logger.debug("Calling postCart( )");

		Cart postCart = new Cart(userId, 0);
		
		cartRepository.save(postCart);
		
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@PostMapping(value = "/buying/{userId}")
	public ResponseEntity<Void> buyingCart(@PathVariable int userId) {
		
		logger.debug("Calling buyingCart( )");
		
		Cart buyingCart = cartRepository.findCartById(userId);
		User user = userRepository.findUserById(userId);
		
		user.setBalance(user.getBalance() - buyingCart.getPrice());
		
		userRepository.save(user);
		
		orderRepository.save(new Order(userId, buyingCart.getPrice(),
				buyingCart.getProduct01Id(), buyingCart.getProduct01Quantity(),
				buyingCart.getProduct02Id(), buyingCart.getProduct02Quantity()));
		
		
		resetCart(buyingCart);
		
		cartRepository.save(buyingCart);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
	
	@PostMapping(value = "carts/add/{userId}{productId}/{productQ}")
	public ResponseEntity<Void> addIteminCart(@RequestParam Map<Integer, String> parameters) {
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	private void resetCart(Cart cart) {
		cart.setPrice(0);
		cart.setProduct01Id(0);
		cart.setProduct01Quantity(0);
		cart.setProduct02Id(0);
		cart.setProduct02Quantity(0);
	}
}
