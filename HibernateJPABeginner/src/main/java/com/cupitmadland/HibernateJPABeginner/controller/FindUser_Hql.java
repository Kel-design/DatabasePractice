package com.cupitmadland.HibernateJPABeginner.controller;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.cupitmadland.HibernateJPABeginner.model.User;

public class FindUser_Hql {
	
	public void findUser() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		String hql = "FROM User"; // This is an example of HQL to get all records of user class
		Query<User> query = session.createQuery(hql);
		List<User> results = query.getResultList();
		
		for (User u : results) {
			System.out.println("User Id: " +u.getId() + "|" + " Full name: " + u.getFullname() + "|"+ "Email: " + u.getEmail()+ "|" + "password" + u.getPassword());
		}

	}
	public void findUserSelect() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		String hql = "SELECT u FROM User u"; // Example of HQL to get all the records
		Query query = session.createQuery(hql);
		List<User> list = query.getResultList();
		
		for (User u : list) {
			System.out.println("User Id: " +u.getId() + "|" + " Full name: " + u.getFullname() + "|"+ "Email: " + u.getEmail()+ "|" + "password" + u.getPassword());
		}

		
	}
	
	public void getRecordbyId() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		String hql = "FROM User E WHERE E.id > 2 ORDER BY E.salary DESC";
		Query query = session.createQuery(hql);
		List<User> list = query.getResultList();
		
		for (User u : list) {
			System.out.println("User Id: " +u.getId() + "|" + " Full name: " + u.getFullname() + "|"+ "Email: " + u.getEmail()+ "|" + "password" + u.getPassword());
		// my results returned: (which I think is correct b/c I have id's 1, 2, 4 & 5 left in my table. These two have id's >2 and
			//were listed in DESC order by salary)
			//User Id: 4| Full name: Christ|Email: christ@gmail.com|password147852
			//User Id: 5| Full name: Sid|Email: Sid|passwords258 
			
		}
		
	}
	
	public void getRecords() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Query<Object[]> query = session.createQuery("SELECT U.salary, U.fullname FROM User AS U", Object[].class);
		List<Object[]> results = query.getResultList();
		
		for (Object[] a : results) {
			System.out.println("Salary: " + a[0] + ", City: " + a[1]);
		}
	}
	
	public void getmaxSalary() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		String hql = "SELECT max(U.salary) FROM User U";
		Query query = session.createQuery(hql);
		double result =(double) query.getSingleResult();
		System.out.println(result);
		
		//ALSO AVAILABLE TO GET NUMBER OF ROWS FROM USER TABLE 
		//String hql = "SELECT COUNT(*) FROM User U";
		//List results = session.createQuery(hql).getResultList();
		//System.out.println(results);
	
	}
	
	public void getmaxSalaryGroupBy() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		String hql = "SELECT SUM(U.salary), U.city FROM User U GROUP BY U.city";
		Query query = session.createQuery(hql);
		List<Object[]> result =query.getResultList();
		
		for (Object[] o : result){
			System.out.println("Total salary " +o[0] +" | city: " + o[1] );
		}
	}
	
	public void NamedQueryExample() {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		String hql = "FROM User u WHERE u.id = :id";
		Query<User> query = session.createQuery(hql);
		query.setParameter("id", 2);
		List<User> result = query.getResultList();
		
		for (User u : result) {
			System.out.println("User Id: " +u.getId() + "|" + " Full name: " + u.getFullname() + "|"+ "Email: " + u.getEmail()+ "|" + "password" + u.getPassword());
		
		}
	}

}


