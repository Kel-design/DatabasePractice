package com.cupitmadland.abcinc.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Order implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Date orderDate;
	private String product;
	
	
	
	
	public Order() {
		
	}

	public Order(int id, Date orderDate, String product) {
		super();
		this.id = id;
		this.orderDate = orderDate;
		this.product = product;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	
	@Override
	public String toString() {
		return "Order [id=" + id + ", orderDate=" + orderDate + ", product=" + product +  "]";
	}
	
	
	
	
	
	
	

}
