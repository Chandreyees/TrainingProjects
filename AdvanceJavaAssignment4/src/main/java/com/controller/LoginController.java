package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.entities.User;
import com.hibernate.session.Hibernatee;

@Controller
public class LoginController {
	
	@RequestMapping(path = "/", method=RequestMethod.GET)
	public String name() {
		return "index";
	}


	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String form(@RequestParam("name") String name, @RequestParam("pass") String password, Model model, HttpServletRequest req) {

		Session ses=Hibernatee.s.openSession();
		
		
		Query query=ses.createQuery("from User where name=:uname");
		query.setParameter("uname", name);
		User user=(User)query.uniqueResult();
		ses.close();
		
		HttpSession hts=req.getSession();
		
		if(user==null) {
			hts.setAttribute("usernameError", "No such username exist!");
			return "index";
		}
		else if((user.getPass().compareTo(password))==0) {
			
			model.addAttribute("name", name);
			model.addAttribute("pass", password);
			model.addAttribute("uid", user.getUserId());
			return "home";
		}
		else {
			hts.setAttribute("passwordError","Invalid password");
			return "index";
		}
		

	}
}
