package com.filereader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Product;
import com.hibernate.session.Hibernatee;
import com.mysql.cj.Query;

public class DataReader {

	private static boolean isRead = false;

	private DataReader() {

	}

	private static void read(String file, Session session) throws FileNotFoundException {
		String line = "", productName = "", productColor = "", productGender = "", productSize = "", productAvail = "",
				productId = "";
		float productPrice = 0.0f, productrate = 0.0f;

		int i = 1;
		Scanner sc = new Scanner(new File(file));
//		System.out.println("Enter");

		while (sc.hasNext()) {

			line = sc.nextLine();
			if (!line.isEmpty()) {
				StringTokenizer st = new StringTokenizer(line, "|");
				while (st.hasMoreTokens()) {

					if (i == 1) {
						for (int j = 1; j <= 8; j++)
							st.nextToken();
						i++;
						break;
					}

					productId = st.nextToken();
					productName = st.nextToken();
					productColor = st.nextToken();
					productGender = st.nextToken();
					productSize = st.nextToken();
					productPrice = Float.parseFloat(st.nextToken());
					productrate = Float.parseFloat(st.nextToken());
					productAvail = st.nextToken();

					i++;

//					System.out.println(productPrice);

					Product p = new Product(productId, productName, productColor, productGender, productSize,
							productPrice, productrate, productAvail);

					Transaction tx = session.beginTransaction();

					session.save(p);

					tx.commit();
				}

			}

		}

	}

	public static void readDataFromCSV(HttpServletRequest req) throws IOException {

		if (DataReader.isRead) {
			return;
		}

		Session session = Hibernatee.s.openSession();
		String query = "delete from product";
		Transaction txTransaction = session.beginTransaction();
		session.createSQLQuery(query);
		txTransaction.commit();
		File folder = new File(req.getServletContext().getRealPath("/WEB-INF") + "/CSV_Files");
		System.out.println(folder.listFiles());

		for (File fileEntry : folder.listFiles()) {
			System.out.println(fileEntry.getName());
			read(req.getServletContext().getRealPath("/WEB-INF") + "/csv_files//" + fileEntry.getName(), session);
		}
		DataReader.isRead = true;

	}
}
