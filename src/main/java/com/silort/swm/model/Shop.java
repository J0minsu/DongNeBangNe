package com.silort.swm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

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
	private String name;

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
	
	@Column(name = "addr_detail")
	private String detail;
	
	@Column(name = "follower_num")
	private int followerNumber;

	@Column(name = "category_id")
	private int categoryId;
	
	@Column(name = "profile_img")
	private String profileImage;
	
	@Column(name = "banner_img")
	private String bannerImage;
	
	@Column(name = "description")
	private String description;
	
	@Transient
	private User provider;

	public Shop(int id, String name, String city, String gu, String dong, String detail) {
		this.id = id;
		this.name = name;
		this.city = city;
		this.gu = gu;
		this.dong = dong;
		this.detail = detail;
	}
	
	

}
