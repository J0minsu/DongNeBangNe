package com.silort.swm.repo;

import org.springframework.data.repository.CrudRepository;

import com.silort.swm.model.Order;

public interface OrderRepository extends CrudRepository<Order, Integer>  {

	Order findOrderById(int orderId);
}
