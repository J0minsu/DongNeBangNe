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

@Table(name = "contractProduct")
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class ContractProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "contractProduct_id")
	private int id;
	
	@JoinColumn(name = "contract_id")
	private Contract contract;
	
	@JoinColumn(name = "product_id")
	private Product product;
	
}
