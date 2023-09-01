package com.input;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ProductModel.ProductDetails;
import com.ProductModel.ProductSearch;

public class UserInput {

	public static void main(String[] args) throws FileNotFoundException {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session s = factory.openSession();

		ProductData pd = new ProductData(s);

		File folder = new File("csv_files");
		for (File srcfolder : folder.listFiles()) {
			String file = "csv_files//" + srcfolder.getName();
			pd.inputLine(file);
		}

		System.out.println("--------------------------Welcome---------------------------");
		System.out.println();
		Scanner sc = new Scanner(System.in);

		while (true) {
			
			
			
			ProductSearch ps=new ProductSearch();
			// color
			System.out.print("Enter your color preference: ");
			String color = sc.nextLine();
			ps.setColor(color);
			
			// size
			System.out.print("Enter your size preference: S, M, L, XL, XXL: ");
			String size = sc.nextLine();
			try {
				ps.setSize(size);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// gender
			System.out.print("Enter your Gender M for male and F for female and U for unisex: ");
			String gender = sc.nextLine();
			try {
				ps.setGender(gender);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// choice
			System.out.println(
					"Enter Output Preference, sorted by : 1.Price \\t 2.Rating \\t 3.Both Price and Rating \\nEnter Preference Choice Code : ");
			int choice = sc.nextInt();
			try {
				ps.setChoice(choice);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			List<ProductDetails> items=ps.searchProduct(s);
			for(ProductDetails p:items) {
				
				System.out.println("-----------------------------------------");
				System.out.print("Name : "+p.getName()+"\n");
				System.out.print("Color : "+p.getColor()+"\n");
				System.out.print("Gender : "+p.getGender()+"\n");
				System.out.print("Size : "+p.getSize()+"\n");
				System.out.print("Price : "+p.getPrize()+"\n");
				System.out.print("Rating : "+p.getRatting()+"\n");
				System.out.print("Availability : "+p.getAvail()+"\n");
				
				System.out.println("-----------------------------------------");
				
				
				
				
			}
			if(items.isEmpty())
		    {
				System.out.println("-----------------------------------------");
				System.out.println("T-shirt as per choice are not available");
				System.out.println("-----------------------------------------");
		    }

			sc.nextLine();
			System.out.println("Do you want to search for more products? y for yes and n for no");
			String c = sc.nextLine();
			if ("y".equalsIgnoreCase(c))
				continue;

			else
				break;
			
			
		}
	

			
			
			
			
			
			

		}

	}



