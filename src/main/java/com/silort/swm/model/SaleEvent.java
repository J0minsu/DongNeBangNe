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

@Table(name = "saleEvent")
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class SaleEvent {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "saleEvent_type")
	private int saleEventType;
	
	@Column(name = "stock")
	private int stock;
	
	@Column(name = "discount_percent")
	private int discountPercent;
}
