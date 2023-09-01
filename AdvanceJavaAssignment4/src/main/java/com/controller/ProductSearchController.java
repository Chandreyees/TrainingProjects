package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dao.ProductDao;
import com.entities.Product;
import com.filereader.DataReader;
import com.hibernate.session.Hibernatee;

@Controller
public class ProductSearchController {
	
	@RequestMapping(path = "/home", method = RequestMethod.POST)
	public String home(@RequestParam String color,@RequestParam String size,@RequestParam String gender,
			@RequestParam String output,
			HttpServletRequest req,Model model) throws IOException {
		
		DataReader.readDataFromCSV(req);
		
		Session ses=Hibernatee.s.openSession();
		
		HttpSession session=req.getSession();
		
		if(color.isEmpty() || size.isEmpty() || gender.isEmpty()) {
			session.setAttribute("Error", "One of the field id empty");
			return "home";
		}
		
		int choice=Integer.parseInt(output);
		ProductDao productDao=new ProductDao(color,size,gender,choice);
		List<Product> products=productDao.searchProduct(ses);
		
		model.addAttribute("products",products);
		return "display";
	}
	
	

}
