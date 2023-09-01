package com.main.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.main.entity.Book;

@Component
public interface BookService {

	public List<Book> findBooks();
	
	public Book findBookbyId(String id);
	
	public Book addBook(Book book);
	
	public void updateBook(Book book);
	
	public void deleteBook(String id);

	

	
}
