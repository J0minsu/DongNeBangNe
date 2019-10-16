package com.silort.swm.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.silort.swm.model.Shop;
import com.silort.swm.repo.ShopRepository;
import com.silort.swm.repo.UserRepository;

@RestController
@RequestMapping("api/shop")
public class ShopController {

	
	static Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private ShopRepository shopRepository;
	
	@Autowired
	private UserRepository userRepostiroy;
	
	@GetMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Shop> findShopByUserId(@PathVariable int userId) {
		// he
		logger.debug("Calling findShopByUserId( )");

		Shop shop = shopRepository.findShopByProviderId(userId);
		shop.setProvider(userRepostiroy.findUserById(userId));

		return new ResponseEntity<Shop>(shop, HttpStatus.OK);
	}
	
	@GetMapping(value = "/gps", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Shop>> findShopsByGPS(@RequestBody Map<String, String> map) {
		// he
		logger.debug("Calling findShopsByGPS( )");

		List<Shop> shops;
		
		if(map.get("dong") == null) {
			if(map.get("gu") == null) {
				shops = shopRepository.findShopsByCity(map.get("city"));
			}
			shops = shopRepository.findShopsByCityAndGu(map.get("city"), map.get("gu"));
		}
		else
			shops = shopRepository.findShopsByCityAndGuAndDong(map.get("city"), map.get("gu"), map.get("dong"));
			
		for(Shop shop : shops) {
			Shop fixShop = new Shop(shop.getId(), shop.getName(), shop.getCity(), shop.getGu(), shop.getDong(), shop.getDetail());
			shop = fixShop;
		}

		return new ResponseEntity<List<Shop>>(shops, HttpStatus.OK);
	}
}
