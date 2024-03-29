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

@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name="account")
@Entity
public class Account {

	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "owner_id")
	private int ownerId;
	
	@Column(name = "bank_code")
	private String bankCode;
	
	@Column(name = "number")
	private String number;
	
	@Column(name = "owner_name")
	private String ownerName;
}
