package com.silort.swm.model;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class MediaChannel {

	private String state;
	
	private String channel_id;
	
	private String source_url;
	
	private Map<String, String> destination_url;
	
}
