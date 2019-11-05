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
	
	@GetMapping(value = "recommendInfluencer")
	public ModelAndView recommendInfluencerController() {
		//he
		logger.debug("Calling recommendInfluencer page");
		
		ModelAndView view = new ModelAndView("recommendInfluencer");
		view.addObject("text", "너는 까까머리~");
		return view;
	}
	
	@GetMapping(value = "searchInfluencer")
	public ModelAndView searchInfluencerController() {
		//he
		logger.debug("Calling searchInfluencer page");
		
		ModelAndView view = new ModelAndView("searchInfluencer");
		view.addObject("text", "너는 까까머리~");
		return view;
	}
	
	@GetMapping(value = "employInfluencer")
	public ModelAndView employInfluencerController() {
		//he
		logger.debug("Calling employInfluencer page");
		
		ModelAndView view = new ModelAndView("employInfluencer");
		view.addObject("text", "너는 까까머리~");
		return view;
	}
	
	@GetMapping(value = "contractDocument")
	public ModelAndView contractDocumentController() {
		//he
		logger.debug("Calling contractDocument page");
		
		ModelAndView view = new ModelAndView("contractDocument");
		view.addObject("text", "너는 까까머리~");
		return view;
	}
	
	@GetMapping(value = "contracting")
	public ModelAndView contractingController() {
		//he
		logger.debug("Calling contracting page");
		
		ModelAndView view = new ModelAndView("contracting");
		view.addObject("text", "너는 까까머리~");
		return view;
	}
	
	@GetMapping(value = "successContract")
	public ModelAndView successContractController() {
		//he
		logger.debug("Calling successContract page");
		
		ModelAndView view = new ModelAndView("successContract");
		view.addObject("text", "너는 까까머리~");
		return view;
	}	
	
	@GetMapping(value = "endContract")
	public ModelAndView endContractController() {
		//he
		logger.debug("Calling endContract page");
		
		ModelAndView view = new ModelAndView("endContract");
		view.addObject("text", "너는 까까머리~");
		return view;
	}	
	
	@GetMapping(value = "channel")
	public ModelAndView channelController() {
		//he
		logger.debug("Calling channel page");
		
		ModelAndView view = new ModelAndView("channel");
		view.addObject("text", "너는 까까머리~");
		return view;
	}	
	
	@GetMapping(value = "shop")
	public ModelAndView shopController() {
		//he
		logger.debug("Calling shop page");
		
		ModelAndView view = new ModelAndView("shop");
		view.addObject("text", "너는 까까머리~");
		return view;
	}	
	
	@GetMapping(value = "searchProvider")
	public ModelAndView searchProviderController() {
		//he
		logger.debug("Calling searchProvider page");
		
		ModelAndView view = new ModelAndView("searchProvider");
		view.addObject("text", "너는 까까머리~");
		return view;
	}
	
}