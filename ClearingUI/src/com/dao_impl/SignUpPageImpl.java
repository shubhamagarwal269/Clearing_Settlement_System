package com.dao_impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.connections.MyConnection;
import com.dao.CommonFunctionalities;
import com.dao.SignUpPage;
import com.pojo.Member;

public class SignUpPageImpl implements SignUpPage{

	@Override
	public int registerMember(Member member) {
		// TODO Auto-generated method stub
		
		int bankAcNumber = 0;
		int dematAcNumber = 0;
		int rowsAdded = 0;
		String AddMember = "INSERT INTO Member VALUES(?,?,?,?,?,?)";
		
		
		try(Connection con = MyConnection.openConnection()){
			PreparedStatement ps = con.prepareStatement(AddMember);
			ps.setInt(1, member.getMemberId());
			ps.setString(2, member.getMemberName());
			ps.setString(3, member.getMemberPassword());
			ps.setString(4, member.getMemberEmail());
			ps.setInt(5, member.getBankAcNo());
			bankAcNumber = member.getBankAcNo();
			ps.setInt(6, member.getDematAcNo());
			dematAcNumber = member.getDematAcNo();
			
			rowsAdded = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if(rowsAdded>0){	
			try {	
				String addBA = "INSERT INTO Bank_Details VALUES(?,?,?)";
				Connection con = MyConnection.openConnection();
				PreparedStatement ps = con.prepareStatement(addBA);
				ps.setInt(1,bankAcNumber);
				ps.setInt(2, member.getMemberId());
				ps.setDouble(3, 100000);
				rowsAdded += ps.executeUpdate();
				String addDA = "INSERT INTO Demat_Details VALUES(?,?,?,?)";
				ps = con.prepareStatement(addDA);
				CommonFunctionalities commonFunc = new CommonFunctionalitiesImpl();
				int noOfSecurities = commonFunc.getNumOfSecurity();
				for(int i=0;i<noOfSecurities;i++) {
					ps.setInt(1,dematAcNumber);
					ps.setInt(2,member.getMemberId());
					ps.setInt(3,i);
					ps.setInt(4,1000);
					rowsAdded += ps.executeUpdate();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		return rowsAdded;
		
	}



}
