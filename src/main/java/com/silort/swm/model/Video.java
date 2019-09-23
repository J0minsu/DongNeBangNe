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

@Table(name = "video")
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Video {

	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "product_id")
	private int productId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "uploader_id")
	private int uploaderId;
	
	@Column(name = "url")
	private String url;
	
	@Column(name = "category")
	private int categoty;
	
	@Column(name = "description")
	private String description;
}
