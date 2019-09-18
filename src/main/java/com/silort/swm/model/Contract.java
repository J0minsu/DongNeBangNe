package com.silort.swm.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

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

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "cont_id")
	private int id;

	@Column(name = "state")
	private int state;
	
	@Column(name = "influencer_id")
	private int influencerId;
	
	@Column(name = "provider_id")
	private int providerId;
	
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
	
	
	@PrePersist
	public void createdContract() {
		this.contractDate = LocalDateTime.now();
	}
}
