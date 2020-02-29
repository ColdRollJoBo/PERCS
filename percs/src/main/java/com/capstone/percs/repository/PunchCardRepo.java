package com.capstone.percs.repository;

import org.springframework.data.repository.CrudRepository;

import com.capstone.percs.entities.PunchCard;
import com.capstone.percs.entities.User;

public interface PunchCardRepo extends CrudRepository<PunchCard, Integer> {
	
	
	PunchCard findById(long id);
	
	PunchCard findByPromoId(long promoId);
	
	PunchCard findByUserId(long userId);


}
