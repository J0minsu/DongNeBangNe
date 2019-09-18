package com.silort.swm.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name="messengerText")
@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
public class MessengerText {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "msgText_id")
	private int id;
	
	@Column(name = "messenger_msg_id")
	private int messengerId;

	@Column(name = "from_user_id")
	private int fromUserId;
	
	@Column(name = "to_user_id")
	private int toUserId;
	
	@Column(name = "text")
	private String text;
	
	@Column(name = "msgText_date")
	private LocalDateTime time;
	
	@Column(name = "del_at")
	private LocalDateTime deleteAt;

	@PrePersist
	public void sendAt() {
		this.time = LocalDateTime.now();
	}
	

	public MessengerText(int messengerId, int fromUserId, int toUserId, String text) {
		this.messengerId = messengerId;
		this.fromUserId = fromUserId;
		this.toUserId = toUserId;
		this.text = text;
	}
	
	
}
