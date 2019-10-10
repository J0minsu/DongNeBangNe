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
	public ResponseEntity<Cart> postCart(@PathVariable int userId) {
		logger.debug("Calling postCart( )");

		Cart postCart = new Cart(userId, 0);
		setProduct(postCart);
		cartRepository.save(postCart);

		return new ResponseEntity<Cart>(postCart, HttpStatus.CREATED);
	}

	@PostMapping(value = "/buying/{userId}")
	public ResponseEntity<Order> buyingCart(@PathVariable int userId) {

		logger.debug("Calling buyingCart( )");

		Cart buyingCart = cartRepository.findCartById(userId);
		User user = userRepository.findUserById(userId);

		user.setBalance(user.getBalance() - buyingCart.getPrice());

		userRepository.save(user);
		System.out.println("user info refresh");
		
		Order order = new Order(userId, buyingCart.getPrice(), buyingCart.getProduct01Id(),
				buyingCart.getProduct01Quantity(), buyingCart.getProduct02Id(), buyingCart.getProduct02Quantity());

		order.setProduct01(buyingCart.getProduct01());
		order.setProduct02(buyingCart.getProduct02());
		orderRepository.save(order);
		
		System.out.println("order making");
		resetCart(buyingCart);

		System.out.println("cart init");
		cartRepository.save(buyingCart);
		System.out.println("end cart init");
		return new ResponseEntity<Order>(order,HttpStatus.OK);

	}

	@PostMapping(value = "/adding")
	public ResponseEntity<Cart> addIteminCart(@RequestParam List<String> parameters) {
		//[0] userId, [1] productId, [2] productQuantity

		int userId = Integer.parseInt(parameters.get(0));
		int productId = Integer.parseInt(parameters.get(1));
		int productQ = Integer.parseInt(parameters.get(2));
		
		Cart cart =cartRepository.findCartById(userId);
		Product product = productRepository.findById(productId);
		
		if(cart.getProduct01Id() == 0) {
			if(cart.getProduct02Id() == productId) {
				cart.setProduct02Quantity(cart.getProduct02Quantity() + productQ);
				cart.setPrice(cart.getPrice() + (product.getPrice() * productQ));
				System.out.println("I'm 01 = empty, 02 = productId");
				setProduct(cart);
				cartRepository.save(cart);
				return new ResponseEntity<Cart>(cart, HttpStatus.OK);
			}
			else {
				cart.setProduct01Id(productId);
				cart.setProduct01Quantity(productQ);
				cart.setPrice(cart.getPrice() + (product.getPrice() * productQ));
				cart.setProduct01(product);
				System.out.println("I'm 01 = empty, 02 != productId");
				setProduct(cart);
				cartRepository.save(cart);
				return new ResponseEntity<Cart>(cart, HttpStatus.OK);
			}
		}
		else if(cart.getProduct01Id() == productId) {
			cart.setProduct01Quantity(cart.getProduct01Quantity() + productQ);
			cart.setPrice(cart.getPrice() + (product.getPrice() * productQ));
			System.out.println("I'm 01 = productId");
			setProduct(cart);
			cartRepository.save(cart);
			return new ResponseEntity<Cart>(cart, HttpStatus.OK);
		}
		else {
			if(cart.getProduct02Id() == productId)	{
				cart.setProduct02Quantity(cart.getProduct02Quantity() + productQ);
				cart.setPrice(cart.getPrice() + (product.getPrice() * productQ));
				System.out.println("I'm 01 = full, 02 = productId");
				setProduct(cart);
				cartRepository.save(cart);
				return new ResponseEntity<Cart>(cart, HttpStatus.OK);
			}
			else if(cart.getProduct02Id() == 0) {
				cart.setProduct02Id(productId);
				cart.setProduct02Quantity(productQ);
				cart.setPrice(cart.getPrice() + (product.getPrice() * productQ));
				System.out.println("I'm 01 = full, 02 = empty");
				setProduct(cart);
				cartRepository.save(cart);
				return new ResponseEntity<Cart>(cart, HttpStatus.OK);
			}
			else {
				System.out.println("I'm 01 = full, 02 = full");
				setProduct(cart);
				cartRepository.save(cart);
				return new ResponseEntity<Cart>(cart, HttpStatus.BAD_REQUEST);
			}
		}
	}

	@DeleteMapping(value = "/{userId}")
	public ResponseEntity<Cart> clearCart(@PathVariable int userId) {

		Cart cart = cartRepository.findCartById(userId);
		resetCart(cart);

		cartRepository.save(cart);
		return new ResponseEntity<Cart>(cart, HttpStatus.OK);
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
	
	private void setProduct(Cart cart) {
		cart.setProduct01(productRepository.findById(cart.getProduct01Id()));
		cart.setProduct02(productRepository.findById(cart.getProduct02Id()));
	}
}
