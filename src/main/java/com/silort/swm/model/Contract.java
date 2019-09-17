package com.silort.swm.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	//@Id
	//@Column(name = "contract_id")
	private int id;
	//he
	//@Column(name = "price")
	private int price;	//총 금액 
	
	//@Column(name = "times")
	private int times;	//방송 횟수 
	
	//@Column(name = "onePerTime")
	private int onePerTime;	//1회 방송당 시간 
	
	//@Column(name = "requirement")
	private String requirement;
	
	//@ManyToOne(cascade=CascadeType.ALL)
	//@JoinColumn(name = "seller_no")
	private User seller;
	
	//@ManyToOne(cascade=CascadeType.ALL)
	//@JoinColumn(name = "infliencer_no")
	private User influencer;
	
	//@Column(name = "state")
	private int state;
	
	//@Column(name = "contract_date")
	private LocalDateTime date;

	public Contract(int price, int times, int onePerTime, String requirement, User seller, User influencer, int state) {
		super();
		this.price = price;
		this.times = times;
		this.onePerTime = onePerTime;
		this.requirement = requirement;
		this.seller = seller;
		this.influencer = influencer;
		this.state = state;
	}
	
	@PrePersist
	public void createdContract() {
		this.date = LocalDateTime.now();
	}
}
