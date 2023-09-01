package com.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.entities.Product;

public class ProductDao {

	private String color,size,gender;
	private int choice;
	
	
	public ProductDao(String color, String size, String gender,int choice) {
		super();
		this.color = color;
		this.size = size;
		this.gender = gender;
		this.choice=choice;
	}

	
	public List<Product> searchProduct(Session s) {
		//list to have the query
		List<Product> productList;
		String query="";
		
		if(choice==1) {
			query="from Product where color=:procol and gender=:gen and size=:prosize order by price";
		}
		if(choice==2) {
			query="from Product where color=:procol and gender=:gen and size=:prosize order by rating";
		}
		if(choice==3) {
			query="from Product where color=:procol and gender=:gen and size=:prosize order by price,rating DESC";
		}
		
		Query<Product> q=s.createQuery(query, Product.class);
		
		q.setParameter("procol", color);
		q.setParameter("gen", gender);
		q.setParameter("prosize", size);
		productList=q.getResultList();
		
		return productList;
	}
	
	
	
	
	
}
