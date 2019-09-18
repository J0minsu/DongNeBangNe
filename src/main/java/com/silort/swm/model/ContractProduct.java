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

@Table(name = "contractProduct")
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class ContractProduct {

	@Id
	@GeneratedValue
	@Column(name = "contProd_id")
	private int id;
	
	@Column(name = "contract_con_id")
	private Contract contractId;
	
	@Column(name = "product_prod_id")
	private Product productId;
	
}
