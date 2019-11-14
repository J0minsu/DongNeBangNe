package com.silort.swm.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Table(name = "\"gifticon\"")
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Gifticon {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "product_id")
	private int productId;

	@Column(name = "isUsing")
	private int isUsing;

	@Column(name = "issue_at")
	private LocalDateTime issueAt;

	@Column(name = "used_at")
	private LocalDateTime usedAt;
	
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "image")
	private int image;
	
	@Transient
	private String text;
	
	@PrePersist
	public void issueAt() {
		this.issueAt = LocalDateTime.now();
	}
}
