package com.dao_impl;
//comment1
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.connections.MyConnection;
import com.dao.CommonFunctionalities;
import com.dao.ResetPassword;
import com.pojo.Member;

public class ResetPasswordImpl implements ResetPassword{

	@Override
	public boolean updatePassword(String currentPassword, String newPassword, String memberId) {
		// TODO Auto-generated method stub
		CommonFunctionalities commonFunc = new CommonFunctionalitiesImpl();
		Member temp = commonFunc.viewProfile(memberId);
		String email = temp.getEmail();
		String UPDATE_PASSWORD = "update user_details set userPassword=? where userEmailId=?";
		try(Connection con = MyConnection.openConnection()){
			PreparedStatement ps = con.prepareStatement(UPDATE_PASSWORD);
			ps.setString(1, currentPassword);
			ps.setString(2, email);
			ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
