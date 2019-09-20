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

import com.silort.swm.model.User;
import com.silort.swm.repo.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {

	static Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserRepository repository;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> getAllUser() {

		logger.debug("Calling getAll( )");

		List<User> list = new ArrayList<>();
		Iterable<User> users = repository.findAll();

		users.forEach(list::add);

		return new ResponseEntity<List<User>>(list, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> findUserById(@PathVariable int userId) {
		//he
		logger.debug("Calling findUserById( )");
		
		User user = repository.findUserById(userId);

		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@GetMapping(value = "/role/{role}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> findUserByRole(@PathVariable int role) {
 
		logger.debug("Calling findByRole( )");

		List<User> users = repository.findByRole(role);
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
//
//	@PostMapping
//	public ResponseEntity<Void> postUser(@RequestBody User user) {
//		logger.debug("Calling postUser( )");
//
//		String id = user.getId();
//		String password = user.getPassword();
//		int role = (Integer) user.getRole();
//
//		repository.save(new User(id, password, role));
//
//		return new ResponseEntity<Void>(HttpStatus.CREATED);
//	}
//	
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> updatetUser(@RequestBody User user) {
		logger.debug("Calling putUser( )");
		
		repository.save(user);

		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}


//	@DeleteMapping(value = "/{id}")
//	public ResponseEntity<Void> deleteUser(@PathVariable String id) {
//
//		logger.debug("Calling deleteUser( )");
//		repository.deleteById(repository.findNoById(id));//Delete가 실제로 아닌 개인정보만 삭제..! 로그인 불가하게! 플래그!
//
//		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
//	}
}