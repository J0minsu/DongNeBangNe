package com.silort.swm.repo;

import org.springframework.data.repository.CrudRepository;

import com.silort.swm.model.CartProduct;

public interface CartProductRepository extends CrudRepository<CartProduct, Integer>  {

}
