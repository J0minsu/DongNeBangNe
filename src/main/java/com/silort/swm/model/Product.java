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

@Getter
@Setter
@Entity
@Table(name = "product")
@NoArgsConstructor
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private int id;

	@Column(name = "name")
	private String name;
	
	@Column(name = "price")
	private int price;
	
	@Column(name = "unitInStock")
	private int unitInStock;

	@Column(name = "description")
	private String description;
	//he
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "seller_no")
	private User seller;

	public Product(String name, int price, int unitInStock, String description, User user) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.unitInStock = unitInStock;
		this.seller = user;
	}
	
	
}
