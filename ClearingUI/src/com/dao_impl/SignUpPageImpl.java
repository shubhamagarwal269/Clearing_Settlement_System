package com.dao_impl;
//comment1
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.connections.MyConnection;
import com.dao.SignUpPage;
import com.pojo.Member;
import com.pojo.UserDetails;

public class SignUpPageImpl implements SignUpPage{

	@Override
	public int registerMember(Member member, UserDetails user) {
		// TODO Auto-generated method stub
		
		// check error in 1 affects another ? 
		String bankAccNumber = "abc";
		String dematAccNumber = "";
		int rowsAdded = 0;
		String AddMember = "INSERT INTO Member VALUES(?,?,?,?,?)";
		Connection con = MyConnection.openConnection();
		
		try {
			con.setAutoCommit(false);
			PreparedStatement ps = con.prepareStatement(AddMember);
			ps.setString(1,member.getMemberId());
			ps.setString(2, member.getName());
			ps.setString(3, member.getEmail());
			ps.setString(4, member.getBankAcNo());
			bankAccNumber = member.getBankAcNo();
			ps.setString(5, member.getDematAcNo());
			dematAccNumber = member.getDematAcNo();
			
			rowsAdded = ps.executeUpdate();
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int rowsAdded1 = 0;
		String addUser = "INSERT INTO User_Details VALUES(?,?,?)";
		Connection con1 = MyConnection.openConnection();
		if(rowsAdded>0 ) {
		try {
		
			con1.setAutoCommit(false);
			PreparedStatement ps = con1.prepareStatement(addUser);
			ps.setString(1,user.getEmail());
			ps.setString(2, user.getUserPass());
			ps.setInt(3, user.getUserType());
			
			rowsAdded1 = ps.executeUpdate();
			System.out.println("h1");
			
		
		} catch (SQLException e) {
			try {
				con1.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		if(rowsAdded>0 && rowsAdded1>0)
		{	
			try {
				
				con.commit();
				con1.commit();
				
				String addBA = "INSERT INTO Bank_Details VALUES(?,?)";
				//System.out.println("hello");
				Connection con2 = MyConnection.openConnection();
				PreparedStatement ps = con2.prepareStatement(addBA);
				ps.setString(1,bankAccNumber);
				ps.setFloat(2, 0);
				ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
			
		return 1;
		
	}



}
