package com.cupitmadland.bookdaojdbc.model;

public class Book {
	
	
	private int id;
	private int isbn;
	private String bookName;
	
	public Book() {
		this.id = 0;
		this.isbn = 0;
		this.bookName = "";
		
		
	}
	public Book(int isbn, String bookName) {
		super();
		this.isbn = isbn;
		this.bookName = bookName;
	}
	
 
	public Book(int id, int isbn, String bookName) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.bookName = bookName;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getIsbn() {
		return isbn;
	}


	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}


	public String getBookName() {
		return bookName;
	}


	public void setBookName(String bookName) {
		this.bookName = bookName;
	}


	@Override
	public String toString() {
		return "Book [id=" + id + ", isbn=" + isbn + ", bookName=" + bookName + "]";
	}
	
	
	
	
	

}
