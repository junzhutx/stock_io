package com.rainston.common.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="stock")
public class Stock {
	@Id
	private long id;
	
	private String symbol;
	private String qouteDate;
	private double lastSale;
	private double marketCap;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	public String getQouteDate() {
		return qouteDate;
	}

	public void setQouteDate(String qouteDate) {
		this.qouteDate = qouteDate;
	}
	
	public double getLastSale() {
		return lastSale;
	}
	
	public void setLastSale(double lastSale) {
		this.lastSale = lastSale;
	}
	
	public double getMarketCap() {
		return marketCap;
	}
	
	public void setMarketCap(double marketCap) {
		this.marketCap = marketCap;
	}	
}
