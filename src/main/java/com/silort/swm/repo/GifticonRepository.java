package com.silort.swm.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.silort.swm.model.Gifticon;

public interface GifticonRepository extends CrudRepository<Gifticon, Integer> {
	
	List<Gifticon> findGifticonsByUserId(int userId);
	
	Gifticon findGifticonById(int id);
}
