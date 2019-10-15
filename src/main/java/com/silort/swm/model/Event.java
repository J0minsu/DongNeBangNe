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



@Table(name = "\"event\"")
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Event {

	
	@Id
	@GeneratedValue
	@Column(name = "event_id")
	private int id;
	
	@Column(name = "event_type")
	private int eventType;
	
	@Column(name = "broadcast_id")
	private int broadcastId;
	
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "stock")
	private int stock;
}
