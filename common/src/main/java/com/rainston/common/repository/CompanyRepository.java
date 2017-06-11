package com.rainston.common.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.rainston.common.model.Company;

public interface CompanyRepository extends MongoRepository<Company, Long> {
	
	@Query("{symbol:'?0'}")
    Company findBySymbol(String symbol);
}
