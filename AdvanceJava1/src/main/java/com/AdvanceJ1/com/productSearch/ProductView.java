package com.AdvanceJ1.com.productSearch;
import java.util.*;
public class ProductView {
	
	public ProductView(ArrayList<ProductModel> productList) {
		
		System.out.println("The list of available T-shirts are: \n");
		
		for(ProductModel p:productList) {
			
			System.out.print("Name : "+p.getName()+"\n");
			System.out.print("Color : "+p.getColor()+"\n");
			System.out.print("Gender : "+p.getGender()+"\n");
			System.out.print("Size : "+p.getSize()+"\n");
			System.out.print("Price : "+p.getPrice()+"\n");
			System.out.print("Rating : "+p.getRatting()+"\n");
			System.out.print("Availability : "+p.getAvailablity()+"\n");
			
			System.out.println("------------------------------------------");
		}
		
		if(productList.isEmpty())
	    {
	        System.out.println("T-shirt as per choice are not available");
	    }
	}

	

}
