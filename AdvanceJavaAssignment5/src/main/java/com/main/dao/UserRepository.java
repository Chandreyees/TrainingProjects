package com.main.dao;

import org.springframework.data.repository.CrudRepository;

import com.main.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	public User findByNameAndPassword(String name,String password);
	
}
