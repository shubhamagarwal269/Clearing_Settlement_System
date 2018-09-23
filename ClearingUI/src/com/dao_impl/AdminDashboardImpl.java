package com.dao_impl;
//comment

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.connections.MyConnection;
import com.dao.AdminDashboard;
import com.dao.CommonFunctionalities;
import com.pojo.ObligationReport;
import com.pojo.SettlementReport;
import com.pojo.Trade;

public class AdminDashboardImpl implements AdminDashboard{


	@Override
	public boolean applyNetting(List<Trade> tradeList) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addNewTrade(Trade trade) {
		// TODO Auto-generated method stub
		int rowsAdded = 0;
		boolean status = false;
		CommonFunctionalities commonFunc = new CommonFunctionalitiesImpl();
		String tradeId = commonFunc.getNextTradeId();
		String ADDTRADE = "INSERT INTO TRADE VALUES(?,?,?,?,?,?,?,?,?)";
		Connection con = MyConnection.openConnection();
		try {
			PreparedStatement ps = con.prepareStatement(ADDTRADE);
			ps.setString(1,tradeId);
			ps.setString(2,trade.getISIN());
			ps.setInt(3,trade.getQuantity());
			ps.setFloat(4,trade.getPrice());
			ps.setString(5,trade.getBuyerMemberId());
			ps.setString(6,trade.getSellerMemberId());
//			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//			Date tradeUtilDate = trade.getTradeDate();
//			String tradeDate = df.format(tradeUtilDate);
			ps.setDate(7,new Date(000));
			
			ps.setString(8,"Unsettled");
			ps.setDate(9,new Date(000));
//			LocalDate localDate = LocalDate.now();
//     		Date settleUtilDate = new Date(df.format(localDate.plusDays(2)));
//     		String settleDate = df.format(settleUtilDate);
//			ps.setDate(9,java.sql.Date.valueOf(settleDate));
			
			rowsAdded = ps.executeUpdate();
			if(rowsAdded>0)
				status = true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public boolean removeTrade(String tradeId) {
		// TODO Auto-generated method stub
		boolean status=false;
		String ADDTRADE = "DELETE FROM TRADE WHERE tradeId = ?";
		Connection con = MyConnection.openConnection();
		try {
			PreparedStatement ps = con.prepareStatement(ADDTRADE);
			ps.setString(1,tradeId);
			int rowsAdded = ps.executeUpdate();
			if(rowsAdded>0)
				status = true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public boolean addRandomTrade(int noOfTrade) {
		// TODO Auto-generated method stub
		boolean flag = true;
		CommonFunctionalities commonFunc = new CommonFunctionalitiesImpl();
		List<Trade> tradeList = commonFunc.generateTrade(noOfTrade);
		for(int i=0;i<noOfTrade;i++) {
			flag  = addNewTrade(tradeList.get(i));
			if(!flag)
				break;
		}
		return flag;
	}

	

	@Override
	public boolean updateMarketPrice(String ISIN, float newPrice) {
		// TODO Auto-generated method stub
		boolean isUpdated = false;
		String UpdateDematBalance = "UPDATE SEC_PRICING SET Market_Price = ? where ISIN = ?";
		try(Connection con = MyConnection.openConnection()){
			PreparedStatement ps = con.prepareStatement(UpdateDematBalance);
			ps.setFloat(1, newPrice);
			ps.setString(2, ISIN);
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
	public boolean updateSecurityInterestRate(String ISIN, float newRate) {
		// TODO Auto-generated method stub
		boolean isUpdated = false;
		String UpdateDematBalance = "UPDATE SEC_PRICING SET interestRate = ? where ISIN = ?";
		try(Connection con = MyConnection.openConnection()){
			PreparedStatement ps = con.prepareStatement(UpdateDematBalance);
			ps.setFloat(1, newRate);
			ps.setString(2, ISIN);
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
	public boolean updateFundInterestRate(float newPrice) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ObligationReport generateObligationReport(int memberId, java.sql.Date tradeDate) {
		// TODO Auto-generated method stub
		ObligationReport or = null;
		return or;
	}

	@Override
	public SettlementReport generateSettlementReport(int memberId, java.sql.Date tradeDate) {
		// TODO Auto-generated method stub
		SettlementReport sr = null;
		return sr;
	}

}