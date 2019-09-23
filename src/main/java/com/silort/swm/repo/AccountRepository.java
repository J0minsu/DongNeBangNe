package com.silort.swm.repo;

import org.springframework.data.repository.CrudRepository;

import com.silort.swm.model.Account;

public interface AccountRepository extends CrudRepository<Account, Integer> {

}
