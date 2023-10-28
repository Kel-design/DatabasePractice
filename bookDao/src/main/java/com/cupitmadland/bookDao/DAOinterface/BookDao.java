package com.cupitmadland.bookDao.DAOinterface;

import java.util.List;

import com.cupitmadland.bookDao.model.Books;

public interface BookDao {
	
	List<Books> getAllBooks();
	
		Books getBookByIsbn(int isbn);
		
		void saveBook(Books book);
		
		void deleteBook(Books book);

}
