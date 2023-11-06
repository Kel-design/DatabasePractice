package com.cupitmadland.SMS.jpa.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//Hibernate connects to the database

public class HibernateUtil {
	
	//this method reads the hibernate.cfg.xml file and connects to the database

	public static Session getConnection() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		return session;
	}
}
