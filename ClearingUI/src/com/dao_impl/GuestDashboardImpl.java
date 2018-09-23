package com.dao_impl;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.connections.MyConnection;
import com.dao.CommonFunctionalities;
import com.dao.GuestDashboard;
import com.pojo.Trade;

public class GuestDashboardImpl implements GuestDashboard{

	@Override
	public boolean addNewGuestTrade(Trade trade) {
		// TODO Auto-generated method stub
		int rowsAdded = 0;
		boolean status=false;
		String ADD_TRADE = "insert into GUEST_TRADE values (?,?,?,?,?,?,?,?,?)";
		
		Connection con = MyConnection.openConnection();
		try {
			con.setAutoCommit(false);
			PreparedStatement ps = con.prepareStatement(ADD_TRADE);
			ps.setString(1, trade.getTradeId());
			ps.setString(2, trade.getISIN());
			ps.setInt(3, trade.getQuantity());
			ps.setFloat(4, trade.getPrice());
			ps.setString(5, trade.getBuyerMemberId());
			ps.setString(6, trade.getSellerMemberId());
			ps.setDate(7, new Date(000));
			ps.setString(8, trade.getStatus());
			ps.setDate(9, new Date(000));
			
			
			rowsAdded = ps.executeUpdate();
			
			if(rowsAdded>0)
				status = true;
			
			con.commit();
			
			}
			catch ( SQLException e) {
				
				try {
					con.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}e.printStackTrace();
			}
			return status;
	}

	@Override
	public boolean removeGuestTrade(String tradeId) {
		// TODO Auto-generated method stub
		int rowsDeleted = 0;
		boolean status = false;
		String DELETE_TRADE="delete from guest_trade where tradeID=?";
		try(Connection con = MyConnection.openConnection())
		{
			PreparedStatement ps = con.prepareStatement(DELETE_TRADE);
			ps.setString(1, tradeId);
			rowsDeleted = ps.executeUpdate();
			
			if(rowsDeleted>0)
				status = true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
	}

	@Override
	public boolean addRandomGuestTrade(int noOfTrades) {
		// TODO Auto-generated method stub
		boolean status =false;
		CommonFunctionalities commonFunc = new CommonFunctionalitiesImpl();
		List<Trade> tradeList = commonFunc.generateTrade(noOfTrades);
		for(int i=0;i<noOfTrades;i++) {
			status = addNewGuestTrade(tradeList.get(i));
			if(!status)
				break;
		}
			
		return status;
	}

	@Override
	public boolean applyNettingGuest(List<Trade> tradeList) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Trade> viewAllGuestTrades() {
		// TODO Auto-generated method stub
		List<Trade> tradeList = new ArrayList<>();
		String VIEW_ALL = "select * from guest_trade";
		try(Connection con = MyConnection.openConnection())
		{
			PreparedStatement ps = con.prepareStatement(VIEW_ALL);
			ResultSet set = ps.executeQuery();
			
			while(set.next())
			{
				String tradeId = set.getString("tradeId");
				String ISIN = set.getString("ISIN");
				Integer quantity = set.getInt("quantity");
				Float price = set.getFloat("price");
				String buyerMemberId = set.getString("buyerMemberId");
				String sellerMemberId = set.getString("sellerMemberId");
				Date tradeDate = set.getDate("tradeDate");
				String status = set.getString("status");
				Date settlementDate = set.getDate("settlementDate");
				
				
				Trade trade = new Trade(tradeId, ISIN, quantity, price, buyerMemberId, sellerMemberId,tradeDate, status,settlementDate );
				tradeList.add(trade);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tradeList;
		
	}

	@Override
	public List<Trade> viewAllGuestTradesByMemberName(String memberName) {
		// TODO Auto-generated method stub
        List<Trade> tradeList = new ArrayList<>();
        Connection con = MyConnection.openConnection();
        String memberId = "000";
        String GET_MEM_ID = "select memberId from MEMBER where name=?";
        PreparedStatement ps;
        ResultSet set;
		try {
			ps = con.prepareStatement(GET_MEM_ID);
			ps.setString(1, memberName);
			set = ps.executeQuery();
			while(set.next()) {
				memberId = set.getString("memberId");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String VIEW_BY_NAME =  "select * from GUEST_TRADE where buyerMemberId =? or sellerMemberId=?";
		try {
			ps = con.prepareStatement(VIEW_BY_NAME);
			ps.setString(1, memberId);
			ps.setNString(2, memberId);
			set = ps.executeQuery();
		
		while(set.next())
		{
			String tradeID = set.getString("tradeID");
			String ISIN = set.getString("ISIN");
			Integer quantity = set.getInt("quantity");
			Float price = set.getFloat("price");
			String buyerMemberID = set.getString("buyerMemberID");
			String sellerMemberID = set.getString("sellerMemberID");
			Date tradeDate = set.getDate("tradeDate");
			String status = set.getString("tstatus");
			Date settlementDate = set.getDate("settlementDate");
			Trade trade = new Trade(tradeID, ISIN, quantity, price, buyerMemberID, sellerMemberID,tradeDate, status,settlementDate );
			tradeList.add(trade);	
		}		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tradeList;
	}

}
