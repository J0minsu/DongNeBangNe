package com.silort.swm.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "chatting")
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Chatting {

	@Column(name = "chat_id")
	@Id
	@GeneratedValue
	private int id;

	@Column(name = "broadcast_brod_id")
	private int broadcastId;

	@Column(name = "use_id")
	private int userId;
	
	@Column(name = "chatText")
	private String chattingText;

	@Column(name = "time")
	private LocalDateTime time;
	
	@PrePersist
	public void sendChatting() {
		this.time = LocalDateTime.now();
	}
	
	
	
	
	
	
	
}