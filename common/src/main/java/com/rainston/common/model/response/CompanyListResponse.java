package com.rainston.common.model.response;

import java.util.List;

import com.rainston.common.model.Company;

public class CompanyListResponse extends BaseResponse {
	int totalPages;
	long totalElements;
	List<Company> companies;

	public List<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public long getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(long totalElements) {
		this.totalElements = totalElements;
	}
}
