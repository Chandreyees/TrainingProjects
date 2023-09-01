package com.main.service;

import org.springframework.stereotype.Component;

import com.main.entity.User;

@Component
public interface UserService {
	
	public User findByNameAndPassword(String name,String password);

}
