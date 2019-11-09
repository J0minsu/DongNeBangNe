package com.silort.swm.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Reco {

	private int id;
	private String imgUrl;
	
	public Reco(int id, String imgUrl) {
		this.id = id;
		this.imgUrl = imgUrl;
	}
	
	
	
}
