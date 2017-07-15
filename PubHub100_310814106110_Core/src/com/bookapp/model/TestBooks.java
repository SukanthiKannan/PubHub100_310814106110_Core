package com.bookapp.model;

public class TestBooks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Books books = new Books();
		books.setBookName("The Alchemist");
		books.setAuthor("Paulo Cohelo");
		System.out.println(books.getBookName());
		System.out.println(books.getAuthor());
	}

}
