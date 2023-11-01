package com.cupitmadland.abcinc.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Order;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.cupitmadland.abcinc.model.Customer;
import com.cupitmadland.abcinc.myinterface.CustomerDAO;
import com.cupitmadland.abcinc.service.HibernateUtil;

public class CustomerService implements CustomerDAO{
	
	private ArrayList<Customer> customerObj;
	
	public void createCustomerTable() {
		Session session = HibernateUtil.getConnection();
		Transaction t = session.beginTransaction();
		
		
		Customer customer = new Customer();
		t.commit();
		System.out.println("Successfully created Customer table");
		
		session.close();
	
	}
	
	public void createCustomer() {
		Session session = HibernateUtil.getConnection();
		Transaction t = session.beginTransaction();
		
		Customer cOne = new Customer();
		cOne.setName("Jane Doe");
		cOne.setEmail("jane@email.com");
		cOne.setPassword("123456");
		
		Customer cTwo = new Customer();
		cTwo.setName("Bob Smith");
		cTwo.setEmail("bob@email.com");
		cTwo.setPassword("246810");
		
		Customer cThree = new Customer();
		cThree.setName("Frosty Snowman");
		cThree.setEmail("frosty@email.com");
		cThree.setPassword("987654");
		
		List<Customer> customerList = new ArrayList<Customer>();
		
		customerList.add(cOne);
		customerList.add(cTwo);
		customerList.add(cThree);
		
		session.persist(cOne);
    	session.persist(cTwo);
    	session.persist(cThree);
    	
    	t.commit();
    	System.out.println("Successfully Saved");
    
    	session.close();
	}

	@Override
	public List<Customer> getAllCustomers() {
		Session session = HibernateUtil.getConnection();
		Transaction t = session.beginTransaction();
		Query<Object[]> query = session.createQuery("SELECT C.id, C.name FROM Customer AS C", Object[].class);
		List<Object[]> results = query.getResultList();
		
		for (Object[] a : results) {
			System.out.println("Id: " + a[0] + ", Name: " + a[1]);
		}
		return null;
	
	
	}

	@Override
	public Customer getCustomerByEmail(String email) {
		Session session = HibernateUtil.getConnection();
		Transaction t = session.beginTransaction();
		String hql = "FROM Customer C WHERE C.email = C.email";
		Query query = session.createNamedQuery(hql);
		String result = (String) query.getSingleResult();
		System.out.println(result);
	
		return null;
	}

	@Override
	public void getCustomerOrders(List<Customer> customerorderlist) {
		Session session = HibernateUtil.getConnection();
		Transaction t = session.beginTransaction();
		String hql = "FROM Order";
		Query<Customer> query = session.createNamedQuery(hql);
		List<Customer> results = query.getResultList();
		
		for (Customer c : results) {
			System.out.println("Customer Id: " + c.getId() + " | " + "Customer Name: " + c.getName());
		}
		
	}
	
	

}
