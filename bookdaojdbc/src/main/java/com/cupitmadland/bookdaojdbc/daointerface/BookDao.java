package com.cupitmadland.bookdaojdbc.daointerface;

import java.util.List;

import com.cupitmadland.bookdaojdbc.model.Book;

public interface BookDao {
	
	List<Book> getAllBooks();
	void saveBook(List<Book> bookList);
	boolean deleteBook(int id);
	boolean updateBook(Book book, int id);

}
