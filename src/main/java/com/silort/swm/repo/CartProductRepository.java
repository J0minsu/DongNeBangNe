package com.silort.swm.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.silort.swm.model.CartProduct;

public interface CartProductRepository extends CrudRepository<CartProduct, Integer>  {

	List<CartProduct> findCartProductByCartId(int userId);
	
	CartProduct findCartProductByCartIdAndProductId(int Id, int productId);
}
