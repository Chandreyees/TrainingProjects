package com.main.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Author {
	
	@Id
	private int aId;
	@Column(nullable = false)
	private String name;
	
	@OneToMany(mappedBy = "author")
	@JsonBackReference
	List<Book> books;

	public Author(int aId, String name, List<Book> books) {
		super();
		this.aId = aId;
		this.name = name;
		this.books = books;
	}

	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getaId() {
		return aId;
	}

	public void setaId(int aId) {
		this.aId = aId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Author [aId=" + aId + ", name=" + name + ", books=" + books + "]";
	}
	
	

}
