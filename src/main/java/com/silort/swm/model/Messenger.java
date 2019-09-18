package com.silort.swm.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "messenger")
@ToString
@Getter
@Setter
@NoArgsConstructor
public class Messenger {

	@GeneratedValue
	@Id
	@Column(name = "msg_id")
	private int id;

	@Column(name = "user1_id")
	private int user1Id;
	
	@Column(name = "user2_id")
	private int user2Id;
	
	@Column(name = "msg_date")
	private LocalDateTime messageDate;
	
	@Column(name = "del_at")
	private LocalDateTime deleteDate;
	
	public Messenger(int user1Id, int user2Id) {
		this.user1Id = user1Id;
		this.user2Id = user2Id;
	}

	
}
