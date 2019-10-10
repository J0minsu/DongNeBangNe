package com.silort.swm.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "\"order\"")
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

	@Column(name = "product01_id")
	private int product01Id;
	
	@Column(name = "product01_quantity")
	private int product01Q;	

	@Column(name = "product02_id")
	private int product02Id;
	
	@Column(name = "product02_quantity")
	private int product02Q;

	@Transient
	private Product product01;

	@Transient
	private Product product02;
	
	
	@PrePersist
	public void orderAt() {
		this.time = LocalDateTime.now();
	}


	public Order(int userId, int price, int product01Id, int product01Quantity, int product02Id,
			int product02Quantity) {
		
		this.userId = userId;
		this.totalPrice = price;
		this.product01Id = product01Id;
		this.product01Q = product01Quantity;
		this.product02Id = product02Id;
		this.product02Q = product02Quantity;
	}
	
}

