package com.dao_impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.connections.MyConnection;
import com.dao.CommonFunctionalities;
import com.dao.MemberDashboard;
import com.pojo.Member;
import com.pojo.ObligationReport;

public class MemberDashboardImpl implements MemberDashboard{


	@Override
	public int updateProfile(int memberId, Member member) {
		// TODO Auto-generated method stub
		int rowsUpdated = 0;
		String UpdateProfile = "UPDATE Member SET memberName=?, memberEmail=?, bankAcNo=?, dematAcNo=? WHERE memberId=?";
		try(Connection con = MyConnection.openConnection()){
			PreparedStatement ps = con.prepareStatement(UpdateProfile);
			ps.setString(1, member.getMemberName());
			ps.setString(2, member.getMemberEmail());
			ps.setInt(3, member.getBankAcNo());
			ps.setInt(4, member.getDematAcNo());
			ps.setInt(5, memberId);
			rowsUpdated = ps.executeUpdate();
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowsUpdated;
		
		
	}

	@Override
	public ObligationReport viewObligationReport(int memberId) {
		// TODO Auto-generated method stub
		ObligationReport obligReport = new ObligationReport();
		
		String ViewObligationReport = "select OBG_REPORT.batchNum, "
				+ "MEMBER.memberName, MEMBER.memberId, SECURITY.securityName, OBG_REPORT.quantity "
				+ "from obg_report, MEMBER, SECURITY "
				+ "where MEMBER.memberId = OBG_REPORT.memberId AND "
				+ "SECURITY.ISIN = OBG_REPORT.ISIN AND OBG_REPORT.memberId=? AND OBG_REPORT.batchNum = ?";
		
		Connection con = MyConnection.openConnection();
		CommonFunctionalities commonFunc = new CommonFunctionalitiesImpl();
		try {
			PreparedStatement ps = con.prepareStatement(ViewObligationReport);
			int batchNum = commonFunc.getNextBatchNum();
			ps.setInt(1, memberId);
			ps.setInt(2, batchNum);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				obligReport.setMemberId(rs.getInt("memberId"));
				obligReport.setBatchNum(batchNum);
				obligReport.setFundAmt(rs.getDouble("fundAmt"));
				obligReport.setISIN(rs.getInt("ISIN"));
				obligReport.setQuantity(rs.getInt("quantity"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return obligReport;
	}

}
