package com.rainston.common.repository;

import com.rainston.common.model.Stock;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface StockRepository extends MongoRepository<Stock, Long> {
	
	@Query("{symbol:'?0'}")
    List<Stock> findBySymbol(String symbol);

	@Query("{qouteDate:'?0'}")
    List<Stock> findByQuoteDate(String qouteDate);
	
}
