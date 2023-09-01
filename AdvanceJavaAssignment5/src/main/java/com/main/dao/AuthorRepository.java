package com.main.dao;

import org.springframework.data.repository.CrudRepository;

import com.main.entity.Author;

public interface AuthorRepository extends CrudRepository<Author, Integer> {

	
}
