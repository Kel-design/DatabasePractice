package com.cupitmadland.Customers.model;

public class Customer {

	private int id;
	private String email;
	private String fname;
	private String lname;
	
	public Customer() {
		this.id=0;
		this.email="";
		this.fname="";
		this.lname="";
	}
	
	public Customer(int id, String email, String fname, String lname) {
		super();
		this.id = id;
		this.email = email;
		this.fname = fname;
		this.lname = lname;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", email=" + email + ", fname=" + fname + ", lname=" + lname + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}
}
