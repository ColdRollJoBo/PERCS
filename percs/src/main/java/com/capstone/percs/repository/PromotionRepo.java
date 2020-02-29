package com.capstone.percs.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.capstone.percs.entities.Business;
import com.capstone.percs.entities.Promotion;

public interface PromotionRepo extends CrudRepository<Promotion, Integer> {
	
	List<Promotion> findById(long id);
	
	Promotion findByBusId(long busName);
	
	Promotion findByStartImg(String img);
	
	
	
	
	

}
