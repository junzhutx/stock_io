package com.rainston.companylist.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rainston.common.model.Stock;
import com.rainston.common.model.response.CompanyListResponse;
import com.rainston.common.model.response.ErrorCode;
import com.rainston.common.repository.StockRepository;

@RestController
public class CompanyListController {
	
	@Autowired
	StockRepository stockRepository;
	
	@RequestMapping(value="/lists/{quoteDate}", method=RequestMethod.POST)
	public CompanyListResponse getCompanyList(@PathVariable String quoteDate) {
		CompanyListResponse response = new CompanyListResponse();
		response.setErrorCode(ErrorCode.OK);
		response.setErrorMessage("Success!");
		
		List<Stock> theList = stockRepository.findByQuoteDate(quoteDate);
		response.setCompanies(theList);
		return response;
	}

	@RequestMapping(value="/list/{symbol}", method=RequestMethod.POST)
	public CompanyListResponse getCompany(@PathVariable String symbol) {
		CompanyListResponse response = new CompanyListResponse();
		response.setErrorCode(ErrorCode.OK);
		response.setErrorMessage("Success!");
		
		List<Stock> theList = stockRepository.findBySymbol(symbol);
		response.setCompanies(theList);
		return response;
	}

}
