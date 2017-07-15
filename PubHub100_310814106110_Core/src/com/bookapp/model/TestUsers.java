package com.bookapp.model;

public class TestUsers {

	public static void main(String[] args) {

		Users users = new Users();
		users.setUserName("Sukanthi");
		System.out.println("user:" + users.getUserName());

		users.setEmail("sukanthi@gmail.com");
		System.out.println("email:" + users.getEmail());

		users.setPassword("password");
		System.out.println("password:" + users.getPassword());

		users.setActive(1);
		System.out.println("active:" + users.getActive());

	}
}
