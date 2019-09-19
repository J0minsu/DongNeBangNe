package com.silort.swm.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.silort.swm.model.Messenger;
import com.silort.swm.model.User;

public interface MessengerRepository extends CrudRepository<Messenger, Integer> {

	Messenger findById(int id);

	List<Messenger> findByUser1Id(int user1Id);
	//he
	List<Messenger> findByUser2Id(int user2Id);
}
