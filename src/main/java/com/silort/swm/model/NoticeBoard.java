package com.silort.swm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "\"noticeBoard\"")
public class NoticeBoard {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "subject")
	private String subject;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "price")
	private int price;
	
	@Column(name = "category")
	private int category;
	
	@Column(name = "shop_id")
	private int shopId;
	
	@Transient
	private Shop shop;
}
