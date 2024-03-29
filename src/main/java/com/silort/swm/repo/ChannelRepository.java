package com.silort.swm.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.silort.swm.model.Channel;

public interface ChannelRepository extends CrudRepository<Channel, Integer>  {

	
	Channel findById(int channelId);
	
	Channel findByUserId(int userId);
	
	List<Channel> findChannelByUserId(List<Integer> userId);
	
}
