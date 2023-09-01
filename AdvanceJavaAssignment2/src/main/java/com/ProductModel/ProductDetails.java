package com.ProductModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProductDetails {
	
	@Id
	private String id;
	private String name;
	private String color;
	private String gender;
	private String size;
	private float prize;
	private float ratting;
	private String avail;
	
	public ProductDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductDetails(String id,String name, String color, String gender, String size, float prize, float ratting,
			String avail) {
		super();
		this.id=id;
		this.name = name;
		this.color = color;
		this.gender = gender;
		this.size = size;
		this.prize = prize;
		this.ratting = ratting;
		this.avail = avail;
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

	public double getPrize() {
		return prize;
	}

	public void setPrize(float prize) {
		this.prize = prize;
	}

	public double getRatting() {
		return ratting;
	}

	public void setRatting(float ratting) {
		this.ratting = ratting;
	}

	public String getAvail() {
		return avail;
	}

	public void setAvail(String avail) {
		this.avail = avail;
	}

	@Override
	public String toString() {
		return "ProductDetails [id=" + id + ", name=" + name + ", color=" + color + ", gender=" + gender + ", size="
				+ size + ", prize=" + prize + ", ratting=" + ratting + ", avail=" + avail + "]";
	} 
	
	

}
