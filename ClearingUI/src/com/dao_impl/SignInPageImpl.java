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
	public boolean login(int userType, String emailId, String password) {

		String login = "SELECT * FROM user_details WHERE useremailId = ?";
		
		try(Connection con = MyConnection.openConnection()){
			PreparedStatement ps = con.prepareStatement(login);
			ps.setString(1, emailId);
			ResultSet rs =ps.executeQuery();
			while(rs.next()) {
		
				if(rs.getString(2).equals(password) && rs.getInt(3)==userType)
				{
					System.out.println("Successful login");
					return true;
				}
					
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
}
