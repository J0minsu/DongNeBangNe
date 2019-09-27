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

@Entity
@Table(name = "cart")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Cart {

	@Column(name = "user_id")
	@Id
	private int id;
	
	
	@Column(name = "price")
	private int price;

	public Cart(int userId, int price) {
		
		this.price = price;
	}
	
	
}
