package com.main.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.main.dao.BookRepository;
import com.main.entity.Book;
import com.main.service.BookService;

@Component
public class BookServiceImpl implements BookService {

	@Autowired
	private final BookRepository bookRepository;
	
	public BookServiceImpl(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}

	@Transactional
	@Override
	public List<Book> findBooks() {
		List<Book> list=(List<Book>)bookRepository.findAll();
//		return bookRepository.findAll();
		return list;
	}

	@Transactional
	@Override
	public Book findBookbyId(String id) {
		 Book b=null;
		try {
			b=bookRepository.findByBookCode(id);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public Book addBook(Book book) {
		bookRepository.save(book);
		return book;
	}

	@Override
	public void updateBook(Book book) {
		bookRepository.save(book);
		
	}

	@Override
	public void deleteBook(String id) {
		bookRepository.deleteById(id);
		
	}
}
