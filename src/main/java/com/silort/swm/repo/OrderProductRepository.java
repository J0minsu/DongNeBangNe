package com.silort.swm.repo;

import org.springframework.data.repository.CrudRepository;

import com.silort.swm.model.OrderProduct;

public interface OrderProductRepository extends CrudRepository<OrderProduct, Integer>  {

}
