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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.silort.swm.model.Contract;
import com.silort.swm.model.Product;
import com.silort.swm.model.User;
import com.silort.swm.repo.ContractRepository;
import com.silort.swm.repo.ProductRepository;
import com.silort.swm.repo.UserRepository;

@RestController
@RequestMapping("/api/contracts")
public class ContractController {

	static Logger logger = LoggerFactory.getLogger(ContractController.class);

	@Autowired
	private ContractRepository contractRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping(value = "/{contractId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Contract> findContractById(@PathVariable int contractId) {

		logger.debug("Calling findUserById( )");
		Contract contract = contractRepository.findById(contractId);
		
		setContract(contract);
		
		return new ResponseEntity<Contract>(contract, HttpStatus.OK);
	}

	@GetMapping(value = "/influencer/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Contract>> findContractByInfluencerId(@PathVariable int userId) {
 
		logger.debug("Calling finContractdByInfluencerId( )");
		
		List<Contract> contracts = contractRepository.findByInfluencerId(userId);
		
		for(Contract contract : contracts) 
			setContract(contract);
			
		
		return new ResponseEntity<List<Contract>>(contracts, HttpStatus.OK);
	}
	
	@GetMapping(value = "/seller/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Contract>> findContractByProviderId(@PathVariable int userId) {
 
		logger.debug("Calling finContractdByProviderId( )");
		
		List<Contract> contracts = contractRepository.findByProviderId(userId);
		
		for(Contract contract : contracts) 
			setContract(contract);
		
		return new ResponseEntity<List<Contract>>(contracts, HttpStatus.OK);
	}
	
	@GetMapping(value = "/product/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Contract>> findContractByPrductId(@PathVariable int productId) {
 
		logger.debug("Calling finContractdByProductId( )");
		
		List<Contract> contracts = contractRepository.findByProductId(productId);

		for(Contract contract : contracts) 
			setContract(contract);
		
		return new ResponseEntity<List<Contract>>(contracts, HttpStatus.OK);
	}


	@PostMapping
	public ResponseEntity<Void> postContract(@RequestBody Contract contract) {
		logger.debug("Calling postContract( )");

		contract.setState(1);
		contractRepository.save(contract);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> updatetContract(@RequestBody Contract contract) {
		logger.debug("Calling updateContract( )");
		
		contractRepository.save(contract);

		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}


	@DeleteMapping(value = "/{contractId}")
	public ResponseEntity<Void> cancelContract(@PathVariable int contractId) {

		logger.debug("Calling cancelContract( )");
		
		Contract contract = contractRepository.findById(contractId);
		contract.setState(0);	//계약 무효 플래그
		contractRepository.save(contract);

		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	private void setContract(Contract contract) {
		contract.setProduct(productRepository.findById(contract.getProductId()));
		contract.setInfluencer(userRepository.findUserById(contract.getInfluencerId()));
		contract.setProvider(userRepository.findUserById(contract.getProviderId()));
	}
}
