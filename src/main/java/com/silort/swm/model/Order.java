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

@Table(name = "order")
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Order {

	@Column(name = "odr_id")
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name = "user_id")
	private int userId;

	@Column(name = "totalPrice")
	private int totalPrice;

	@Column(name = "time")
	private LocalDateTime time;
	
	@PrePersist
	public void orderAt() {
		this.time = LocalDateTime.now();
	}
	
}

