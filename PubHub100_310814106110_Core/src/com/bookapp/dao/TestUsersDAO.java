package com.bookapp.dao;

import java.sql.SQLException;

import com.bookapp.model.Users;

public class TestUsersDAO {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		Users users = new Users();
		users.setUserName("Arun");
		users.setEmail("Arun@gmail.com");
		users.setPassword("pass1");
		users.setActive(1);

		UsersDAO dao = new UsersDAO();
		//dao.register(users);
		dao.login(users);
	}

}
