package com.main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.main.dao.AuthorRepository;
import com.main.entity.Author;
import com.main.service.AuthorService;

@Component
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private final AuthorRepository authorRepository ;
	
	

	public AuthorServiceImpl(AuthorRepository authorRepository) {
		super();
		this.authorRepository = authorRepository;
	}

	@Override
	public List<Author> findAuthors() {
		return (List<Author>) authorRepository.findAll();
	}

	
	
	
}
