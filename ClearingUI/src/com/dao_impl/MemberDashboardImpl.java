package com.dao_impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.connections.MyConnection;
import com.dao.MemberDashboard;
import com.pojo.Member;
import com.pojo.ObligationReport;
import com.pojo.Pair;
import com.pojo.Security;
import com.pojo.SettlementReport;
import com.pojo.Trade;

public class MemberDashboardImpl implements MemberDashboard{


	@Override
	public boolean updateProfile(String memberId, Member member) {
		// TODO Auto-generated method stub
		boolean isUpdated = false;
		String UpdateProfile = "UPDATE Member SET name=?, email=?, bankAcNo=?, dematAcNo=? WHERE memberId=?";
		try(Connection con = MyConnection.openConnection()){
			PreparedStatement ps = con.prepareStatement(UpdateProfile);
			ps.setString(1, member.getName());
			ps.setString(2, member.getEmail());
			ps.setString(3, member.getBankAcNo());
			ps.setString(4, member.getDematAcNo());
			ps.setString(5, memberId);
			int rows = ps.executeUpdate();
			if(rows>0) {
				isUpdated = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isUpdated;
		
		
	}

	@Override
	public ObligationReport viewObligationReport(String memberId, Date tradeDate) {
		// TODO Auto-generated method stub
		ObligationReport obligReport = new ObligationReport();
		String ViewObligationReport = "select OBG_REPORT.reportId, OBG_REPORT.duedate, "
				+ "MEMBER.memberName, MEMBER.memberId, SECURITY.securityName, quantity "
				+ "from obg_report, MEMBER, SECURITY "
				+ "where MEMBER.memberId = OBG_REPORT.memberId AND "
				+ "SECURITY.ISIN = OBG_REPORT.ISIN AND OBG_REPORT.memberId=? ";
		Connection con = MyConnection.openConnection();
		try {
			PreparedStatement ps = con.prepareStatement(ViewObligationReport);
			ps.setString(1, memberId);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				obligReport.setReportId(rs.getString(1));
				obligReport.setDueDate(rs.getDate(2));
				obligReport.setMemberName(rs.getString(3));
				obligReport.setMemberId(rs.getString(4));
				obligReport.setSecurityName(rs.getString(5));
				obligReport.setQuantity(rs.getInt(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return obligReport;
	}

	@Override
	public SettlementReport viewSettlementReport(String memberId, Date tradeDate) {
		// TODO Auto-generated method stub
		SettlementReport settleReport = new SettlementReport();
		String ViewSettlementnReport = "select SETT_REPORT.reportId, SETT_REPORT.duedate, "
				+ "MEMBER.memberName, MEMBER.memberId,SECURITY.securityName, quantity "
				+ "from obg_report, MEMBER, SECURITY "
				+ "where MEMBER.memberId = SETT_REPORT.memberId AND "
				+ "SECURITY.ISIN = SETT_REPORT.ISIN AND "
				+ "SETT_REPORT.memberId=?";
		Connection con = MyConnection.openConnection();
		try {
			PreparedStatement ps = con.prepareStatement(ViewSettlementnReport);
			ps.setString(1, memberId);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				settleReport.setReportId(rs.getString(1));
				settleReport.setDueDate(rs.getDate(2));
				settleReport.setMemberName(rs.getString(3));
				settleReport.setMemberId(rs.getString(4));
				settleReport.setSecurityName(rs.getString(5));
				settleReport.setQuantity(rs.getInt(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return settleReport;
	}


	}
