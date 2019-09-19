package com.silort.swm.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.silort.swm.model.Product;
import com.silort.swm.model.User;

public interface ProductRepository extends CrudRepository<Product, Integer> {

	Product findById(int productId);
	
	Product findByName(String productName);
	//he
	List<Product> findByProviderId(int prodiverId);
	
}
