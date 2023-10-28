package com.cupitmadland.item.daointerface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionDao {
		
		static Connection conn = null;
		protected PreparedStatement ps = null;
		protected ResultSet rs = null;
		
		public static Connection getConnection() {
			final String dburl = "jdbc:mysql://localhost:3306/Customers";
			final String dbuser = "root";
			final String dbpassword = "root";
			try {
				conn = DriverManager.getConnection(dburl, dbuser, dbpassword);
				System.out.println("Connected Database Successfully");
			}catch (SQLException e) {
				System.out.println(e);
				e.printStackTrace();
				
			}
			
			return conn;
		}
		
		public void disconnect()
		   {
		      try {
		         if(rs != null)
		         {
		            rs.close();
		         }
		         if(ps != null)
		         {
		            ps.close();
		         }
		         if(conn != null)
		         {
		            conn.close();
		         }
		        
		      }catch (Exception e) {
		        
		      }
		     
		   
		}

}
