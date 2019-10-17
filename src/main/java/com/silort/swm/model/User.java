package com.silort.swm.model;

import java.io.Serializable;
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

@ToString
@Entity
@Getter
@Setter
@Table(name="user")
@NoArgsConstructor
public class User implements Serializable{

	private static final long serialVersionUID = 6033703443868443791L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue
	private int id;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "role") 
	private int role; 
	
	@Column(name = "gender")
	private int gender;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "birth")
	private LocalDateTime birth;
	
	@Column(name = "del_at")
	private LocalDateTime deleteAt;
	
	@Column(name = "balance")
	private int balance;

	@Column(name = "addr_city")
	private String city;

	@Column(name = "addr_gu")
	private String gu;
	
	@Column(name = "addr_dong")
	private String dong;
	
	@Column(name = "addr_detail")
	private String detail;

	
	
}
