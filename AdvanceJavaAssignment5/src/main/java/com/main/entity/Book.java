package com.main.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Book {

	@Id
	private String bookCode;
	private String bname;
	private String bookDate=new SimpleDateFormat("dd-MMM-yyyy").format(new Date()); 
	@ManyToOne
	@JsonManagedReference
	@JsonIgnore
	private Author author;
	
	public Book(String bookCode, String bname, String bookDate, Author author) {
		this.bookCode = bookCode;
		this.bname = bname;
		this.bookDate = bookDate;
		this.author = author;
	}


	
	public Book() {
	}



	public String getBookCode() {
		return bookCode;
	}
	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getBookDate() {
		return bookDate;
	}
	public void setBookDate(String bookDate) {
		this.bookDate = bookDate;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	@Override
	public String toString() {
		return "Book [author=" + author + ", bname=" + bname + ", bookCode=" + bookCode + ", bookDate=" + bookDate
				+ "]";
	}

	
	
	
}
