package com.silort.swm.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.silort.swm.model.Cart;
import com.silort.swm.model.Order;
import com.silort.swm.model.Product;
import com.silort.swm.model.User;
import com.silort.swm.repo.CartRepository;
import com.silort.swm.repo.OrderRepository;
import com.silort.swm.repo.ProductRepository;
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

	@Autowired
	private ProductRepository productRepository;

	@GetMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cart> findCartByUserId(@PathVariable int userId) {
		// he
		logger.debug("Calling findCartByUserId( )");

		Cart cart = cartRepository.findCartById(userId);
		
		if(cart.getProduct01Id() != 0) {
			Product product01 = productRepository.findById(cart.getProduct01Id());
			cart.setProduct01(product01);
		}
		
		if(cart.getProduct02Id() != 0) {
			Product product02 = productRepository.findById(cart.getProduct02Id());
			cart.setProduct02(product02);
		}

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

		orderRepository.save(new Order(userId, buyingCart.getPrice(), buyingCart.getProduct01Id(),
				buyingCart.getProduct01Quantity(), buyingCart.getProduct02Id(), buyingCart.getProduct02Quantity()));

		resetCart(buyingCart);

		cartRepository.save(buyingCart);

		return new ResponseEntity<Void>(HttpStatus.OK);

	}

	@PostMapping(value = "/adding")
	public ResponseEntity<String> addIteminCart(@RequestParam List<String> parameters) {
		//[0] userId, [1] productId, [2] productQuantity

		int userId = Integer.parseInt(parameters.get(0));
		int productId = Integer.parseInt(parameters.get(1));
		int productQ = Integer.parseInt(parameters.get(2));
		
		Cart cart =cartRepository.findCartById(userId);
		Product product = productRepository.findById(productId);
		
		//testing ....
		String msg = "success";
		
		if(cart.getProduct01Id() == 0) {
			if(cart.getProduct02Id() == productId) {
				cart.setProduct02Quantity(cart.getProduct02Quantity() + productQ);
				cart.setPrice(cart.getPrice() + (product.getPrice() * productQ));
				
				return new ResponseEntity<String>(msg, HttpStatus.OK);
			}
			else {
				cart.setProduct01Id(productId);
				cart.setProduct01Quantity(productQ);
				cart.setPrice(cart.getPrice() + (product.getPrice() * productQ));
				cart.setProduct01(product);
				
				return new ResponseEntity<String>(msg, HttpStatus.OK);
			}
		}
		else if(cart.getProduct01Id() == productId) {
			cart.setProduct01Quantity(cart.getProduct01Quantity() + productQ);
			cart.setPrice(cart.getPrice() + (product.getPrice() * productQ));
			
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		}
		else {
			if(cart.getProduct02Id() == productId)	{
				cart.setProduct02Quantity(cart.getProduct02Quantity() + productQ);
				cart.setPrice(cart.getPrice() + (product.getPrice() * productQ));
				
				return new ResponseEntity<String>(msg, HttpStatus.OK);
			}
			else if(cart.getProduct02Id() == 0) {
				cart.setProduct02Id(productId);
				cart.setProduct02Quantity(productQ);
				cart.setPrice(cart.getPrice() + (product.getPrice() * productQ));
				
				return new ResponseEntity<String>(msg, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
			}
		}
	}

	@DeleteMapping(value = "/userId")
	public ResponseEntity<Void> clearCart(@PathVariable int userId) {

		Cart cart = cartRepository.findCartById(userId);
		resetCart(cart);

		cartRepository.save(cart);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	private void resetCart(Cart cart) {
		cart.setPrice(0);
		cart.setProduct01Id(0);
		cart.setProduct01Quantity(0);
		cart.setProduct02Id(0);
		cart.setProduct02Quantity(0);
		cart.setProduct01(null);
		cart.setProduct02(null);
	}
}
