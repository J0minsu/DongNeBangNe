package com.silort.swm.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.silort.swm.model.Channel;
import com.silort.swm.model.Contract;
import com.silort.swm.model.NoticeBoard;
import com.silort.swm.model.User;
import com.silort.swm.model.Video;
import com.silort.swm.repo.ChannelRepository;
import com.silort.swm.repo.ContractRepository;
import com.silort.swm.repo.NoticeBoardRepository;
import com.silort.swm.repo.ShopRepository;
import com.silort.swm.repo.UserRepository;
import com.silort.swm.repo.VideoRepository;

@RestController
@RequestMapping(value = "/")
public class HomeController {

	static Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private ChannelRepository channelRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ContractRepository contractRepository;
	
	@Autowired
	private VideoRepository videoRepository;
	
	@Autowired
	private NoticeBoardRepository noticeBoardRepository;
	
	@Autowired
	private ShopRepository shopRepository;

	@GetMapping
	public ModelAndView homeController() {
		// he
		logger.debug("Calling root");

		ModelAndView view = new ModelAndView("home");

		return view;
	}

	@GetMapping(value = "recommendInfluencer")
	public ModelAndView recommendInfluencerController() {
		// he
		logger.debug("Calling recommendInfluencer page");

		ModelAndView view = new ModelAndView("recommendInfluencer");

		// 추천 서버의 알고리즘을 거쳐 influencer channel 정보 List type으로 가져온다.

		// ->
		// dummy
		List<Integer> recommendInfluencerList = new ArrayList<Integer>();
		recommendInfluencerList.add(1);
		recommendInfluencerList.add(2);
		// end dummy

		List<Channel> recommendChannel = new ArrayList<Channel>();

		for (int i : recommendInfluencerList) {
			Channel channel = channelRepository.findById(i);
			User user = userRepository.findUserById(channel.getUserId());
			List<Contract> contracts = contractRepository.findByInfluencerId(i);
			int totalContractFee = 0;

			if (contracts.size() != 0) {
				for (Contract contract : contracts)
					totalContractFee += contract.getPrice();
				
				channel.setAverageContractFee(totalContractFee / contracts.size());
				channel.setTotalContractNumber(contracts.size());
			}
			
			channel.setUserProfileImg(user.getProfileImage());

			recommendChannel.add(channelRepository.findById(i));
		}

		view.addObject("channels", recommendChannel);

		return view;
	}

	@GetMapping(value = "searchInfluencer")
	public ModelAndView searchInfluencerController() {
		// he
		logger.debug("Calling searchInfluencer page");

		ModelAndView view = new ModelAndView("searchInfluencer");
		view.addObject("text", "너는 까까머리~");
		return view;
	}

	@GetMapping(value = "employInfluencer")
	public ModelAndView employInfluencerController() {
		// he
		logger.debug("Calling employInfluencer page");

		ModelAndView view = new ModelAndView("employInfluencer");
		List<NoticeBoard> noticeBoards = noticeBoardRepository.findAll();
		
		for(NoticeBoard noticeBoard : noticeBoards)
			noticeBoard.setShop(shopRepository.findShopById(noticeBoard.getShopId()));
		
		view.addObject("noticeBoards", noticeBoards);
		
		return view;
	}

	@GetMapping(value = "contractDocument")
	public ModelAndView contractDocumentController() {
		// he
		logger.debug("Calling contractDocument page");

		ModelAndView view = new ModelAndView("contractDocument");
		view.addObject("text", "너는 까까머리~");
		return view;
	}

	@GetMapping(value = "contracting")
	public ModelAndView contractingController() {
		// he
		logger.debug("Calling contracting page");

		ModelAndView view = new ModelAndView("contracting");
		view.addObject("text", "너는 까까머리~");
		return view;
	}

	@GetMapping(value = "successContract")
	public ModelAndView successContractController() {
		// he
		logger.debug("Calling successContract page");

		ModelAndView view = new ModelAndView("successContract");
		view.addObject("text", "너는 까까머리~");
		return view;
	}

	@GetMapping(value = "endContract")
	public ModelAndView endContractController() {
		// he
		logger.debug("Calling endContract page");

		ModelAndView view = new ModelAndView("endContract");
		view.addObject("text", "너는 까까머리~");
		return view;
	}

	@GetMapping(value = "channel")
	public ModelAndView channelController(@RequestParam("influencerId") int influencerId) {
		logger.debug("Calling channel page");

		Channel channel = channelRepository.findByUserId(influencerId);
		User influencer = userRepository.findUserById(influencerId);
		Video video = videoRepository.findVideoById(channel.getRepresentVideo());
		influencer.setBalance(0);
		influencer.setPassword(null);

		channel.setUserProfileImg(influencer.getProfileImage());
		
		ModelAndView view = new ModelAndView("channel");
		view.addObject("channel", channel);
		view.addObject("influencer", influencer);
		view.addObject("video", video);
		return view;
	}

	@GetMapping(value = "shop")
	public ModelAndView shopController() {
		// he
		logger.debug("Calling shop page");

		ModelAndView view = new ModelAndView("shop");
		view.addObject("text", "너는 까까머리~");
		return view;
	}

	@GetMapping(value = "searchProvider")
	public ModelAndView searchProviderController() {
		// he
		logger.debug("Calling searchProvider page");

		ModelAndView view = new ModelAndView("searchProvider");
		view.addObject("text", "너는 까까머리~");
		return view;
	}

}