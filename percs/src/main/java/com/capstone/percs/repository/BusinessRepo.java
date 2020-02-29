package com.capstone.percs.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.capstone.percs.entities.Business;

public interface BusinessRepo extends CrudRepository<Business, Integer> {
	
	List<Business> findById(long id);
	
	Business findByBusName(String busName);
	
	
	
	
	

}
