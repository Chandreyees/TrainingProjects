package com.library.bookauthorapi.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Book {
    
    @Id
    private int bookcode;
    private String bname;
    @ManyToOne
    private Author authors;
   
    public Book(int bookcode, String bname, Author authors) {
        this.bookcode = bookcode;
        this.bname = bname;
        this.authors = authors;
    }

    public Book() {
    }

    public int getBookcode() {
        return bookcode;
    }

    public void setBookcode(int bookcode) {
        this.bookcode = bookcode;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public Author getAuthors() {
        return authors;
    }

    public void setAuthors(Author authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Book [authors=" + authors + ", bname=" + bname + ", bookcode=" + bookcode + "]";
    }

   

}
