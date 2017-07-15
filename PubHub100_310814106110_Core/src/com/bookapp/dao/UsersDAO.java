package com.bookapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bookapp.model.Users;
import com.bookapp.util.ConnectionUtil;

public class UsersDAO {

	public void register(Users users) {

		Connection connection = ConnectionUtil.getConnection();

		PreparedStatement pst;
		try {
			pst = connection
					.prepareStatement("INSERT INTO Users (user_name,email_id,PASSWORD,active) VALUES (?,?,?,?)");
			pst.setString(1, users.getUserName());
			pst.setString(2, users.getEmail());
			pst.setString(3, users.getPassword());
			pst.setInt(4, users.getActive());

			int rows = pst.executeUpdate();
			System.out.println("No. of rows inserted:" + rows);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean login(Users users) {

		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pst;
		try {
			pst = connection.prepareStatement("SELECT user_name FROM Users WHERE email_id=? AND PASSWORD=?");
			pst.setString(1, users.getEmail());
			pst.setString(2, users.getPassword());

			ResultSet rs = pst.executeQuery();

			boolean flag = false;

			if (rs.next()) {
				flag = true;

			}
			boolean result = flag;
			System.out.println(result);
			return flag;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

}
