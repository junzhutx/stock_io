package com.rainston.common.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "lastProcessed")
public class LastProcessed {
	@Id
	Long id;
	
	private String exanchange;
	private String lastProcessed;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getExanchange() {
		return exanchange;
	}
	public void setExanchange(String exanchange) {
		this.exanchange = exanchange;
	}
	public String getLastProcessed() {
		return lastProcessed;
	}
	public void setLastProcessed(String lastProcessed) {
		this.lastProcessed = lastProcessed;
	}
}
