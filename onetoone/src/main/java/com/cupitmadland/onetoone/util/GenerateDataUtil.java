package com.cupitmadland.onetoone.util;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cupitmadland.onetoone.model.Address;
import com.cupitmadland.onetoone.model.Person;



public class GenerateDataUtil {
	
	public static void createDataOneToOne() {
		Session session = HibernateUtil.getConnection();
		Transaction t = session.beginTransaction();
		
		Address a1 = new Address();
		a1.setCity("NYC");
		a1.setState("NY");
		a1.setStreet("27th Street");
		a1.setZipcode(11103);
		
		Address a2 = new Address();
		a2.setCity("Buffalo");
		a2.setState("NY");
		a2.setStreet("28th Street");
		a2.setZipcode(15803);
		
		Person p1 = new Person();
		p1.setAge(25);
		p1.setEmail("e.jon@email.com");
		p1.setName("Elbert Adam");
		p1.setAddress(a1);
		
		Person p2 = new Person();
		p2.setAge(45);
		p2.setEmail("ch.fink@email.com");
		p2.setName("Christ Fink");
		p2.setAddress(a2);
		
		session.persist(p1);
		session.persist(p2);
		session.persist(a1);
		session.persist(a2);
		t.commit();
	}

}
