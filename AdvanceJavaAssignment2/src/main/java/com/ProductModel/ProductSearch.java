package com.ProductModel;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class ProductSearch {

	private String color,size,gender;
	private int choice;
	private Set<String> sizeSet;

	public ProductSearch(String color, String size, String gender) {
		super();
		this.color = color;
		this.size = size;
		this.gender = gender;
	}

	public ProductSearch() {
		super();
		//checking for validation
		String ar[]= {"S","M","L","XL","XXL"};
		sizeSet=new HashSet<String>(Arrays.asList(ar));
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSize() {
		
		return size;
	}

	public void setSize(String size) throws Exception {
		size=size.toUpperCase();
		if(sizeSet.contains(size))
		this.size = size;
		
		else {
			throw new Exception("Invalid Size");
		}
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) throws Exception {
		gender=gender.toUpperCase();
		if("M".equals(gender) || "F".equals(gender) || "U".equals(gender))
		this.gender = gender;
		
		else {
			throw new Exception("Invalid Gender");
		}
	}

	public int getChoice() {
		return choice;
	}

	public void setChoice(int choice) throws Exception {
		if(choice<1 || choice>3)
			throw new Exception("Invalid choice");
		this.choice = choice;
	}

	public List<ProductDetails> searchProduct(Session s) {
		//list to have the query
		List<ProductDetails> productList;
		String query="";
		
		if(choice==1) {
			query="from ProductDetails where color=:procol and gender=:gen and size=:prosize order by prize";
		}
		if(choice==2) {
			query="from ProductDetails where color=:procol and gender=:gen and size=:prosize order by ratting";
		}
		if(choice==3) {
			query="from ProductDetails where color=:procol and gender=:gen and size=:prosize order by prize,ratting DESC";
		}
		
		Query<ProductDetails> q=s.createQuery(query, ProductDetails.class);
		
		q.setParameter("procol", color);
		q.setParameter("gen", gender);
		q.setParameter("prosize", size);
		productList=q.getResultList();
		
		return productList;
	}
	
	
	
	
}
