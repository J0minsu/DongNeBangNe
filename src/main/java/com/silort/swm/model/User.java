package com.silort.swm.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@Column(name = "no")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int no;
	
	@Column(name = "id")
	private String id;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "role") 
	private int role; 
	
	//he
	public User(String id, String password, int role) {
		this.id = id;
		this.password = password;
		this.role = role;
	}
	
}
