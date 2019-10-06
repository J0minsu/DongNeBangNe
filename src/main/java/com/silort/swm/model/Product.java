package com.silort.swm.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
	@GeneratedValue
	@Column(name = "prod_id")
	private int id;

	@Column(name = "prod_name")
	private String name;
	
	@Column(name = "category_id")
	private int categoryId;
	
	@Column(name = "price")
	private int price;
	
	@Column(name = "stock")
	private int unitInStock;

	@Column(name = "description")
	private String description;
	
	@Column(name = "provider_id")
	private int providerId;

	@Column(name = "del_at")
	private LocalDateTime deleteAt;
	
	@Column(name = "image_url")
	private String imageUrl;
	
	
}
