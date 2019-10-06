package com.silort.swm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Table(name = "cartProduct")
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class CartProduct {

	@Id
	@GeneratedValue
	@Column(name = "cartProduct_id")
	private int id;
	
	@Column(name = "product_prod_id")
	private int productId;
	
	@Column(name = "cart_id")
	private int cartId;
	
	@Column(name = "quantity")
	private int quantity;

	public CartProduct(int productId, int cartId, int quantity) {

		this.productId = productId;
		this.cartId = cartId;
		this.quantity = quantity;
	}
	
	
}
