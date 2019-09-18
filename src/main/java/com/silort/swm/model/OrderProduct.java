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

@Table(name = "orderProduct")
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class OrderProduct {

	@Id
	@GeneratedValue
	@Column(name = "orderProduct_id")
	private int id;
	
	@Column(name = "order_odr_id")
	private int orderId;
	
	@Column(name = "product_prod_id")
	private int productId;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "price")
	private int price;
}
