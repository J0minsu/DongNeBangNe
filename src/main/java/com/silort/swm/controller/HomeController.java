package com.silort.swm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.silort.swm.model.MessengerText;
import com.silort.swm.repo.MessengerTextRepository;

@RestController
@RequestMapping(value = "/")
public class HomeController {

	static Logger logger = LoggerFactory.getLogger(HomeController.class);


	@Autowired
	private MessengerTextRepository repository;

	
	@GetMapping
	public ModelAndView homeController() {
		//he
		logger.debug("Calling root");
		ModelAndView view = new ModelAndView("test");
		view.addObject("text", "너는 까까머리~");
		return view;
	}
	
}