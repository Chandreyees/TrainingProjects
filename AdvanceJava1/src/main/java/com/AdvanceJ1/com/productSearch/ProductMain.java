package com.AdvanceJ1.com.productSearch;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class ProductMain {

	public static void main(String[] args) throws FileNotFoundException {
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		//color
		System.out.print("Enter your color preference: ");
		String color=sc.nextLine();
		//size
		System.out.print("Enter your size preference: ");
		String size=sc.nextLine();
		//gender
		System.out.print("Enter your Gender M for male and F for female: ");
		String gender=sc.nextLine();
		//choice
		System.out.println("Enter Output Preference, sorted by : 1.Price \\t 2.Rating \\t 3.Both Price and Rating \\nEnter Preference Choice Code : ");
		int choice=sc.nextInt();
		
		ProductData pd=new ProductData();
		
		File folder= new File("csv_files");
		for(File srcfolder : folder.listFiles()) {
			String file="csv_files//"+srcfolder.getName();
//			System.out.println(file);
			pd.searchProduct(file,color,size,gender);
			
		}
		pd.view(choice);
		

	}

}
