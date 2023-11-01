package com.cupitmadland.abcinc.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.cupitmadland.abcinc.model.Order;
import com.cupitmadland.abcinc.myinterface.OrderDAO;
import com.cupitmadland.abcinc.service.HibernateUtil;

public class OrderService implements OrderDAO{
	
	private ArrayList<Order> orderObj;

	public void createOrderTable() {
		Session session = HibernateUtil.getConnection();
		Transaction t = session.beginTransaction();
		
		Order order = new Order ();
		t.commit();
		System.out.println("Successfully created Order table");
		
		session.close();
	}
	
	public void createOrder() {
		Session session = HibernateUtil.getConnection();
		Transaction t = session.beginTransaction();
		
		Order oOne = new Order();
		oOne.setOrderDate(null);
		oOne.setProduct("Candle");
		
		
		Order oTwo = new Order();
		oTwo.setOrderDate(null);
		oTwo.setProduct("Pillow");
		
		
		Order oThree = new Order();
		oThree.setOrderDate(null);
		oThree.setProduct("Tea Kettle");
		
		
		List<Order> orderList = new ArrayList<Order>();
		
		orderList.add(oOne);
		orderList.add(oTwo);
		orderList.add(oThree);
		
		session.persist(oOne);
		session.persist(oTwo);
		session.persist(oThree);
		
		t.commit();
    	System.out.println("Successfully Saved");
    	
    	session.close();
		
	}
	
	@Override
	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
		return null;
	}

}
