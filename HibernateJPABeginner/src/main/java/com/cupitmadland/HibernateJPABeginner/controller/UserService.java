package com.cupitmadland.HibernateJPABeginner.controller;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.cupitmadland.HibernateJPABeginner.model.User;


public class UserService {

	
	public void createUserTable() {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		User user = new User();
		t.commit();
		System.out.println("Successfully created user table");
		factory.close();
		session.close();
		
	}
	
	
	public void createUser() {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		User uone = new User();
		uone.setEmail("haseeb@gmail.com");
		uone.setFullname("Moh Haseeb");
		uone.setPassword("has123");
		uone.setSalary(2000.69);
		uone.setAge(20);
		uone.setCity("NYC");
		
		
		User uTwo = new User();
		uTwo.setEmail("James@gmail.com");
		uTwo.setFullname("James Santana");
		uTwo.setPassword("James123");
		uTwo.setSalary(2060.69);
		uTwo.setAge(25);
		uTwo.setCity("Dallas");
		
		User uThree = new User();
    	uThree.setEmail("Shahparan@gmail.com");
    	uThree.setFullname("AH Shahparan");
    	uThree.setPassword("Shahparan123");
    	uThree.setSalary(3060.69);
    	uThree.setAge(30);
    	uThree.setCity("Chicago");
    	
    	User uFour = new User("Christ", "christ@gmail.com", "147852", 35, 35000.30, "NJ");
    	User uFive = new User("Sid", "Sid", "s258", 29, 4000.36, "LA" );
    	
    	session.persist(uone);
    	session.persist(uTwo);
    	session.persist(uThree);
    	session.persist(uFour);
    	session.persist(uFive);
    	
    	t.commit();
    	System.out.println("Successfully Saved");
    	factory.close();
    	session.close();	
		
	}
	
	
	public void findingUser(int id) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		User u = session.get(User.class, id);
		System.out.println("Fullname" + u.getFullname());
		System.out.println("Email: " + u.getEmail());
		System.out.println("Password: " +u.getPassword());
		
		t.commit();
		factory.close();
		session.close();
		
		
		
	}
	
	
	public void updatingUser(int id) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		User u = new User();
		u.setId(id);
		u.setFullname("mhaseeb@perscholas");
		u.setPassword("123456");
		
		session.merge(u);
		session.getTransaction().commit();
		session.close();
		factory.close();
		
	}
	
	public void deletingUser(int id) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		User u = new User();
		u.setId(id);
		session.remove(u);
		t.commit();
		session.close();
		factory.close();
			
		
	}
	
	
}
