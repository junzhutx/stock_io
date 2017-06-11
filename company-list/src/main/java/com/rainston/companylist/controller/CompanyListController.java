package com.rainston.companylist.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rainston.common.model.Company;
import com.rainston.common.model.response.CompanyListResponse;
import com.rainston.common.model.response.ErrorCode;
import com.rainston.common.repository.CompanyRepository;
import com.rainston.common.repository.StockRepository;

@RestController
public class CompanyListController {
	
	@Autowired
	StockRepository stockRepository;
	
	@Autowired
	CompanyRepository companyRepository;
	
	@RequestMapping(value="/lists", method=RequestMethod.POST)
	public CompanyListResponse getCompanyList() {
		CompanyListResponse response = new CompanyListResponse();
		response.setErrorCode(ErrorCode.OK);
		response.setErrorMessage("Success!");
		
		List<Company> theList = companyRepository.findAll();
		response.setCompanies(theList);
		return response;
	}

	@RequestMapping(value="/lists/{symbol}", method=RequestMethod.POST)
	public CompanyListResponse getCompany(@PathVariable String symbol) {
		CompanyListResponse response = new CompanyListResponse();
		response.setErrorCode(ErrorCode.OK);
		response.setErrorMessage("Success!");
		
		Company aCompany = companyRepository.findBySymbol(symbol);
		ArrayList<Company> theList = new ArrayList<Company>();
		theList.add(aCompany);
		response.setCompanies(theList);
		return response;
	}

}
