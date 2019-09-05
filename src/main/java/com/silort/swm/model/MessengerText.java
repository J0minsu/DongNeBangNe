package com.silort.swm.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name="MessengerText")
@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
public class MessengerText {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "messengerText_id")
	private int id;
	
	@ManyToOne(cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name = "messenger_id")
	private Messenger messenger;
	
	@ManyToOne(cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name = "fromUser_no")
	private User fromUser;
	
	@Column(name = "messengerText")
	private String messengerText;
	//he
	@Column(name = "time")
	private LocalDateTime time;

	@PrePersist
	public void createdAt() {
		this.time = LocalDateTime.now();
	}
	

	public MessengerText(Messenger messenger, User fromUser, String messengerText) {
		super();
		this.messenger = messenger;
		this.fromUser = fromUser;
		this.messengerText = messengerText;
	}
	
	
}
