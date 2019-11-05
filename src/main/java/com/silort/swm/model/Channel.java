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

@Entity
@Table(name = "channel")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Channel {

	@Id
	@Column(name = "ch_id")
	@GeneratedValue
	private int id;
	
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "follower_num")
	private int followerNumber;
	
	@Column(name = "category_id")
	private int categoryId;

	@Column(name = "rating")
	private float rating;
	
	@Column(name = "cost")
	private int cost;
	
	@Column(name = "ER")
	private float engagementRating;
	
	@Column(name = "addr_city")
	private String city;
	
	@Column(name = "addr_gu")
	private String gu;
	
	@Column(name = "addr_dong")
	private String dong;
	
	@Column(name = "brod_type")
	private String broadcastType;
	
	@Transient
	private String userProfileImg;
	
	@Transient
	private int totalContractNumber;
	
	@Transient
	private int averageContractFee;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

