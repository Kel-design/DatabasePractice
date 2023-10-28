
package com.cupitmadland.Customers;

import java.util.ArrayList;

import com.cupitmadland.Customers.controller.CustomerDaoImpl;
import com.cupitmadland.Customers.model.Customer;

public class App 
{
    public static void main( String[] args )
    {
      CustomerDaoImpl obj = new CustomerDaoImpl();
      
//      ArrayList<Customer> customerlist = new ArrayList<Customer>();
//      customerlist.add(new Customer(8, "brian@gmail.com", "Brian", "Busfield"));
//      obj.saveCustomer(customerlist);
//      System.out.println("--------Customer added Successfully-------");
      
      //obj.removeCustomerById(8);
      //System.out.println("--------Customer(s) deleted Successfully-------");
      
      obj.getCustomerById(4, );
      System.out.println("---------Customer(s) retrieved Successfully--------");
      
      
      
    }
}
