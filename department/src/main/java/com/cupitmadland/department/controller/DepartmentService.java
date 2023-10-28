package com.cupitmadland.department.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.cupitmadland.department.model.Department;

public class DepartmentService {
	
	public void createDepartmentTable() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		Department department = new Department();
		t.commit();
		System.out.println("Successfully created department table");
		factory.close();
		session.close();
		
	}
	
	public void createDepartment() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		Department dOne = new Department();
		dOne.setName("Computer Science");
		dOne.setState("TX");
		
		Department dTwo = new Department();
		dTwo.setName("Math");
		dTwo.setState("AL");
		
		Department dThree = new Department();
		dThree.setName("Psychology");
		dThree.setState("MI");
		
		Department dFour = new Department();
		dFour.setName("Spanish");
		dFour.setState("CA");
		
		Department dFive = new Department();
		dFive.setName("Education");
		dFive.setState("NM");
		
		session.persist(dOne);
    	session.persist(dTwo);
    	session.persist(dThree);
    	session.persist(dFour);
    	session.persist(dFive);
    	
    	t.commit();
    	System.out.println("Successfully Saved");
    	factory.close();
    	session.close();
		
		
		
	}
	
	public void findDepartment(int id){
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		Department d = session.get(Department.class,id);
		System.out.println("Name: " + d.getName());
		System.out.println("State: " + d.getState());
		
		t.commit();
		factory.close();
		session.close();
		
	}
	
	public void updateDepartment(int id) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		Department d = new Department();
		d.setId(id);
		d.setName("Updated Department");
		d.setState("Alaska");
		
		session.merge(d);
		session.getTransaction().commit();
		session.close();
		factory.close();
		
	}
	
	public void deleteDepartment(int id) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		
		Department d = new Department();
		d.setId(id);
		session.remove(d);
		t.commit();
		session.close();
		factory.close();
		
	}
	

}
