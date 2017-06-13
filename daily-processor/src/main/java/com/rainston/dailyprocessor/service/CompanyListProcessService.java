package com.rainston.dailyprocessor.service;

public interface CompanyListProcessService {
	
	public static final String[] patterns = {"amex", "nasdaq", "nyse"};
	
	public static final String CSV_HEADER_SYMBOL 	= "Symbol";
	public static final String CSV_HEADER_NAME 		= "Name";
	public static final String CSV_HEADER_LASTSALE 	= "LastSale";
	public static final String CSV_HEADER_MARKETCAP = "MarketCap";
	public static final String CSV_HEADER_IPOYEAR 	= "IPOyear";
	public static final String CSV_HEADER_SECTOR 	= "Sector";
	public static final String CSV_HEADER_INDUSTRY 	= "industry";
	
	public static final String CSV_FILE_DIR 		= "/data/inbox/";
	
	public boolean processNewFiles();	
}
