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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.silort.swm.model.Contract;
import com.silort.swm.model.ContractProduct;
import com.silort.swm.model.Product;
import com.silort.swm.repo.ContractProductRepository;
import com.silort.swm.repo.ContractRepository;
import com.silort.swm.repo.ProductRepository;

@RestController
@RequestMapping("/api/contractProducts")
public class ContractProductController {

	static Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private ContractProductRepository contractProductRepository;
	
	@Autowired
	private ContractRepository contractRepository;
	
	@Autowired
	private ProductRepository productRepository;


//	@GetMapping(value = "/contract/{contractId}", produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<List<ContractProduct>> findContractProductByContractId(@PathVariable int contractId) {
//
//		logger.debug("Calling getAll( )");
//		
//		Contract contract = contractRepository.findById(contractId);
//
//		List<ContractProduct> list = new ArrayList<>();
//		Iterable<ContractProduct> iterable = contractProductRepository.findByContract(contract);
//
//		iterable.forEach(list::add);
//
//		return new ResponseEntity<List<ContractProduct>>(list, HttpStatus.OK);
//	}
//
//	@GetMapping(value = "/product/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<List<ContractProduct>> findContractProductByProductId(@PathVariable int producttId) {
//
//		logger.debug("Calling getAll( )");
//		
//		Product product = productRepository.findById(producttId);
//		
//		List<ContractProduct> list = new ArrayList<>();
//		Iterable<ContractProduct> iterable = contractProductRepository.findByProduct(product);
//
//		iterable.forEach(list::add);
//
//		return new ResponseEntity<List<ContractProduct>>(list, HttpStatus.OK);
//	}
	
	@GetMapping(value = "/{contractProductId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ContractProduct> findContractById(@PathVariable int contractProductId) {

		logger.debug("Calling findUserById( )");
		
		ContractProduct contractProduct = contractProductRepository.findById(contractProductId);
		
		return new ResponseEntity<ContractProduct>(contractProduct, HttpStatus.OK);
	}
	//he
	@GetMapping(value = "/name/{productName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> getProductByName(@PathVariable String productName) {
		logger.debug("Calling get Product By Id");

		Product product = productRepository.findByName(productName);

		return new ResponseEntity<Product>(product, HttpStatus.OK);

	}

	@PostMapping
	public ResponseEntity<Void> postContractProduct(@RequestBody ContractProduct contractProduct) {
		logger.debug("Calling postUser( )");

		contractProductRepository.save(contractProduct);

		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Void> updateProduct(@RequestBody Product product) {
		logger.debug("Calling postProduct( )");

		productRepository.save(product);

		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable int id) {

		logger.debug("Calling deleteProduct( )");
		productRepository.deleteById(id);

		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}


}
