package com.silort.swm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.silort.swm.model.Messenger;
import com.silort.swm.model.MessengerText;
import com.silort.swm.model.Product;
import com.silort.swm.model.User;
import com.silort.swm.repo.MessengerRepository;
import com.silort.swm.repo.MessengerTextRepository;
import com.silort.swm.repo.ProductRepository;
import com.silort.swm.repo.UserRepository;

@RestController
@RequestMapping(value = "/")
public class HomeController {

	static Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private MessengerRepository messengerRepository;
	
	@Autowired
	private MessengerTextRepository messengerTextRepository;
	
	
	@GetMapping
	public ModelAndView homeController() {
		//he
		logger.debug("Calling root");
		User user1 = new User("msjo", "1234", 3);
		User user2 = new User("jwseo", "1234", 2);
		User user3 = new User("ymjeong", "1234", 1);
		
		Product product1 = new Product("구찌 신발", 30000, 30, "명품 신발", user1);
		Product product2 = new Product("하겐다즈 신발", 30000, 30, "명품 신발", user2);
		Product product3 = new Product("티볼리 신발", 30000, 30, "명품 신발", user3);
		
		Messenger messenger = new Messenger(user1, user2);
		
		MessengerText messengerText = new MessengerText(messenger, user1, "hello");
		
		userRepository.save(user1);
		userRepository.save(user2);
		userRepository.save(user3);

		productRepository.save(product1);
		productRepository.save(product2);
		productRepository.save(product3);
		
		messengerRepository.save(messenger);
		
		messengerTextRepository.save(messengerText);
		
		ModelAndView view = new ModelAndView("test");
		view.addObject("text", "너는 까까머리~");
		return view;
	}
	
}