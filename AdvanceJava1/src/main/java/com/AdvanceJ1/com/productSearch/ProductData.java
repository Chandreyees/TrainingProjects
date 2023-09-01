package com.AdvanceJ1.com.productSearch;
import java.io.*;
import java.util.*;
import java.util.Collections;
import java.util.Comparator;

public class ProductData{
	
	public ArrayList<ProductModel> productList=new ArrayList<ProductModel>();
	ArrayList<String> tempar;
	ProductView pv;
	
	public void searchProduct(String file, String color, String size, String gender) throws FileNotFoundException {
		String line="";
		
		Scanner sc=new Scanner(new File(file));
		while(sc.hasNext()) {
			line=sc.nextLine();
			if(!line.isEmpty()) {
				 StringTokenizer st = new StringTokenizer(line,"|"); //splitting each cell
				 tempar=new ArrayList<String>(line.length()); //storing the length of each line
				 while(st.hasMoreTokens()) {
					 tempar.add(st.nextToken()); //separately storing the values of each cell
				 }
				 
				 //adding only those value to productlist whose value matches with user's input
				 if(tempar.get(2).equalsIgnoreCase(color) && tempar.get(4).equalsIgnoreCase(size) && tempar.get(3).equalsIgnoreCase(gender)) {
					 ProductModel pm=new ProductModel(tempar.get(0),tempar.get(1),tempar.get(2),tempar.get(3),tempar.get(4),Float.parseFloat(tempar.get(5)),
							 Float.parseFloat(tempar.get(6)),tempar.get(7).toUpperCase());
					 productList.add(pm);
					 
				 }
			}
			
		}
	}
	
	public void view(int choice) {
		
		if(choice==1) {
//			if(("Y".compareTo(productList.get(7).getAvailablity()))==0) {
				Collections.sort(productList, new Comparator<ProductModel>() {
					public int compare(ProductModel p1, ProductModel p2) {
						return Float.compare(p1.getPrice(), p2.getPrice());
					 }
				});
				
//			}
//			else
//				System.out.println("No T-shirt available");
		}
		else if(choice==2) {
//			if(("Y".compareTo(productList.get(7).getAvailablity()))==0) {
				Collections.sort(productList, new Comparator<ProductModel>() {

					public int compare(ProductModel o1, ProductModel o2) {
						return Float.compare(o2.getRatting(), o1.getRatting());
					}
					
				});
				
//			}
//			else
//				System.out.println("No T-shirt available");
			
		}
		else if(choice==3) {
//			if(("Y".compareTo(productList.get(7).getAvailablity()))==0) {
				Collections.sort(productList, new Comparator<ProductModel>() {

					public int compare(ProductModel o1, ProductModel o2) {
						if(o1.getPrice()==o2.getPrice()) {
							return Float.compare(o2.getRatting(), o1.getRatting());
						}
						return Float.compare(o1.getPrice(), o2.getPrice());
					}
					
				});
//				
//			}
//			else
//				System.out.println("No T-shirt available");
			
		}
		else {
			System.out.println("Wrong Choice");
		}
		
		pv=new ProductView(productList);
	
	}		

	 
}
