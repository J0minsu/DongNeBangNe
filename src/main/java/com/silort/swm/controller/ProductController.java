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

import com.silort.swm.model.Product;
import com.silort.swm.repo.ProductRepository;
import com.silort.swm.repo.UserRepository;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	static Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private UserRepository userRepository;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Product>> getAll() {

		logger.debug("Calling getAll( )");

		List<Product> list = new ArrayList<>();
		Iterable<Product> iterable = productRepository.findAll();

		iterable.forEach(list::add);

		return new ResponseEntity<List<Product>>(list, HttpStatus.OK);

	}

	@GetMapping(value = "/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> getProduct(@PathVariable int productId) {

		logger.debug("Calling get Product By Id");

		Product product = productRepository.findById(productId);

		return new ResponseEntity<Product>(product, HttpStatus.OK);

	}

	@GetMapping(value = "/name/{productName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> getProductByName(@PathVariable String productName) {
		logger.debug("Calling get Product By Id");

		Product product = productRepository.findByName(productName);

		return new ResponseEntity<Product>(product, HttpStatus.OK);

	}

	// testing 중 User 관련 오류 발생시 String type 고려
	@GetMapping(value = "/provider/{providerId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Product>> getSellerProduct(@PathVariable int providerId) {

		logger.debug("Calling getSellerProduct");

		List<Product> list = productRepository.findByProviderId(providerId);

		return new ResponseEntity<List<Product>>(list, HttpStatus.OK);

	}
	//he
	@PostMapping
	public ResponseEntity<Void> postProduct(@RequestBody Product product) {
		logger.debug("Calling postUser( )");

		productRepository.save(product);

		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Void> updateProduct(@RequestBody Product product) {
		logger.debug("Calling postProduct( )");

		productRepository.save(product);

		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

//	@DeleteMapping(value = "/{id}")
//	public ResponseEntity<Void> deleteProduct(@PathVariable int id) {
//
//		logger.debug("Calling deleteProduct( )");
//		Product product = productRepository.findById(id);
//		//product.setSeller(null);
//		productRepository.deleteById(id);
//
//		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
//	}

}