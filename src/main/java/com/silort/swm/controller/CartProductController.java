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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.silort.swm.model.Cart;
import com.silort.swm.model.CartProduct;
import com.silort.swm.repo.CartProductRepository;
import com.silort.swm.repo.CartRepository;

//@RestController
//@RequestMapping("api/cartProducts")
public class CartProductController {
//
//	static Logger logger = LoggerFactory.getLogger(CartProductController.class);
//
//	@Autowired
//	private CartProductRepository cartProductRepository;
//
//	@Autowired
//	private CartRepository cartRepository;
//
//	@GetMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<List<CartProduct>> findCartProductsByUserId(@PathVariable int userId) {
//		// he
//		logger.debug("Calling findCartProductsByUserId( )");
//
//		List<CartProduct> list = new ArrayList<CartProduct>();
//		Iterable<CartProduct> products = cartProductRepository.findCartProductByCartId(userId);
//		products.forEach(list::add);
//
//		return new ResponseEntity<List<CartProduct>>(list, HttpStatus.OK);
//	}
//
//	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Void> postCartProduct(@RequestParam CartProduct cartProduct) {
//		logger.debug("Calling postCartProduct( )");
//
//		CartProduct saveProduct = cartProductRepository.findCartProductByCartIdAndProductId(cartProduct.getCartId(),
//				cartProduct.getProductId());
//		if (saveProduct == null) {
//			saveProduct = new CartProduct(cartProduct.getProductId(), cartProduct.getCartId(),
//					cartProduct.getQuantity());
//		} else {
//			saveProduct.setQuantity(saveProduct.getQuantity() + cartProduct.getQuantity());
//		}
//
//		Cart cart = cartRepository.findCartById(cartProduct.getCartId());
//		cart.setPrice(cart.getPrice() + cartProduct.getQuantity() * cartProduct.getQuantity());
//
//		cartRepository.save(cart);
//		cartProductRepository.save(saveProduct);
//
//		return new ResponseEntity<Void>(HttpStatus.CREATED);
//	}
//	
}
