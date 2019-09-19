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



@Table(name = "follower")
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Follower {

	@Id
	@Column(name = "follower_id")
	@GeneratedValue
	private int id;
	
	@Column(name = "channel_ch_id")
	private int channelId;
	
	@Column(name = "user_id")
	private int userId;
}
