package com.rainston.common.repository;

import com.rainston.common.model.Stock;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StockRepository extends MongoRepository<Stock, Long> {

}
