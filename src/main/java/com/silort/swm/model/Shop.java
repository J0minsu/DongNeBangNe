package com.silort.swm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Table(name = "shop")
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Shop {

	@Id
	@GeneratedValue
	@Column(name = "shop_id")
	private int id;	
	
	@Column(name = "shop_name")
	private int name;

	@Column(name = "provider_user_id")
	private int providerId;

	@Column(name = "uri")
	private String uri;

	@Column(name = "addr_city")
	private String city;

	@Column(name = "addr_gu")
	private String gu;
	
	@Column(name = "addr_dong")
	private String dong;
	
	@Column(name = "follower_num")
	private int followerNumber;

	@Column(name = "category_id")
	private int categoryId;

}
