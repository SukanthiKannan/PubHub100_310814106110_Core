package com.bookapp.dao;

import java.sql.SQLException;

import com.bookapp.model.Books;

public class TestBooksDAO {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		Books books = new Books();
		Books books1 = new Books();
		Books books2 = new Books();
		books.setBookName("Harry Potter");
		books.setAuthor("J.K.Rowling");
		books.setPrice(299);
		books1.setId(11);
		books1.setPrice(300);
	
		books2.setId(11);
		books2.setBookName("Brida");
		
		BooksDAO dao = new BooksDAO();	
		
		dao.addBook(books);
		dao.update(books1);
		dao.delete(books2);
		dao.findByName(books2);
		
		dao.listAll();

	}


}
