package com.silort.swm.repo;

import org.springframework.data.repository.CrudRepository;

import com.silort.swm.model.Cart;

public interface CartRepository extends CrudRepository<Cart, Integer>  {


	Cart findCartById(int id);
}
