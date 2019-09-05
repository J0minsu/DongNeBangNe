package com.silort.swm.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.silort.swm.model.Messenger;
import com.silort.swm.model.User;

public interface MessengerRepository extends CrudRepository<Messenger, Integer> {

	Messenger findById(int id);

	List<Messenger> findByUser1(User user1);
	//he
	List<Messenger> findByUser2(User user2);
}
