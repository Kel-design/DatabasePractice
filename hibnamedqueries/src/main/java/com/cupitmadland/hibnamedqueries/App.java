package com.cupitmadland.hibnamedqueries;

import com.cupitmadland.hibnamedqueries.controller.EmployeeController;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        EmployeeController e = new EmployeeController();
        //e.createEmployeeTable();
        //e.findEmployeeByName();
        //e.findEmployeeById();
        e.showOfficeCodes_AsDepartment();
    }
}
