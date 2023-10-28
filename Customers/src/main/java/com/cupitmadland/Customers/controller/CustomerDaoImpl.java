package com.cupitmadland.Customers.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cupitmadland.Customers.daointerface.ConnectionDao;
import com.cupitmadland.Customers.daointerface.CustomerDao;
import com.cupitmadland.Customers.model.Customer;

public class CustomerDaoImpl extends ConnectionDao implements CustomerDao{
	
	private ArrayList<Customer> customerObj;

	@Override
	public List<Customer> getAllCustomers() {
		try {
		Connection connection = ConnectionDao.getConnection();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM customers");
		List customerList = new ArrayList<>();
		
		
		while (rs.next());{
			Customer c = new Customer();
			c.setId(rs.getInt("id"));
			c.setEmail(rs.getString("email"));
			c.setFname(rs.getString("fname"));
			c.setLname(rs.getString("lname"));
			customerList.add(c);
		}
	
		return customerList;
		}catch(SQLException ex) {
			ex.printStackTrace();
			System.out.printf("SQL State: %s\n%s", ex.getSQLState(), ex.getMessage());
		}
		return null;
		}

	public void  getCustomerById(int id, Connection con) {
		try {
		
		PreparedStatement ps = con.prepareStatement("SELECT CUSTOMER FROM customers WHERE id=?");
		ps.setInt(1, id);
		ResultSet result = ps.executeQuery();
		
		while(result.next()) {
			
			String fname = result.getString("fname");
			String lname = result.getString("lname");
			System.out.println(fname + " " + lname);
			
			
		}
		
	}catch(SQLException e) {
		System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
	}
		return null;
	}
	
	@Override
	public void saveCustomer(List<Customer> customerList) {
		try {
			Connection con = ConnectionDao.getConnection();
			for (Customer c: customerList) {
				String sqlQuery = "INSERT INTO customers (id, email, fname, lname) VALUES(?,?,?,?)";
				PreparedStatement ps = con.prepareStatement(sqlQuery);
				ps.setInt(1, c.getId());
				ps.setString(2, c.getEmail());
				ps.setString(3, c.getFname());
				ps.setString(4, c.getLname());
				int affectedRows = ps.executeUpdate();
				System.out.println(affectedRows + " row(s) affected");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addCustomer(Customer c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean removeCustomerById(int id) {
		try {
			Connection con = ConnectionDao.getConnection();
			PreparedStatement ps = con.prepareStatement("DELETE CUSTOMERS FROM customers WHERE id=?");
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			if(i == 1 ) {
				return true;
			}	
		}catch(SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		}
		return false;
	}

}
