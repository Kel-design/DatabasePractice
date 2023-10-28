package com.cupitmadland.bookdaojdbc;
import java.util.ArrayList;

import com.cupitmadland.bookdaojdbc.controller.BookDaoImpl;
import com.cupitmadland.bookdaojdbc.daointerface.*;

import com.cupitmadland.bookdaojdbc.model.Book;


public class App 
{
    public static void main( String[] args )
    {
       BookDao obj = new BookDaoImpl();
       obj.getAllBooks();
       //System.out.println(obj.getAllBooks());
       
       ArrayList<Book> booklist = new ArrayList<Book>();
       booklist.add(new Book(7,107, "Brain Development"));
       obj.saveBook(booklist);
       System.out.println("--------Book inserted Successfully-------");
      
//       obj.deleteBook(6);
//       System.out.println("--------Book deleted Successfully-------");
//        
//       
//       Book bookObj = new Book(150, "Intermediate Java Book");
//       obj.updateBook(bookObj, 4);
//       System.out.println("--------Book updated Successfully-------");
//       
       
       
    }
}
