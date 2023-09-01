package com.AdvanceJ1.com.productSearch;

public class ProductModel {
	
	private String id,name,color,gender,size,availablity;
	private float price,ratting;
	
	
	
	public ProductModel(String id,String name,String color,String gender,String size,float price,float rate,String avail) {
		
		this.id=id;
		this.name=name;
		this.color=color;
		this.gender=gender;
		this.size=size;
		this.availablity=avail;
		this.price=price;
		this.ratting=rate;
		
	}



	public ProductModel() {
		// TODO Auto-generated constructor stub
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getColor() {
		return color;
	}



	public void setColor(String color) {
		this.color = color;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getSize() {
		return size;
	}



	public void setSize(String size) {
		this.size = size;
	}



	public String getAvailablity() {
		return availablity;
	}



	public void setAvailablity(String availablity) {
		this.availablity = availablity;
	}



	public float getPrice() {
		return price;
	}



	public void setPrice(float price) {
		this.price = price;
	}



	public float getRatting() {
		return ratting;
	}



	public void setRatting(float ratting) {
		this.ratting = ratting;
	}
	

	
}
