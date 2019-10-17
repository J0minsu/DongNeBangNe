package com.silort.swm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.silort.swm.model.Order;
import com.silort.swm.model.Product;
import com.silort.swm.model.User;
import com.silort.swm.repo.OrderRepository;
import com.silort.swm.repo.ProductRepository;
import com.silort.swm.repo.UserRepository;




@RestController
@RequestMapping("/api/orders")
public class OrderController {

	static Logger logger = LoggerFactory.getLogger(BroadcastController.class);
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("/{orderId}")
	public ResponseEntity<Order> getOrder(@PathVariable int orderId) {
		
		Order order = orderRepository.findOrderById(orderId);
		
		setShipAddress(order);
		setProduct(order);
		
		return new ResponseEntity<Order>(order, HttpStatus.OK);
		
	}
	
	
	private void setShipAddress(Order order) {		
		User user = userRepository.findUserById(order.getUserId());

		order.setCity(user.getCity());
		order.setGu(user.getGu());
		order.setDong(user.getDong());
		order.setDetail(user.getDetail());		
	}
	
	private void setProduct(Order order) {
		Product product1 = productRepository.findById(order.getProduct01Id());
		Product product2 = productRepository.findById(order.getProduct02Id());
	}
}
