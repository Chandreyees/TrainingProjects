package com.main.dao;

import org.springframework.data.repository.CrudRepository;

import com.main.entity.Book;

public interface BookRepository extends CrudRepository<Book, String>{
	

	public Book  findByBookCode(String bookCode);

}
