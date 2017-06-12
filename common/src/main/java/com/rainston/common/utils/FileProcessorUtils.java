package com.rainston.common.utils;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.number.CurrencyStyleFormatter;

public class FileProcessorUtils {

	public static String getQuoteDate(String fileName) {
		String retVal = null;
		String[] items = fileName.split("_|\\.");
		if (items != null && items.length == 3) {
			retVal = items[1];
		}
		return retVal;
	}
	
	public static double convertMarketCapToDouble(String marketCap) {
		if (marketCap.toLowerCase().equals("n/a"))
			return 0.0;
		
		try {
			BigDecimal bd = new CurrencyStyleFormatter().parse(marketCap, Locale.US);
			System.out.println("bd = " + bd);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0.0;
	}

	public static void main(String[] argv) {
		String qd = getQuoteDate("amex_20170529.csv");
		System.out.println(qd);
		
		convertMarketCapToDouble("$1.66");
	}
}
