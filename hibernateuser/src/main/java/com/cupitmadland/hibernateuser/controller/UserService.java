package com.cupitmadland.hibernateuser.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.cupitmadland.hibernateuser.model.User;
//Services provide for users

public class UserService {
	
	public void createUserTable() {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		User user = new User(); //part of the mapping file in the config file b/c it's using User class so it can build a table for it
		t.commit();
		System.out.println("Successfully created users table");
		factory.close();
		session.close();
	}
	
	public void createUser() {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		User uone = new User(); // use this obj to set user info
		uone.setEmail("hasseb@gmail.com"); //using setters 
		uone.setFullname("Moh Haseeb");
		uone.setPassword("has123");
		uone.setSalary(2000.99);
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
    	
    	User uFour = new User("Christ", "christ@gmail.com", "12345", 35, 35000.00, "Atlanta");
    	User uFive = new User("Sid", "sid@gmail.com", "4567", 25, 4000.00, "Louisville" );
    	
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
	
	public void findUser(int id) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		User u = session.get(User.class, id); //uses the user class to go find the user class and use the id from that class
			System.out.println("Fullname" + u.getFullname());
			System.out.println("Email: " + u.getEmail());
			System.out.println("Password: " +u.getPassword());
			
			t.commit();
			factory.close();
			session.close();
		
	}
	
	public void updateUser(int id) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		User u = new User();
		u.setId(id);
		u.setFullname("Brian Madland");
		u.setEmail("brian@gmail.com");
		u.setPassword("98765");
		u.setCity("Austin");
		
		session.merge(u);
		session.getTransaction().commit();
		session.close();
		factory.close();
	}
	
	public void deleteUser(int id) {
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
