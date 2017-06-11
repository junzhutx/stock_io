package com.rainston.common.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rainston.common.model.LastProcessed;

public interface LastProcessedRepository extends MongoRepository<LastProcessed, Long> {

}
