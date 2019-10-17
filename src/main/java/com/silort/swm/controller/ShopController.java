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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ResponseEntity<List<Shop>> findShopsByGPS(@RequestParam("city") String city, @RequestParam("gu") String gu, @RequestParam("dong") String dong) {
		// he
		logger.debug("Calling findShopsByGPS( )");

		List<Shop> shops;
		
		if(dong == null) {
			if(gu == null) {
				shops = shopRepository.findShopsByCity(city);
			}
			shops = shopRepository.findShopsByCityAndGu(city, gu);
		}
		else
			shops = shopRepository.findShopsByCityAndGuAndDong(city, gu, dong);
			
		for(Shop shop : shops) {
			Shop fixShop = new Shop(shop.getId(), shop.getName(), shop.getCity(), shop.getGu(), shop.getDong(), shop.getDetail());
			shop = fixShop;
		}

		return new ResponseEntity<List<Shop>>(shops, HttpStatus.OK);
	}
}
