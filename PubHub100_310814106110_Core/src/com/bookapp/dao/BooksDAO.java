package com.bookapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookapp.model.Books;
import com.bookapp.util.ConnectionUtil;

public class BooksDAO {
	
	public void addBook(Books books) {

		Connection connection = ConnectionUtil.getConnection();

		PreparedStatement pst;
		try {
			pst = connection.prepareStatement("INSERT INTO Books(book_name,author,price)VALUES(?,?,?)");
			pst.setString(1, books.getBookName());
			pst.setString(2, books.getAuthor());
			pst.setInt(3, books.getPrice());

			int rows = pst.executeUpdate();
			System.out.println("No. of rows inserted:" + rows);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void update(Books books) {

		Connection connection = ConnectionUtil.getConnection();

		PreparedStatement pst;
		try {
			pst = connection.prepareStatement("UPDATE Books SET price=? WHERE id=?");
			pst.setInt(1, books.getPrice());
			pst.setInt(2, books.getId());

			int rows = pst.executeUpdate();
			System.out.println("No. of rows updated:" + rows);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void delete(Books books) {

		Connection connection = ConnectionUtil.getConnection();

		PreparedStatement pst;
		try {
			pst = connection.prepareStatement("DELETE FROM Books WHERE id=? AND book_name=?");
			pst.setInt(1, books.getId());
			pst.setString(2, books.getBookName());

			int rows = pst.executeUpdate();
			System.out.println("No. of rows deleted:" + rows);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Books> listAll() {

		Connection connection = ConnectionUtil.getConnection();

		PreparedStatement pst;
		try {
			pst = connection.prepareStatement("SELECT id,book_name,author,price FROM Books");
			ResultSet rs = pst.executeQuery();
			List<Books> books1 = new ArrayList<>();

			while (rs.next()) {

				Books books = new Books();
				books.setId(rs.getInt(1));
				books.setBookName(rs.getString(2));
				books.setAuthor(rs.getString(3));
				books.setPrice(rs.getInt(4));
				books1.add(books);
			}
			System.out.println("No. of books available:" + books1.size());
			return books1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public List<Books> findByName(Books books)  {

		Connection connection = ConnectionUtil.getConnection();

		PreparedStatement pst;
		try {
			pst = connection
					.prepareStatement("SELECT id,book_name,author,price FROM Books WHERE book_name=?");
			pst.setString(1, books.getBookName());

			ResultSet rs = pst.executeQuery();
			List<Books> book = new ArrayList<>();

			while (rs.next()) {

				Books books1 = new Books();
				books1.setId(rs.getInt(1));
				books1.setBookName(rs.getString(2));
				books1.setAuthor(rs.getString(3));
				books1.setPrice(rs.getInt(4));
				book.add(books1);
			}
			System.out.println("Search Result is:" + book.size());
			return book;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}


}
