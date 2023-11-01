package com.cupitmadland.hibernateuser.controller;

import java.util.List;


import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cupitmadland.hibernateuser.model.User;
import com.cupitmadland.hibernateuser.util.HibernateUtil;

public class HibernateQueryLang {
	
	/**
	 * FROM Clause:
	 */
			
	
	
	public void useFromClause() {
		Session session = HibernateUtil.getConnection();
		String hql = "FROM User";
		TypedQuery<User> query = session.createQuery(hql, User.class);
		List<User>results = query.getResultList();
		
		for(User u: results) {
			System.out.println("User Id: " + u.getId() + " |" + "Full Name: " + u.getFullname() + " |" + "Email: " + u.getEmail()+ " |" + "Password: " + u.getPassword());
		}
		
	}
	
	public void useWhereClause() {
		Session session = HibernateUtil.getConnection();
		String hql = "FROM User u WHERE u.id = 2";
		TypedQuery<User> query = session.createQuery(hql, User.class);
		List<User>results = query.getResultList();
}
	public void useOrderByClause() {
		Session session = HibernateUtil.getConnection();
		String hql = "FROM User E WHERE E.id > 3 ORDER BY E.salary DESC ";
		TypedQuery<User> query = session.createQuery(hql, User.class);
		List<User> results = query.getResultList();
		
		for(User u: results) {
			System.out.println("User Id: " + u.getId() + " |" + "Full Name: " + u.getFullname() + " |" + "Email: " + u.getEmail()+ " |" + "Password: " + u.getPassword());
	}
	}
	
	public void useMultiSelectExpressionClause() {
		Session session = HibernateUtil.getConnection();
		TypedQuery<Object[]> query = session.createQuery("SELECT U.salary, U.fullname FROM User AS U", Object[].class); // U is the alias
		List<Object []> results = query.getResultList(); //generic list to sort the results
		
		for(Object[] a : results) //loop through the generic list and place in variable a
		{
			System.out.println("Salary: " + a[0] + ", Full Name: " + a[1]); //
		}
		
}
	
	public void useGroupByClause() {
		Session session = HibernateUtil.getConnection();
		String hql = "SELECT SUM(U.salary), U.city FROM User U GROUP BY U.city";
		TypedQuery<Object[]> query = session.createQuery(hql, Object[].class);
		List<Object []> results = query.getResultList();
		
		for(Object[] o : results) {
			System.out.println("Total salary: "+ o[0] + " | city: " + o[1]);
		}
		
	}
	public void useNameParameters() {
		Session session = HibernateUtil.getConnection();
		String hql = "FROM User u WHERE u.id = :id"; // :id is parameter to specify which record # we want to query
		TypedQuery<User> query = session.createQuery(hql, User.class);
		query.setParameter("id", 4); //set manually but usually put in the method parameters 
		List<User> result = query.getResultList();
		
		for(User u: result) {
			System.out.println("User Id: " + u.getId() + " |" + "Full Name: " + u.getFullname() + " |" + "Email: " + u.getEmail()+ " |" + "Password: " + u.getPassword());
	}
	}
	
//	public void updateUser() {
//		Session session = HibernateUtil.getConnection();
//		Transaction t = session.beginTransaction();
//		TypedQuery<?> query = session.getNamedQuery("updateMyUser");
//		query.setParameter("fullname", "Kelly Madland");
//		query.setParameter("id", 2);
//		int rowsAffected = query.executeUpdate();
//		System.out.println(rowsAffected + " rows were affected");
//		
//		t.commit();
//		System.out.println("Successfully Updated User");
	
	// FIX THE ABOVE METHOD!!
		
	}




