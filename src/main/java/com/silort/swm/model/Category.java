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

@Table(name = "category")
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Category {

	
	@Id
	@GeneratedValue
	@Column(name = "category_id")
	private int categoryId;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "division")
	private String division;
	
	@Column(name = "section")
	private String section;
}
