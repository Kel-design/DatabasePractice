package com.cupitmadland.hibernateuser.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/**
 * Hibernate connects to database
 * 
 */
public class HibernateUtil {
	
	/**
	 * Methods reads the hibernate.cfg.xml file 
	 * and connects to the database.
	 * @return
	 */
	
	public static Session getConnection() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		return session;
		
			
	}
}
