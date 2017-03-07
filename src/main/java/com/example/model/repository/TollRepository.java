package com.example.model.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.model.TollUsage;

@Repository
//@RestResource(path="/tolls")
public interface TollRepository extends 
			MongoRepository<TollUsage, String> {
	
	
	
}
