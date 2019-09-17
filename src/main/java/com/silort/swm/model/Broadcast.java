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
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name="broadcast")
@Entity
public class Broadcast {

	@GeneratedValue
	@Id
	@Column(name = "brod_id")
	private int broadcastId;
	
	@Column(name = "channel_ch_id")
	private int channelId;
	
	@Column(name = "product_prou_id")
	private int productId;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "brod_date")
	private LocalDateTime broadcastDate;

	@Column(name = "brod_state")
	private int broadcastState;
	
}
