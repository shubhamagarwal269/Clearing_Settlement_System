package com.dao_impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.businesslogic.SettleFundsAlgo;
import com.businesslogic.SettleSecuritiesAlgo;
import com.connections.MyConnection;
import com.dao.AdminDashboard;
import com.dao.CommonFunctionalities;
import com.pojo.ObligationReport;
import com.pojo.Trade;

public class AdminDashboardImpl implements AdminDashboard{

	
	
	@Override
	public int applyNetting(List<Trade> tradeList) {
		// TODO Auto-generated method stub
		SettleFundsAlgo fundsAlgo = new SettleFundsAlgo();
		SettleSecuritiesAlgo securitiesAlgo = new SettleSecuritiesAlgo();
		List<ObligationReport> obgFundList = new ArrayList<>();
		List<ObligationReport> obgSecList = new ArrayList<>();
		obgFundList = fundsAlgo.settleFunds(tradeList);
		obgSecList = securitiesAlgo.settleSecurities(tradeList);
		
		String UPDATESECNETTING = "INSERT INTO OBG_REPORT VALUES(?,?,?,?,?)";
		
		Connection con1 = MyConnection.openConnection();
		
		try {
			PreparedStatement ps1 = con1.prepareStatement(UPDATESECNETTING );
			for(int i=0;i<obgSecList.size();i++)
			{
				ps1.setInt(1, obgSecList.get(i).getMemberId());
				ps1.setInt(2, obgSecList.get(i).getBatchNum());
				ps1.setDouble(3, obgSecList.get(i).getFundAmt());
				ps1.setInt(4, obgSecList.get(i).getISIN());
				ps1.setInt(5, obgSecList.get(i).getQuantity());
				ps1.executeUpdate();
			}
			
		String UPDATEFUNDNETTING = "update OBG_REPORT set fundAmt = ? where memberId = ? and batchNum = ?";
		
		Connection con2 = MyConnection.openConnection();
		
		PreparedStatement ps2 = con2.prepareStatement(UPDATEFUNDNETTING );
			for(int i=0;i<obgFundList.size();i++)
			{
				ps2.setDouble(1, obgFundList.get(i).getFundAmt());
				ps2.setInt(2, obgFundList.get(i).getMemberId());
				ps2.setInt(3, obgFundList.get(i).getBatchNum());
				ps2.executeUpdate();
			}
			
		return 0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 1;
	}

	@Override
	public int addNewTrade(Trade trade, boolean newBatch) {
		// TODO Auto-generated method stub
		int rowsAdded = 0;

		CommonFunctionalities commonFunc = new CommonFunctionalitiesImpl();
		
		int tradeId = commonFunc.getNextTradeId();
		
		String ADDTRADE = "INSERT INTO TRADE VALUES(?,?,?,?,?,?,?)";
		
		Connection con = MyConnection.openConnection();
		
		int batchNum = commonFunc.getNextBatchNum();
		
		if(!newBatch)
			batchNum--;
		
		
		try {
			PreparedStatement ps = con.prepareStatement(ADDTRADE);
			ps.setInt(1,tradeId);
			ps.setInt(2,trade.getISIN());
			ps.setInt(3,trade.getQuantity());
			ps.setDouble(4,trade.getPrice());
			ps.setInt(5,trade.getBuyerMemberId());
			ps.setInt(6,trade.getSellerMemberId());
			ps.setInt(7,batchNum);
			
			rowsAdded = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowsAdded;
	}

	@Override
	public int removeTrade(int tradeId) {
		// TODO Auto-generated method stub
		int rowsRemoved = 0;
		
		String DELETETRADE = "DELETE FROM TRADE WHERE tradeId = ?";
		
		Connection con = MyConnection.openConnection();
		
		try {
			PreparedStatement ps = con.prepareStatement(DELETETRADE);
			ps.setInt(1,tradeId);
			rowsRemoved = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowsRemoved;
	}

	@Override
	public int addRandomTrade(int noOfTrade, boolean newBatch) {
		// TODO Auto-generated method stub
		int rowsAdded = 0;
		
		CommonFunctionalities commonFunc = new CommonFunctionalitiesImpl();
		
		List<Trade> tradeList = commonFunc.generateTrade(noOfTrade, newBatch);
		for(int i=0;i<noOfTrade;i++) {
			rowsAdded  += addNewTrade(tradeList.get(i),newBatch);
			newBatch = false;
		}
		
		return rowsAdded;
	}


	@Override
	public int updateMarketPrice(int ISIN, double newPrice) {
		// TODO Auto-generated method stub
		int rowsUpdated = 0;
		
		String UPDATEMARKETPRICE = "UPDATE SECURITY SET marketPrice = ? where ISIN = ?";
		
		try(Connection con = MyConnection.openConnection()){
			PreparedStatement ps = con.prepareStatement(UPDATEMARKETPRICE);
			ps.setDouble(1, newPrice);
			ps.setInt(2, ISIN);
		    rowsUpdated = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowsUpdated;
	}

	@Override
	public int updateBorrowingRate(int ISIN, double newRate) {
		// TODO Auto-generated method stub
		int rowsUpdated = 0;
		
		String UPDATEBORROWINGRATE = "UPDATE SECURITY SET borrowingRate = ? where ISIN = ?";
		
		try(Connection con = MyConnection.openConnection()){
			PreparedStatement ps = con.prepareStatement(UPDATEBORROWINGRATE);
			ps.setDouble(1, newRate);
			ps.setInt(2, ISIN);
		    rowsUpdated = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowsUpdated;
	}

}