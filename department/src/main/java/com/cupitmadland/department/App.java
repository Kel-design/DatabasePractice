package com.cupitmadland.department;

import com.cupitmadland.department.controller.DepartmentService;

public class App 
{
    public static void main( String[] args )
    {
    	
    	DepartmentService obj = new DepartmentService();
    	
    	//obj.createDepartmentTable();
    	
    	//obj.createDepartment();
    	
    	//obj.findDepartment(2);
    	
    	//obj.updateDepartment(2);
    	
    	obj.deleteDepartment(5);
    	
    	
      
    }
}
