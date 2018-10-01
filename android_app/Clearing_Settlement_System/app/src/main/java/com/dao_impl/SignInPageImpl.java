package com.dao_impl;
//comment1
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.connections.MyConnection;
import com.dao.SignInPage;

public class SignInPageImpl implements SignInPage {

	@Override
	public int login(String emailId, String password) {

		String login = "SELECT * FROM MEMBER WHERE memberEmail = ?";
		
		try(Connection con = MyConnection.openConnection()){
			PreparedStatement ps = con.prepareStatement(login);
			ps.setString(1, emailId);
			ResultSet rs =ps.executeQuery();
			while(rs.next()) {
				if(rs.getString(3).equals(password)){
					return 1;
				}
					
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
}
