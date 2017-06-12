package com.rainston.common.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="stock")
public class Stock {
	@Id
	private String id;
	
	private String symbol;
	private String quoteDate;
	private double lastSale;
	private String marketCap;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	public String getQuoteDate() {
		return quoteDate;
	}

	public void setQouteDate(String quoteDate) {
		this.quoteDate = quoteDate;
	}
	
	public double getLastSale() {
		return lastSale;
	}
	
	public void setLastSale(double lastSale) {
		this.lastSale = lastSale;
	}
	
	public String getMarketCap() {
		return marketCap;
	}
	
	public void setMarketCap(String marketCap) {
		this.marketCap = marketCap;
	}	
}
