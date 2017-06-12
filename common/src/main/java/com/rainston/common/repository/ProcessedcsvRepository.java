package com.rainston.common.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.rainston.common.model.Processedcsv;

public interface ProcessedcsvRepository extends MongoRepository<Processedcsv, String> {
	
	@Query("{fileName:'?0'}")
	Processedcsv findByFilename(String fileName);
	
}
