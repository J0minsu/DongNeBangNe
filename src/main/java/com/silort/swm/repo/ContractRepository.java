package com.silort.swm.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.silort.swm.model.Contract;
import com.silort.swm.model.User;

public interface ContractRepository extends CrudRepository<Contract, Integer> {

	List<Contract> findByProviderId(int providerId);

	List<Contract> findByInfluencerId(int influencerId);

	List<Contract> findByProductId(int productId);
	//he
	List<Contract> findByStateAndProviderId(int state, int providerId);
	
	List<Contract> findByStateAndInfluencerId(int state, int influencerId);
	Contract findById(int id);
}
