package com.silort.swm.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.silort.swm.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {


	
	User findUserByNo(int no);
	
	@Query("select u.no from User u where u.id = ?1")
	int findNoById(String id);
	//he
	List<User> findByRole(int role);

}