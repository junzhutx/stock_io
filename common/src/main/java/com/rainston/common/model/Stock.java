package com.rainston.common.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="stock")
public class Stock {
	@Id
	private long id;
	
	@Indexed(unique=true)
	private String symbol;
	
	private String qouteDate;
	private String name;
	private double lastSale;
	private double marketCap;
	private int ipoYear;
	private String sector;
	private String industry;
	
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

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
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
	
	public int getIpoYear() {
		return ipoYear;
	}
	
	public void setIpoYear(int ipoYear) {
		this.ipoYear = ipoYear;
	}
	
	public String getSector() {
		return sector;
	}
	
	public void setSector(String sector) {
		this.sector = sector;
	}
	
	public String getIndustry() {
		return industry;
	}
	
	public void setIndustry(String industry) {
		this.industry = industry;
	}
}
