package com.silort.swm.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
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
	
	@Column(name = "category_id")
	private int categoryId;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "thumbnail_url")
	private String thumbnailUrl;
	
	@Column(name = "uploadAt")
	private LocalDateTime uploadAt;
	
	@PrePersist
	public void createdVideo() {
		this.uploadAt = LocalDateTime.now();
	}

	public Video(int productId, String name, int uploaderId, String url, String description, int categoryId, String thumbnailUrl) {
		this.productId = productId;
		this.name = name;
		this.uploaderId = uploaderId;
		this.url = url;
		this.description = description;
		this.categoryId = categoryId;
		this.thumbnailUrl = thumbnailUrl;
	}
	
	
}
