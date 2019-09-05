package com.silort.swm.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.silort.swm.model.Contract;
import com.silort.swm.model.ContractProduct;
import com.silort.swm.model.Product;

public interface ContractProductRepository extends CrudRepository<ContractProduct, Integer> {

	
	
	ContractProduct findById(int id);
	
	List<ContractProduct> findByContract(Contract contract);
	//he
	List<ContractProduct> findByProduct(Product product);
	
}
