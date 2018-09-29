package com.dao_impl;
//comment1
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.connections.MyConnection;
import com.dao.ResetPassword;

public class ResetPasswordImpl implements ResetPassword{

	@Override
	public int updatePassword(String newPassword, String memberMail) {
		// TODO Auto-generated method stub
		int rowsAdded = 0;
		String UPDATEPASSWORD = "update MEMBER set memberPassword = ? where memberEmail = ?";
		try(Connection con = MyConnection.openConnection()){
			PreparedStatement ps = con.prepareStatement(UPDATEPASSWORD);
			ps.setString(1, newPassword);
			ps.setString(2, memberMail);
			rowsAdded = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowsAdded;
	}

	@Override
	public int delPasswordFromTemplist(String memberMail) {
		
		int rowsRemoved = 0;
		
		String DELETETRADE = "DELETE FROM Temppasslist WHERE memberMail = ?";
		
		Connection con = MyConnection.openConnection();
		
		try {
			PreparedStatement ps = con.prepareStatement(DELETETRADE);
			ps.setString(1,memberMail);
			rowsRemoved = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowsRemoved;
		
	}

}
