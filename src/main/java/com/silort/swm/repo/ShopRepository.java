package com.silort.swm.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.silort.swm.model.Shop;

public interface ShopRepository extends CrudRepository<Shop, Integer> {

	Shop findShopByProviderId(int providerId);
	
	Shop findShopById(int id);

	List<Shop> findShopsByCity(String city);

	List<Shop> findShopsByCityAndGu(String city, String gu);

	//@Query("SELECT s.shop_id as id, s.addr_city as city, s.addr_gu as gu, s.addr_dong as dong, s.addr_detail as detail FROM Shop s WHERE s.addr_city = ?1 AND s.addr_gu = ?2 AND s.addr_dong = ?3")
	List<Shop> findShopsByCityAndGuAndDong(String city, String gu, String dong);

}
