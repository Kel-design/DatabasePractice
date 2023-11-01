package com.cupitmadland.abcinc.myinterface;

import java.util.List;

import com.cupitmadland.abcinc.model.Customer;

public interface CustomerDAO {
	
List<Customer> getAllCustomers();
	
	Customer getCustomerByEmail(String email);
	
	void getCustomerOrders(List<Customer> customerorderlist);


}
