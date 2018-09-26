package com.dao_impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.connections.MyConnection;
import com.dao.CommonFunctionalities;
import com.pojo.Member;
import com.pojo.Pair;
import com.pojo.Security;
import com.pojo.Trade;

public class CommonFunctionalitiesImpl implements CommonFunctionalities{
	
	public static float tickSize = 0.05f;
	
	@Override
	public double roundToDecimalPlaces(double p, int decimal_places) {
		// TODO Auto-generated method stub
		double shift=Math.pow(10, decimal_places);
		
		return (Math.round(p*shift)/shift);
	}

	@Override
	public List<Trade> generateTrade(int noOfTrades, boolean newBatch) {
		CommonFunctionalities commonFunc = new CommonFunctionalitiesImpl();
		List<Trade> tradeList = new ArrayList<>();
		
		List<Member> memList = commonFunc.viewAllMembers();
		List<Security> secList= commonFunc.viewAllSecurities();
		
		int noOfMembers = memList.size();
		int noOfSecurities = secList.size();
		
		
		Random random=new Random();
		
		int tradeCount = commonFunc.getNextTradeId();
		
		for(int i=0;i<noOfTrades;i++){
			
			
			int buyerId = random.nextInt(noOfMembers); //random index for Buyer
			int sellerId = random.nextInt(noOfMembers); //random index for Seller
		
			while(buyerId == sellerId){
				sellerId = random.nextInt(noOfMembers); //eliminating trade with same clearing member 
			}
			
			int securityId = random.nextInt(noOfSecurities); //random index for security
			int quantity = random.nextInt(100);
			
			while(quantity==0) {
				quantity = random.nextInt(100);
			}
			
			quantity=1000*quantity;
			
			double price = secList.get(securityId).getMarketPrice();
			
			int changeInPrice = (random.nextInt((1+1)+1)-1); // for randomly generating -1 and 1 => -1 leads to sub while +1 leads to add in price of security
			
			while(changeInPrice==0){
				changeInPrice = (random.nextInt((1+1)+1)-1);
			}
			
			price +=  changeInPrice * random.nextInt(40)* tickSize ; // 0.05 is the tick size and 40*0.05 allows fluctuation by 2 units
			price = roundToDecimalPlaces(price,2);
			
			int batchNum = getNextBatchNum();
			if(!newBatch)
				batchNum--;
     		
     		Trade trade = new Trade();
     		trade.setTradeID(tradeCount);
     		trade.setISIN(securityId);
     		trade.setQuantity(quantity);
     		trade.setPrice(price);
     		trade.setBuyerMemberId(buyerId);
     		trade.setSellerMemberId(sellerId);
     		trade.setBatchNum(batchNum);
			tradeList.add(trade);
			
			tradeCount++;
			
		}
		return  tradeList;

	}
	
	

	@Override
	public int getNextTradeId() {
		// TODO Auto-generated method stub
		int nextTradeId = 0;
		
		String FETCHLASTTRADEID = "SELECT top(1) tradeId  FROM TRADE order by tradeId desc";
		
		Connection con = MyConnection.openConnection();
		
		Statement st;
		
		try {
			st = con.createStatement();
			ResultSet set = st.executeQuery(FETCHLASTTRADEID);
			while(set.next()) {
				nextTradeId = set.getInt(1) + 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return nextTradeId;
	}



	@Override
	public List<Security> viewAllSecurities() {
		// TODO Auto-generated method stub
		List<Security> secList = new ArrayList<>();
		
		String VIEWSECURITY = "select * from SECURITY";
		
		try(Connection con = MyConnection.openConnection())
		{
			
			PreparedStatement ps = con.prepareStatement(VIEWSECURITY);
			ResultSet set = ps.executeQuery();
			
			while(set.next())
			{
				int ISIN = set.getInt("ISIN");
				String securityName = set.getString("securityName");
				double marketPrice = set.getDouble("marketPrice");
				double borrowingRate = set.getDouble("borrowiingRate");
				Security security = new Security(ISIN, securityName,marketPrice,borrowingRate);
				
				secList.add(security);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return secList;
	}

	@Override
	public List<Member> viewAllMembers() {
		// TODO Auto-generated method stub
		List<Member> memList = new ArrayList<>();
		
		String VIEWMEMBER = "select * from MEMBER";
		
		try(Connection con = MyConnection.openConnection())
		{
			
			PreparedStatement ps = con.prepareStatement(VIEWMEMBER);
			ResultSet set = ps.executeQuery();
			
			while(set.next())
			{
				int memberID = set.getInt("memberID");
				String memberName = set.getString("memberName");
				String memberEmail = set.getString("memberEmail");
				int bankAcNo = set.getInt("memberBankAcNo");
				int dematAcNo = set.getInt("dematAcNo");
				String password = "ENCRYPTED";
				
				Member mem = new Member(memberID, memberName,password,memberEmail, bankAcNo, dematAcNo);
				memList.add(mem);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return memList;
	}

	@Override
	public List<Trade> viewAllTradesByMemberId(int memberId) {
		// TODO Auto-generated method stub
		List<Trade> tradeList = new ArrayList<Trade>();
		
		String FETCHTRADELISTBYMEMID  = "select * from TRADE where buyerMemberId=? or sellerMemberId=?";
		
		try(Connection con=MyConnection.openConnection();)
		{
			PreparedStatement ps = con.prepareStatement(FETCHTRADELISTBYMEMID);
			
			ps.setInt(1, memberId);
			ps.setInt(2, memberId);
			
			ResultSet set = ps.executeQuery();
			
			while(set.next()) {
				int tradeId = set.getInt("tradeId");
				int ISIN = set.getInt("ISIN");
				int quantity = set.getInt("quantity");
				double price = set.getDouble("price");
				int buyerId = set.getInt("buyerId");
				int sellerId = set.getInt("sellerId");
				int batchNum = set.getInt("batchNum");
				Trade trade = new Trade(tradeId, ISIN, quantity, price, buyerId, sellerId, batchNum);
				tradeList.add(trade);
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return tradeList;
	}

	@Override
	public List<Trade> viewAllTrades() {
		// TODO Auto-generated method stub
		List<Trade> tradeList = new ArrayList<Trade>();
		
		String FETCHALLTRADE  = "select * from TRADE";
		
		try(Connection con=MyConnection.openConnection();)
		{
			PreparedStatement ps = con.prepareStatement(FETCHALLTRADE);
			
			ResultSet set = ps.executeQuery();
			
			while(set.next()) {
				
				int tradeId = set.getInt("tradeId");
				int ISIN = set.getInt("ISIN");
				int quantity = set.getInt("tradeQuantity");
				double price = set.getFloat("price");
				int buyerId = set.getInt("buyerId");
				int sellerId = set.getInt("sellerId");
				int batchNum = set.getInt("batchNum");
				Trade trade = new Trade(tradeId, ISIN, quantity, price, buyerId, sellerId, batchNum);
				tradeList.add(trade);
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return tradeList;
	}

	@Override
	public int updateDematBalance(int memberId, int ISIN, int changeInQuantity) {
		// TODO Auto-generated method stub
		int rowsUpdated = 0;
		String UPDATEDEMATBALANCE = "UPDATE DEMAT_DETAILS SET quantity = quantity + ? WHERE memberId = ? && ISIN = ?";
		try(Connection con = MyConnection.openConnection()){
			
			PreparedStatement ps = con.prepareStatement(UPDATEDEMATBALANCE);
			
			ps.setInt(1, changeInQuantity);
			
			ps.setInt(2, memberId);
			
			ps.setInt(3, ISIN);
			
			rowsUpdated = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowsUpdated;
	}

	@Override
	public int updateBankBalance(int memberId, double changeInBalance) {
		// TODO Auto-generated method stub
		int rowsUpdated = 0;
		
		String UPDATEBANKBALANCE = "UPDATE BANK_DETAILS SET balance = balance + ? WHERE memberId = ?";
		try(Connection con = MyConnection.openConnection()){
			
			PreparedStatement ps = con.prepareStatement(UPDATEBANKBALANCE);
			
			ps.setDouble(1, changeInBalance);
			ps.setInt(2, memberId);
			rowsUpdated = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowsUpdated;
	}
	
	@Override
	public List<Pair<Integer, Integer>> viewDematAcBalanceByMemberId(int memberId) {
		// TODO Auto-generated method stub
		List<Pair<Integer, Integer>> securityList = new ArrayList<Pair<Integer, Integer>>();
		
		String FETCHSECURITYLISTOFMEMBER = "select * from Demat_Details where memberId = ?";
		
		try(Connection con=MyConnection.openConnection();)
		{
			PreparedStatement ps = con.prepareStatement(FETCHSECURITYLISTOFMEMBER );
			ps.setInt(1, memberId);
			ResultSet set = ps.executeQuery();
			
			while(set.next()) {
				int ISIN = set.getInt("ISIN");
				int quantity = set.getInt("quantity");
				Pair<Integer, Integer> p = new Pair<Integer, Integer>((Integer)ISIN, (Integer)quantity);
				securityList.add(p);
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return securityList;
	}

	@Override
	public int getNextMemberId() {
		// TODO Auto-generated method stub
		int nextMemberId = 0;
		String FETCHLASTMEMBERID = "SELECT top(1) memberId  FROM MEMBER order by memberId desc";
		Connection con = MyConnection.openConnection();
		Statement st;
		try {
			st = con.createStatement();
			ResultSet set = st.executeQuery(FETCHLASTMEMBERID);
			while(set.next()) {
				nextMemberId = set.getInt(1) + 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nextMemberId;
		
	}

	@Override
	public int getNextBatchNum() {
		// TODO Auto-generated method stub
		int nextBatchNum = 0;
		String FETCHLASTBATCHNUM = "SELECT top(1) batchNum  FROM Trade order by batchNum desc";
		Connection con = MyConnection.openConnection();
		Statement st;
		try {
			st = con.createStatement();
			ResultSet set = st.executeQuery(FETCHLASTBATCHNUM);
			while(set.next()) {
				nextBatchNum = set.getInt(1) + 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nextBatchNum;
	}

	@Override
	public int getNumOfSecurity() {
		// TODO Auto-generated method stub
		int noOfSecurity = 0;
		String NOOFSECURITY = "SELECT count(*) FROM SECURITY";
		Connection con = MyConnection.openConnection();
		Statement st;
		try {
			st = con.createStatement();
			ResultSet set = st.executeQuery(NOOFSECURITY);
			while(set.next()) {
				noOfSecurity = set.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return noOfSecurity;
	}

	@Override
	public List<Double> fetchMarketPrice() {
		// TODO Auto-generated method stub
		List<Double> marketPriceList = new ArrayList<>();
		
		
		String FETCHMARKETPRICE = "select marketPrice from SECURITY";
		
		try(Connection con=MyConnection.openConnection();)
		{
			PreparedStatement ps = con.prepareStatement(FETCHMARKETPRICE);
			
			ResultSet set = ps.executeQuery();
			
			while(set.next()) {
				
				double marketPrice = set.getInt(1);
				marketPriceList.add(marketPrice);
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return marketPriceList;
	}

	@Override
	public List<Double> fetchBorrowingRate() {
		// TODO Auto-generated method stub
		List<Double> borrowingRateList = new ArrayList<>();
		
		
		String FETCHBORROWINGRATE = "select borrowingRate from SECURITY";
		
		try(Connection con=MyConnection.openConnection();)
		{
			PreparedStatement ps = con.prepareStatement(FETCHBORROWINGRATE);
			
			ResultSet set = ps.executeQuery();
			
			while(set.next()) {
				
				double borrowingRate = set.getInt(1);
				borrowingRateList.add(borrowingRate);
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return borrowingRateList;
	}
}
