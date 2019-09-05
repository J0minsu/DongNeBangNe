package com.silort.swm.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.silort.swm.model.Contract;
import com.silort.swm.model.User;

public interface ContractRepository extends CrudRepository<Contract, Integer> {

	List<Contract> findBySeller(User seller);
	
	List<Contract> findByInfluencer(User influencer);
	//he
	Contract findById(int id);
}
