package com.silort.swm.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.silort.swm.model.Channel;
import com.silort.swm.model.Contract;
import com.silort.swm.model.NoticeBoard;
import com.silort.swm.model.Product;
import com.silort.swm.model.Reco;
import com.silort.swm.model.Shop;
import com.silort.swm.model.User;
import com.silort.swm.model.Video;
import com.silort.swm.repo.ChannelRepository;
import com.silort.swm.repo.ContractRepository;
import com.silort.swm.repo.NoticeBoardRepository;
import com.silort.swm.repo.ProductRepository;
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

	@Autowired
	private ProductRepository productRepository;

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
		List<Channel> recommendChannel = new ArrayList<Channel>();
		// 추천 서버의 알고리즘을 거쳐 influencer channel 정보 List type으로 가져온다.
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://15.164.16.139:5000/recommend/info-based/3";

		HttpEntity<List<Integer>> entity = new HttpEntity<>(null);

		HttpEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

		JsonParser parser = new JsonParser();
		JsonObject object = (JsonObject) parser.parse(response.getBody());
		JsonArray jsonArray = (JsonArray) object.get("recommendations");

		for (int i = 0; i < jsonArray.size(); i++) {
			int totalContractFee = 0;
			Channel recoChannel = channelRepository.findById(jsonArray.get(i).getAsInt());
			User user = userRepository.findUserById(recoChannel.getUserId());
			List<Contract> contracts = contractRepository.findByInfluencerId(user.getId());

			if (contracts.size() != 0) {
				for (Contract contract : contracts)
					totalContractFee += contract.getPrice();

				recoChannel.setAverageContractFee(totalContractFee / contracts.size());
				recoChannel.setTotalContractNumber(contracts.size());
			}

			recoChannel.setUserProfileImg(user.getProfileImage());

			recommendChannel.add(recoChannel);
		}

		view.addObject("channels", recommendChannel);

		return view;
	}

	@GetMapping(value = "searchInfluencer")
	public ModelAndView searchInfluencerController() {
		// he
		logger.debug("Calling searchInfluencer page");

		ModelAndView view = new ModelAndView("searchInfluencer");

		return view;
	}

	@GetMapping(value = "employInfluencer")
	public ModelAndView employInfluencerController() {
		// he
		logger.debug("Calling employInfluencer page");

		ModelAndView view = new ModelAndView("employInfluencer");
		List<NoticeBoard> noticeBoards = noticeBoardRepository.findAll();

		for (NoticeBoard noticeBoard : noticeBoards)
			noticeBoard.setShop(shopRepository.findShopById(noticeBoard.getShopId()));

		view.addObject("noticeBoards", noticeBoards);

		return view;
	}

	@GetMapping(value = "createDocument")
	public ModelAndView createDocument(@RequestParam("influencerId") int influencerId,
			@RequestParam("providerId") int providerId) {
		// he
		logger.debug("Calling createDocument page");

		ModelAndView view = new ModelAndView("createDocument");

		Contract contract = new Contract();

		Channel channel = channelRepository.findByUserId(influencerId);
		channel.setUserProfileImg(userRepository.findUserById(influencerId).getProfileImage());

		User provider = userRepository.findUserById(providerId);

		User influencer = userRepository.findUserById(influencerId);

		contract.setChannel(channel);
		contract.setProvider(provider);
		contract.setProviderId(providerId);
		contract.setInfluencer(influencer);
		contract.setInfluencerId(influencerId);

		String what = "create";

		view.addObject("what", what);
		view.addObject("contract", contract);

		System.out.println(view.toString());

		return view;
	}

	@GetMapping(value = "contractDocument")
	public ModelAndView contractDocumentController(@RequestParam("contractId") int contractId,
			@RequestParam("state") String state) {
		// he
		logger.debug("Calling contractDocument.GET page");

		ModelAndView view = new ModelAndView("contractDocument");

		Contract contract = contractRepository.findById(contractId);

		contract.setChannel(channelRepository.findByUserId(contract.getInfluencerId()));
		contract.setProvider(userRepository.findUserById(contract.getProviderId()));
		contract.setInfluencer(userRepository.findUserById(contract.getInfluencerId()));

		String what = state;

		view.addObject("what", what);
		view.addObject("contract", contract);

		System.out.println("get : contractDocument 로그 분석  " + contract + "이것은 what의 내용 : " + what);

		return view;
	}

	@PostMapping(value = "contractDocument", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ModelAndView contractDocument(Contract contract) {
		// he
		logger.debug("Calling contractDocument.POST page");

		System.out.println("로그검사야 ㅇ이이" + contract);

		if (contract.getState() >= 0 && contract.getState() < 3)
			contract.setState(contract.getState() + 1);

		else
			return null;

		System.out.println("이것은 저장 후 컨트랙트의 상태 = " + contract);

		contractRepository.save(contract);
		String viewName = "";
		List<Contract> contracts = null;
		switch (contract.getState()) {
		case 1:
			viewName = "contracting";
			contracts = contractRepository.findByStateAndProviderId(1, contract.getProviderId());
			break;
		case 2:
			viewName = "successContract";
			contracts = contractRepository.findByStateAndProviderId(2, contract.getProviderId());
			break;
		case 3:
			viewName = "endContract";
			contracts = contractRepository.findByStateAndProviderId(3, contract.getProviderId());
			break;
		default:
			break;
		}

		setContract(contracts);

		ModelAndView view = new ModelAndView(viewName);

		contract.setChannel(channelRepository.findByUserId(contract.getInfluencerId()));
		contract.setProvider(userRepository.findUserById(contract.getProviderId()));
		contract.setInfluencer(userRepository.findUserById(contract.getInfluencerId()));

		view.addObject("contracts", contracts);

		return view;
	}

	@GetMapping(value = "contracting")
	public ModelAndView contractingController(@RequestParam("providerId") int providerId) {
		// he
		logger.debug("Calling contracting page");

		ModelAndView view = new ModelAndView("contracting");

		List<Contract> contracts = contractRepository.findByStateAndProviderId(1, providerId);

		setContract(contracts);

		view.addObject("contracts", contracts);
		return view;
	}

	@GetMapping("/deleteContract")
	public ModelAndView deleteContract(@RequestParam("contractId") int contractId) {

		logger.debug("Calling deleteContract page");

		ModelAndView view = new ModelAndView("deleteContract");

		Contract contract = contractRepository.findById(contractId);

		contractRepository.delete(contract);

		if (contract.getState() != 1) {
			return null;
		} else {

			List<Contract> contracts = contractRepository.findByStateAndProviderId(1, contract.getProviderId());
			setContract(contracts);

			view.addObject("contracts", contracts);

			return view;
		}
	}

	@GetMapping(value = "successContract")
	public ModelAndView successContractController(@RequestParam("providerId") int providerId) {
		// he
		logger.debug("Calling successContract page");

		ModelAndView view = new ModelAndView("successContract");
		List<Contract> contracts = contractRepository.findByStateAndProviderId(2, providerId);

		setContract(contracts);

		view.addObject("contracts", contracts);
		return view;
	}

	@GetMapping(value = "endContract")
	public ModelAndView endContractController(@RequestParam("providerId") int providerId) {
		// he
		logger.debug("Calling endContract page");

		ModelAndView view = new ModelAndView("endContract");
		List<Contract> contracts = contractRepository.findByStateAndProviderId(3, providerId);

		setContract(contracts);

		view.addObject("contracts", contracts);
		return view;
	}

	@GetMapping(value = "channel")
	public ModelAndView channelController(@RequestParam("influencerId") int influencerId) {
		logger.debug("Calling channel page");

		ModelAndView view = new ModelAndView("channel");
		Channel channel = channelRepository.findByUserId(influencerId);
		User influencer = userRepository.findUserById(influencerId);
		Video video = videoRepository.findVideoById(channel.getRepresentVideo());

		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<List<Integer>> entity = new HttpEntity<>(null);
		HttpEntity<String> response;
		JsonParser parser = new JsonParser();
		JsonObject object;
		JsonArray jsonArray;

		String url = "";
		influencer.setBalance(0);
		influencer.setPassword(null);

		channel.setUserProfileImg(influencer.getProfileImage());

		List<Reco> recos = new ArrayList<Reco>();

		// :5000//report/channel-report/{ch_id}/{shop_id} 그래프 내용 채워넣기
		url = "http://15.164.16.139:5000/report/channel-report/" + channel.getId() + "/3";
		System.out.println("추천 API 에 들어가는 URL 은? " + url);
		response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

		object = (JsonObject) parser.parse(response.getBody());

		// ---
		jsonArray = (JsonArray) object.get("gender");

		for (int i = 0; i < jsonArray.size(); i++) {
			String text = String.format("gender%d", i + 1);
			view.addObject(text, jsonArray.get(i).getAsInt());
		}
		// ---/

		// ---
		jsonArray = (JsonArray) object.get("age");

		for (int i = 0; i < jsonArray.size(); i++) {
			String text = String.format("age%d", i + 1);
			view.addObject(text, jsonArray.get(i).getAsInt());
		}
		// ---/

		// ---
		jsonArray = (JsonArray) object.get("rating");

		for (int i = 0; i < jsonArray.size(); i++) {
			String text = String.format("rating%d", i + 1);
			view.addObject(text, jsonArray.get(i).getAsFloat());
		}
		// ---/

		// ---
		jsonArray = (JsonArray) object.get("category_cnt");

		for (int i = 0; i < jsonArray.size(); i++) {
			String text = String.format("cnt%d", i + 1);
			view.addObject(text, jsonArray.get(i).getAsInt());
		}
		// ---/

		// ---
		jsonArray = (JsonArray) object.get("view");

		for (int i = 0; i < jsonArray.size(); i++) {
			String text = String.format("view%d", i + 1);
			view.addObject(text, jsonArray.get(i).getAsInt());
		}
		// ---/

		// ---
		jsonArray = (JsonArray) object.get("chat");

		for (int i = 0; i < jsonArray.size(); i++) {
			String text = String.format("chat%d", i + 1);
			view.addObject(text, jsonArray.get(i).getAsInt());
		}
		// ---/

		// ---
		jsonArray = (JsonArray) object.get("buy");

		for (int i = 0; i < jsonArray.size(); i++) {
			String text = String.format("buy%d", i + 1);
			view.addObject(text, jsonArray.get(i).getAsInt());
		}
		// ---/

		// ---
		jsonArray = (JsonArray) object.get("er");

		for (int i = 0; i < jsonArray.size(); i++) {
			String text = String.format("er%d", i + 1);
			view.addObject(text, jsonArray.get(i).getAsInt());
		}
		// ---/
		
		view.addObject("category", object.get("category"));

		// :5000/recommend/info-based/{provider_user_id} 인플루언서 추천 파트
		url = "http://15.164.16.139:5000/recommend/info-based/3";

		response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

		object = (JsonObject) parser.parse(response.getBody());
		jsonArray = (JsonArray) object.get("recommendations");

		for (int i = 0; i < jsonArray.size(); i++) {
			Channel recoChannel = channelRepository.findById(jsonArray.get(i).getAsInt());

			User recoUser = userRepository.findUserById(recoChannel.getUserId());

			if (recoUser == null) {

				recoUser = new User();
				recoUser.setId(49);
				recoUser.setProfileImage("a");

			}
			Reco reco = new Reco(recoUser.getId(), recoUser.getProfileImage());
			recos.add(reco);
		}

		view.addObject("recos", recos);
		view.addObject("channel", channel);
		view.addObject("influencer", influencer);
		view.addObject("video", video);
		return view;
	}

	@GetMapping(value = "shop")
	public ModelAndView shopController(@RequestParam("shopId") int shopId) {
		// he
		logger.debug("Calling shop page");

		ModelAndView view = new ModelAndView("shop");
		Shop shop = shopRepository.findShopById(shopId);
		List<Product> products = productRepository.findByProviderId(shop.getProviderId());

		List<String> productImages = new ArrayList<String>();

		List<Video> videos = new ArrayList<Video>();

		for (Product product : products) {
			Video getVideo = videoRepository.findVideosByProductId(product.getId()).get(0);

			videos.add(getVideo);

			StringTokenizer tokenizer = new StringTokenizer(product.getImageUrl(), "**");

			while (tokenizer.hasMoreTokens())
				productImages.add(tokenizer.nextToken());

		}

		System.out.println(productImages);

		view.addObject("productImages", productImages);
		view.addObject("videos", videos);
		view.addObject("shop", shop);
		return view;
	}

	@GetMapping(value = "searchProvider")
	public ModelAndView searchProviderController() {
		// he
		logger.debug("Calling searchProvider page");

		ModelAndView view = new ModelAndView("searchProvider");

		List<Shop> shops = shopRepository.findShopsByCity("서울시");

		view.addObject("shops", shops);

		view.addObject("text", "너는 까까머리~");
		return view;
	}

	private List<Contract> setContract(List<Contract> contracts) {

		if (contracts.size() != 0) {
			for (Contract contract : contracts) {
				Channel channel = channelRepository.findByUserId(contract.getInfluencerId());
				channel.setUserProfileImg(userRepository.findUserById(channel.getUserId()).getProfileImage());
				contract.setChannel(channel);
				contract.setInfluencer(userRepository.findUserById(contract.getInfluencerId()));
			}
		}
		return contracts;
	}

}