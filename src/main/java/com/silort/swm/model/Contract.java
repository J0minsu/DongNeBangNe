package com.silort.swm.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name="contract")
@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor

public class Contract {

	@GeneratedValue
	@Id
	@Column(name = "cont_id")
	private int id;

	@Column(name = "state")
	private int state;
	
	@Column(name = "influencer_id")
	private int influencerId;
	
	@Column(name = "provider_id")
	private int providerId;

	@Column(name = "product_id")
	private int productId;
	
	@Column(name = "times")
	private int times;
	
	@Column(name = "onePerTime")
	private int onePerTime;
	
	@Column(name = "price")
	private int price;
	
	@Column(name = "requirement")
	private String requirement;
	
	@Column(name = "con_date")
	private LocalDateTime contractDate;
	
	@Column(name = "del_at")
	private LocalDateTime deleteAt;
	
	@Transient
	private Product product;

	@Transient
	private User influencer;
	
	@Transient
	private User provider;
	
	@Transient
	private Channel channel;
	
	@PrePersist
	@PreUpdate
	public void createdContract() {
		this.contractDate = LocalDateTime.now();
	}
}
