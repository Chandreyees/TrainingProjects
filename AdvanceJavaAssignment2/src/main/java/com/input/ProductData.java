package com.input;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ProductModel.ProductDetails;

public class ProductData {
	
	private Session session;
	
	
	

	public ProductData(Session session) {
		super();
		this.session = session;
	}


	public void inputLine(String file) throws FileNotFoundException {
		
		String line = "", productName = "", productColor="", 
				productGender="", productSize="", productAvail="", productId="";
		float productPrice=0.0f, productrate = 0.0f;
		
		int i=1;
		Scanner sc = new Scanner(new File(file));
//		System.out.println("Enter");
		
		while (sc.hasNext()) {
			
			line = sc.nextLine();
			if (!line.isEmpty()) {
				StringTokenizer st = new StringTokenizer(line, "|");
				while (st.hasMoreTokens()) {
					
					if(i==1) {
						for(int j=1;j<=8;j++)
							st.nextToken();
						i++;
						break;
					}
						

					productId = st.nextToken();
					productName=st.nextToken();
					productColor=st.nextToken();
					productGender=st.nextToken();
					productSize=st.nextToken();
					productPrice=Float.parseFloat(st.nextToken());
					productrate=Float.parseFloat(st.nextToken());
					productAvail=st.nextToken();
					
					i++;
					
//					System.out.println(productPrice);
					
					
					ProductDetails pd=new ProductDetails(productId,productName,productColor,productGender,productSize,productPrice,
							productrate,productAvail);
					
					Transaction tx=session.beginTransaction();
					
					session.save(pd);
					
					tx.commit();
				}
					

				}
			
			}
			

		}

		

	}


