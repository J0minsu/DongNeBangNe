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
	
	@Column(name = "product01_id")
	private int product01Id;
	
	@Column(name = "product01_quantity")
	private int product01Quantity;
	
	@Column(name = "product02_id")
	private int product02Id;
	
	@Column(name = "product02_quantity")
	private int product02Quantity;
	
		
	@Column(name = "price")
	private int price;

	public Cart(int userId, int price) {
		
		this.price = price;
	}
	
}
