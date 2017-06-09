package com.rainston.common.model.response;

import java.util.List;

import com.rainston.common.model.Stock;

public class CompanyListResponse extends BaseResponse {
	List<Stock> companies;

	public List<Stock> getCompanies() {
		return companies;
	}

	public void setCompanies(List<Stock> companies) {
		this.companies = companies;
	}
}
