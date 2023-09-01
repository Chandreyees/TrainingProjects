package com.library.bookauthorapi.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Author {
    
    @Id
    @GeneratedValue
    private int aId;
    private String name;
    @OneToMany(mappedBy = "authors")
    List<Book> books;

    public Author(int aId, String name) {
        this.aId = aId;
        this.name = name;
    }

    public Author() {
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

    
    


    
}
