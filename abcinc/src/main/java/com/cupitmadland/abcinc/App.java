package com.cupitmadland.abcinc;

import com.cupitmadland.abcinc.service.CustomerService;
import java.util.ArrayList;

public class App 
{
    public static void main( String[] args )
    {
      CustomerService obj = new CustomerService();
      obj.createCustomerTable();
      
    
      
    }
}
