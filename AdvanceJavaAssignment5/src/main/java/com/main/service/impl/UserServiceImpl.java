package com.main.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.main.dao.UserRepository;
import com.main.entity.User;
import com.main.service.UserService;

@Component
public class UserServiceImpl implements UserService {
	
	@Autowired
	private final UserRepository userRepository;
	
	

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}



	@Override
	public User findByNameAndPassword(String name, String password) {
		User user=userRepository.findByNameAndPassword(name, password);
		return user;
	}

}
