package com.cupitmadland.bookdaojdbc.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cupitmadland.bookdaojdbc.daointerface.BookDao;
import com.cupitmadland.bookdaojdbc.daointerface.ConnectionDao;
import com.cupitmadland.bookdaojdbc.model.Book;

public class BookDaoImpl extends ConnectionDao implements BookDao{

	@Override
	public List<Book> getAllBooks() {
		try {
			
		Connection connection = ConnectionDao.getConnection();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM books");
		List bookList = new ArrayList<>();
		
		while(rs.next()) {
			Book b = new Book();
			b.setId(rs.getInt("id"));
			b.setIsbn(rs.getInt("isbn"));
			b.setBookName(rs.getString("bookName"));
			bookList.add(b);
		}
		return bookList;
		}catch(SQLException ex) {
			ex.printStackTrace();
			System.out.printf("SQL State: %s\n%s",ex.getSQLState() , ex.getMessage());
	
		}
		return null;
	}

	@Override
	public void saveBook(List<Book> bookList) {
		try {
			Connection con = ConnectionDao.getConnection();
			for (Book b: bookList) {
				String sqlQuery = "INSERT INTO books (id, isbn, bookName) VALUES(?,?,?)";
				PreparedStatement ps = con.prepareStatement(sqlQuery);
				ps.setInt(1, b.getId());
				ps.setInt(2, b.getIsbn());
				ps.setString(3, b.getBookName());
				int affectedRows = ps.executeUpdate();
				System.out.println(affectedRows + " row(s) affected");
			}
		}catch(SQLException e){
			e.printStackTrace();
			
		}
		
	}

	@Override
	public boolean deleteBook(int id) {
		try {
			Connection connection = ConnectionDao.getConnection();
			PreparedStatement ps = connection.prepareStatement("DELETE FROM books WHERE id=?");
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			if(i == 1) {
				return true;
			}
		}catch(SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		}
		return false;
	}

	@Override
	public boolean updateBook(Book book, int id) {
		
		try {
			
		
			Connection connection = ConnectionDao.getConnection();
			PreparedStatement ps = connection.prepareStatement("UPDATE book SET isbn=?, bookName=? WHERE id=?");
			ps.setInt(1, book.getIsbn());
			ps.setString(2, book.getBookName());
			ps.setInt(3, id);
			int i = ps.executeUpdate(); //this row returns how many rows were affected
			if (i == 1) {
				return true; // returns true if 1 row was affected
			}
					
		}catch(SQLException e) {
			e.printStackTrace();
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		}
		return false; // returns false if no rows were affected
	}

}
