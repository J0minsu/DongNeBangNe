package com.silort.swm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value = "/")
public class HomeController {

	static Logger logger = LoggerFactory.getLogger(HomeController.class);


	
	@GetMapping
	public ModelAndView homeController() {
		//he
		logger.debug("Calling root");
		
		ModelAndView view = new ModelAndView("home");
		view.addObject("text", "너는 까까머리~");
		return view;
	}
	
}