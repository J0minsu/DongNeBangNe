package com.silort.swm.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Messenger")
@ToString
@Getter
@Setter
@NoArgsConstructor
public class Messenger {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "messenger_id")
	private int id;

	@ManyToOne(cascade =  {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name = "user1_no")
	private User user1;
	
	@ManyToOne(cascade =  {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name = "user2_no")
	private User user2;
	//he
	public Messenger(User user1, User user2) {
		this.user1 = user1;
		this.user2 = user2;
	}

	
}
