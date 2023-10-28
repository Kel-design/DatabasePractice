package com.cupitmadland.Customers.daointerface;

import java.sql.Connection;
import java.util.List;

import com.cupitmadland.Customers.model.Customer;

public interface CustomerDao {
	
	List<Customer> getAllCustomers();
	void saveCustomer(List<Customer> customerList);
	void getCustomerById(int id, Connection con);
	void addCustomer(Customer c);
	boolean removeCustomerById(int id);

}
