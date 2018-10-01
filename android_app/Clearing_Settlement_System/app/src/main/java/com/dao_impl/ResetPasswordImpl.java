package com.dao_impl;
//comment1
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.connections.MyConnection;
import com.dao.ResetPassword;

public class ResetPasswordImpl implements ResetPassword{

	@Override
	public int updatePassword(String currentPassword, String newPassword, int memberId) {
		// TODO Auto-generated method stub
		int rowsAdded = 0;
		String UPDATEPASSWORD = "update MEMBER set memberPassword = ? where memberId = ?";
		try(Connection con = MyConnection.openConnection()){
			PreparedStatement ps = con.prepareStatement(UPDATEPASSWORD);
			ps.setString(1, currentPassword);
			ps.setInt(2, memberId);
			rowsAdded = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowsAdded;
	}

}
