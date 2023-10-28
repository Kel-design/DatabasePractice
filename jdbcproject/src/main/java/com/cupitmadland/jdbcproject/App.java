package com.cupitmadland.jdbcproject;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class App 
{
    public static void main( String[] args ) throws ClassNotFoundException, SQLException {
    	
        Class.forName("com.mysql.cj.jdbc.Driver"); //optional
        
        String url = "jdbc:mysql://localhost:3306/classicmodels";
        String user = "root";
        String password = "root";
        
        Connection connection = DriverManager.getConnection(url, user, password);
        
        String selectSql = "Select * from employees";
        Statement stmt = connection.createStatement();
        
        ResultSet result = stmt.executeQuery(selectSql);
        
//        while(result.next()) {
//        	String firstname = result.getString("firstName");
//        	String lastname = result.getString("lastName");
//        	String email = result.getString("email");
//        	int reportsTo = result.getInt("reportsTo");
//        	
//        	System.out.println(firstname + " " + lastname + " | " + email + "| " + reportsTo);
//        	
//        }
        //connection.close();
        //getEmployeeById(1504, connection);
        //insertEmployee(connection);
        //updateEmployee(connection);
        updateExtension(connection);
        
    }//end of main method
    
    public static void getEmployeeById(int id, Connection conn) throws SQLException {
    	PreparedStatement ps = conn.prepareStatement(SqlQueries.GetEmployeeById);
    	ps.setInt(1, id);
    	
    	ResultSet result = ps.executeQuery();
    	
    	while(result.next()) {
    		String firstName = result.getString("firstName");
    		String email = result.getString("email");
    		String jobTitle = result.getString("jobTitle");
    		int reportsTo = result.getInt("reportsTo");
    		System.out.println(firstName + " | " + email + " | " + jobTitle + " |" + reportsTo);
    	}
    }// end of getEmplyeeById method
    
    public static void insertEmployee(Connection connection) throws SQLException {
    	String sqlQuery = "Insert into employees(officeCode, firstName, lastName, email, extension, reportsTo, VacationHours, employeeNumber, jobTitle) "
    			+ "values (?,?,?,?,?,?,?,?,?)";
    	PreparedStatement ps = connection.prepareStatement(sqlQuery);
    	
    	ps.setInt(1, 6);
    	ps.setString(2, "Mary");
    	ps.setString(3, "Sawyers");
    	ps.setString(4, "mary@gmail.com");
    	ps.setString(5, "1234");
    	ps.setInt(6, 1143);
    	ps.setInt(7, 9);
    	ps.setInt(8, 1114);
    	ps.setString(9, "Developer");
    	
    	int affectedRows = ps.executeUpdate();
    	System.out.println(affectedRows + " row(s) affected.");
    	
    	
    			
    	
    }//end of insertEmployee method
    
    public static void updateEmployee(Connection connection) throws SQLException {
    	
    	String selectSql = "UPDATE employees set firstName = ?, lastName=? where employeeNumber=?";
    	
    	PreparedStatement stmt = connection.prepareStatement(selectSql);
    	stmt.setString(1, "Ms. " +  "Tonya");
    	stmt.setString(2, "Thomas");
    	stmt.setInt(3, 1114);
    	
    	stmt.executeUpdate();
     	
  
    	
    }//end of updateEmployee method
    
    
    //Update the extension number of employees whose officeCode is 2, and the new extension number will be “5698.” 
    
    public static void updateExtension(Connection connection) throws SQLException {
    	String query = "UPDATE employees set extension = ? where officeCode = ?";
    	
    	PreparedStatement ps = connection.prepareStatement(query);
    	ps.setString(1,"5698");
    	ps.setString(2,"2");
    	
    	ps.executeUpdate();
    	
    }//end of updateExtension method
    
    
}//end of App class
