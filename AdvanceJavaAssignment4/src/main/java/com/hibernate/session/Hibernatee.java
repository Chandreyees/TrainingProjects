package com.hibernate.session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Hibernatee {
	
	public static SessionFactory s=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

}
