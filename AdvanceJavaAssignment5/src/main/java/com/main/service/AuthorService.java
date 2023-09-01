package com.main.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.main.entity.Author;

@Component
public interface AuthorService {

	public List<Author> findAuthors();
	
	
	

}
