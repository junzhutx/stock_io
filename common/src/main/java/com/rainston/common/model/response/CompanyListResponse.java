package com.rainston.common.model.response;

import java.util.List;

import com.rainston.common.model.Company;

public class CompanyListResponse extends BaseResponse {
	List<Company> companies;

	public List<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}
}
