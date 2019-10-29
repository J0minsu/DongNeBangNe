package com.silort.swm.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name="broadcast")
@Entity
@AllArgsConstructor
public class Broadcast {

	@GeneratedValue
	@Id
	@Column(name = "brod_id")
	private int id;
	
	@Column(name = "channel_ch_id")
	private int channelId;
	
	@Column(name = "product_prod_id")
	private int productId;
	
	@Column(name = "category_id")
	private int categoryId;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "brod_date")
	private LocalDateTime broadcastDate;

	@Column(name = "brod_state")
	private int broadcastState;

	@Column(name = "thumbnail_url")
	private String thumbnailUrl;

	@Column(name = "url")
	private String url;

	@Column(name = "media_id")
	private String mediaId;
	
	@PrePersist
	public void createdContract() {
		this.broadcastDate = LocalDateTime.now();
	}


	public Broadcast(int channelId, int productId, int categoryId, String title, LocalDateTime broadcastDate,
			int broadcastState, String thumbnailUrl, String url) {
		this.channelId = channelId;
		this.productId = productId;
		this.categoryId = categoryId;
		this.title = title;
		this.broadcastDate = broadcastDate;
		this.broadcastState = broadcastState;
		this.thumbnailUrl = thumbnailUrl;
		this.url = url;
	}
}

	
