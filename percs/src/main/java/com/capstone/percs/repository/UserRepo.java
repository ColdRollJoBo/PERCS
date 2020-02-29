package com.capstone.percs.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.capstone.percs.entities.User;

public interface UserRepo extends CrudRepository<User, Integer> {
	
	List<User> findById(long id);
	
	User findByUsername(String userName);
	
	
	
	
	

}
