package com.silort.swm.controller;

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

import com.silort.swm.model.Contract;
import com.silort.swm.model.User;
import com.silort.swm.repo.ContractRepository;
import com.silort.swm.repo.UserRepository;

@RestController
@RequestMapping("/api/contracts")
public class ContractController {

	static Logger logger = LoggerFactory.getLogger(ContractController.class);

	@Autowired
	private ContractRepository contractRepository;
	
	@Autowired
	private UserRepository userRepository;

	
	@GetMapping(value = "/{contractId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Contract> findContractById(@PathVariable int contractId) {

		logger.debug("Calling findUserById( )");
		Contract contract = contractRepository.findById(contractId);
		
		return new ResponseEntity<Contract>(contract, HttpStatus.OK);
	}

	@GetMapping(value = "/influencer/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Contract>> findContractByInfluencerId(@PathVariable String userId) {
 
		logger.debug("Calling findByRole( )");
		
		int influencerNo = userRepository.findNoById(userId);
		
		User influencer = userRepository.findUserByNo(influencerNo);
		
		List<Contract> contracts = contractRepository.findByInfluencer(influencer);
		
		return new ResponseEntity<List<Contract>>(contracts, HttpStatus.OK);
	}
	
	@GetMapping(value = "/seller/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Contract>> findContractBySellerId(@PathVariable String userId) {
 
		logger.debug("Calling findByRole( )");
		
		int sellerNo = userRepository.findNoById(userId);
		
		User seller = userRepository.findUserByNo(sellerNo);
		
		List<Contract> contracts = contractRepository.findByInfluencer(seller);
		
		return new ResponseEntity<List<Contract>>(contracts, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Void> postContract(@RequestBody Contract contract) {
		logger.debug("Calling postUser( )");

		//he
		int price = contract.getPrice();
		int times = contract.getTimes();
		int onePerTime = contract.getOnePerTime();
		String requirement = contract.getRequirement();
		User seller = contract.getSeller();
		User influencer = contract.getInfluencer();
		int state = contract.getState();
		

		contractRepository.save(
				new Contract(price, times, onePerTime, requirement, seller, influencer, state));

		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> updatetContract(@RequestBody Contract contract) {
		logger.debug("Calling putUser( )");
		
		contractRepository.save(contract);

		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}


	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> cancelContract(@PathVariable int id) {

		logger.debug("Calling deleteUser( )");
		
		Contract contract = contractRepository.findById(id);
		contract.setState(0);	//계약 무효 플래그
		contractRepository.save(contract);

		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
