package com.silort.swm.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.silort.swm.model.Messenger;
import com.silort.swm.model.MessengerText;

public interface MessengerTextRepository extends CrudRepository<MessengerText, Integer> {
	//he
	List<MessengerText> findByMessengerId(int messengerId);
}
