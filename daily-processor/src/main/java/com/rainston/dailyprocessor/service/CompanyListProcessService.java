package com.rainston.dailyprocessor.service;

public interface CompanyListProcessService {
	
	public static final String[] patterns = {"amex", "nasdaq", "nyse"};
	
	public boolean processNewFiles();	
}
