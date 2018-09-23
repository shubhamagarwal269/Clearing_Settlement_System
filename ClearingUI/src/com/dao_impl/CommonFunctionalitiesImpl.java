package com.dao_impl;
//comment
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
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
	public float roundToDecimalPlaces(float p, int decimal_places) {
		// TODO Auto-generated method stub
		double shift=Math.pow(10, decimal_places);
		
		return (float) (Math.round(p*shift)/shift);
	}

	@Override
	public List<Trade> generateTrade(int noOfTrades) {
		CommonFunctionalities commonFunc = new CommonFunctionalitiesImpl();
		List<Trade> tradeList = new ArrayList<>();
		
		List<Member> memList = commonFunc.viewAllMembers();
		List<Security> secList= commonFunc.viewAllSecurities();
		List<Float> priceList = commonFunc.getMarketPrice(secList);
		
		int noOfMembers = memList.size();
		int noOfSecurities = secList.size();
		
		
		Random random=new Random();
		
		int tradeCount = Integer.parseInt(commonFunc.getNextTradeId());
		
		for(int i=0;i<noOfTrades;i++){
			
			tradeCount++;
			int buyerId = random.nextInt(noOfMembers)+1; //random index for Buyer
			int sellerId = random.nextInt(noOfMembers)+1; //random index for Seller
		
			while(buyerId == sellerId){
				sellerId = random.nextInt(noOfMembers)+1; //eliminating trade with same clearing member 
			}
			
			int securityId = random.nextInt(noOfSecurities)+1; //random index for security
			int quantity = random.nextInt(100)+1;
			
			quantity=1000*quantity;
			
			float price = priceList.get(securityId-1);
			
			int changeInPrice = (random.nextInt((1+1)+1)-1); // for randomly generating -1 and 1 => -1 leads to sub while +1 leads to add in price of security
			
			while(changeInPrice==0){
				changeInPrice = (random.nextInt((1+1)+1)-1);
			}
			
			price = (float)( price + ( changeInPrice * random.nextInt(40)* tickSize )); // 0.05 is the tick size and 40*0.05 allows fluctuation by 2 units
			price = roundToDecimalPlaces(price,2);
			
//			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//			LocalDate localDate = LocalDate.now();
//			Date  currentDate =  new Date(dtf.format(localDate));
//     		Date settleDate = (java.sql.Date) new Date(dtf.format(localDate.plusDays(2)));
     		
     		Date  currentDate =  new Date(000);
     		Date settleDate = new Date(000);
     		
     		Trade trade = new Trade();
     		trade.setTradeID(Integer.toString(tradeCount));
     		trade.setISIN(Integer.toString(securityId));
     		trade.setQuantity(quantity);
     		trade.setPrice(price);
     		trade.setBuyerMemberId(Integer.toString(buyerId));
     		
     		trade.setSellerMemberId(Integer.toString(sellerId));
     		trade.setTradeDate(currentDate);
     		trade.setStatus("Unsettled");
     		trade.setSettlementDate(settleDate);
     		
     			
			tradeList.add(trade);
			
		}
		return  tradeList;

	}
	
	

	@Override
	public String getNextTradeId() {
		// TODO Auto-generated method stub
		String tradeId = "0";
		String FETCHTRADEID = "SELECT top(1) tradeId  FROM TRADE order by cast(tradeId as int) desc";
		Connection con = MyConnection.openConnection();
		Statement st;
		try {
			st = con.createStatement();
			ResultSet set = st.executeQuery(FETCHTRADEID);
			while(set.next()) {
				tradeId = set.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tradeId = Integer.toString(Integer.parseInt(tradeId)+1);
		return tradeId;
	}

	@Override
	public List<Float> getMarketPrice(List<Security> secList) {
		// TODO Auto-generated method stub
		List<Float> priceList = new ArrayList<>();
		int noOfSecurity = secList.size();
		String FETCHPRICE = "SELECT *  FROM SEC_PRICING where ISIN=?";
		Connection con = MyConnection.openConnection();
		try {
			PreparedStatement ps = con.prepareStatement(FETCHPRICE);
			for(int i=0;i<noOfSecurity;i++) {
				ps.setString(1,secList.get(i).getISIN());
				ResultSet set = ps.executeQuery();
				while(set.next()) {
					float price = set.getFloat(3);
					priceList.add(price);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return priceList;
	}

	@Override
	public List<Security> viewAllSecurities() {
		// TODO Auto-generated method stub
List<Security> secList = new ArrayList<>();
		
		String VIEW_SECS = "select * from security";
		
		try(Connection con = MyConnection.openConnection())
		{
			
			PreparedStatement ps = con.prepareStatement(VIEW_SECS);
			ResultSet set = ps.executeQuery();
			
			while(set.next())
			{
				String ISIN = set.getString("ISIN");
				String securityName = set.getString("securityName");
				
				Security security = new Security(ISIN, securityName);
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
		
		String VIEW_MEM = "select * from member";
		
		try(Connection con = MyConnection.openConnection())
		{
			
			PreparedStatement ps = con.prepareStatement(VIEW_MEM);
			ResultSet set = ps.executeQuery();
			
			while(set.next())
			{
				String memberID = set.getString("memberID");
				String name = set.getString("name");
				String email = set.getString("email");
				String bankAcNo = set.getString("bankAcNo");
				String dematAcNo = set.getString("dematAcNo");
				
				
				Member mem = new Member(memberID, name, email, bankAcNo, dematAcNo);
				memList.add(mem);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return memList;
	}

	@Override
	public List<Trade> viewAllTradesByMemberId(String memberId) {
		// TODO Auto-generated method stub
		List<Trade> tradeList = new ArrayList<Trade>();
		String FETCH_TRADE_LIST  = "select * from trade where buyerId=? or sellerId=?";
		try(Connection con=MyConnection.openConnection();)
		{
			PreparedStatement ps = con.prepareStatement(FETCH_TRADE_LIST);
			ps.setString(1, memberId);
			ps.setString(2, memberId);
			ResultSet set = ps.executeQuery();
			while(set.next()) {
				String tradeId = set.getString("tradeId");
				String isin = set.getString("ISIN");
				int quantity = set.getInt("tradeQuantity");
				float price = set.getFloat("price");
				String buyerId = set.getString("buyerId");
				String sellerId = set.getString("sellerId");
				Date tradeDate = set.getDate("tradeDate");
				String status = set.getString("tradeStatus");
				Date settlementDate = set.getDate("settleDate");
				Trade trade = new Trade(tradeId, isin, quantity, price, buyerId, sellerId, tradeDate, status, settlementDate);
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
		String FETCH_TRADE_LIST  = "select * from trade";
		try(Connection con=MyConnection.openConnection();)
		{
			PreparedStatement ps = con.prepareStatement(FETCH_TRADE_LIST);
			ResultSet set = ps.executeQuery();
			while(set.next()) {
				String tradeId = set.getString("tradeId");
				String isin = set.getString("ISIN");
				int quantity = set.getInt("quantity");
				float price = set.getFloat("price");
				String buyerId = set.getString("buyerMemberId");
				String sellerId = set.getString("sellerMemberId");
				Date tradeDate = set.getDate("tradeDate");
				String status = set.getString("status");
				Date settlementDate = set.getDate("settlementDate");
				Trade trade = new Trade(tradeId, isin, quantity, price, buyerId, sellerId, tradeDate, status, settlementDate);
				tradeList.add(trade);
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return tradeList;
	}

	@Override
	public boolean updateDematBalance(String dematAccNo, String ISIN, int changeInQuantity) {
		// TODO Auto-generated method stub
		boolean isUpdated = false;
		String UpdateDematBalance = "UPDATE Demat_Details SET quantity = quantity + ? WHERE dematAcNo=? && ISIN=?";
		try(Connection con = MyConnection.openConnection()){
			PreparedStatement ps = con.prepareStatement(UpdateDematBalance);
			ps.setInt(1, changeInQuantity);
			ps.setString(2, dematAccNo);
			ps.setString(3, ISIN);
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
	public boolean updateBankBalance(String bankAccNo, float changeInBalance) {
		// TODO Auto-generated method stub
		boolean isUpdated = false;
		String UpdateBankBalance = "UPDATE Bank_Details SET balance = balance + ? WHERE bankAcNo=?";
		try(Connection con = MyConnection.openConnection()){
			PreparedStatement ps = con.prepareStatement(UpdateBankBalance);
			ps.setFloat(1, changeInBalance);
			ps.setString(2, bankAccNo);
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
	public Member viewProfile(String memberId) {
		Member member = new Member();
		String ViewProfile = "Select * from Member where memberID = ?";
		Connection con = MyConnection.openConnection();
		try {
			PreparedStatement ps = con.prepareStatement(ViewProfile);
			ps.setString(1, memberId);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				member.setMemberID(memberId);
				member.setName(rs.getString(2));
				member.setEmail(rs.getString(3));
				member.setBankAcNo(rs.getString(4));
				member.setDematAcNo(rs.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return member;
	}
	
	@Override
	public float viewBankAcBalance(String memberId) {
		// TODO Auto-generated method stub
		Member temp_memb = viewProfile(memberId);
		String bank_acc_no = temp_memb.getBankAcNo();
		String FETCH_BANK_BALANCE_BY_ACCNO = "select * from bank_details where bankAccNo=?";
		float balance = 0f;
		try(Connection con=MyConnection.openConnection();)
		{
			PreparedStatement ps = con.prepareStatement(FETCH_BANK_BALANCE_BY_ACCNO );
			ps.setString(1, bank_acc_no);
			ResultSet set = ps.executeQuery();
			while(set.next()) {
				balance = set.getFloat("quantity");
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return balance;
	}

	@Override
	public int viewDematAcBalanceByISIN(String memberId, String ISIN) {
		// TODO Auto-generated method stub
		String FETCH_DEMAT_BALANCE_BY_ISIN = "select * from demat_details where memberId=? and ISIN=?";
		int quantity = 0;
		try(Connection con=MyConnection.openConnection();)
		{
			PreparedStatement ps = con.prepareStatement(FETCH_DEMAT_BALANCE_BY_ISIN);
			ps.setString(1, memberId);
			ps.setString(2, ISIN);
			ResultSet set = ps.executeQuery();
			while(set.next()) {
				quantity = set.getInt("quantity");
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return quantity;
	}
	
	@Override
	public List<Pair<String, Integer>> viewDematAcBalanceByMemberId(String memberId) {
		// TODO Auto-generated method stub
		List<Pair<String, Integer>> security_list = new ArrayList<Pair<String, Integer>>();
		Member temp_memb = this.viewProfile(memberId);
		String demat_acc_no = temp_memb.getDematAcNo();
		String FETCH_SECURITY_LIST_OF_MEM = "select * from demat_details where dematAccNo=?";
		try(Connection con=MyConnection.openConnection();)
		{
			PreparedStatement ps = con.prepareStatement(FETCH_SECURITY_LIST_OF_MEM);
			ps.setString(1, demat_acc_no);
			ResultSet set = ps.executeQuery();
			
			while(set.next()) {
				String isin = set.getString("ISIN");
				int quantity = set.getInt("quantity");
				Pair<String, Integer> p = new Pair<String, Integer>(isin, (Integer)quantity);
				security_list.add(p);
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return security_list;
	}

	@Override
	public String getNextMemberId() {
		// TODO Auto-generated method stub
		String memberId = "0";
		String FETCHMEMBERID = "SELECT count(*)  FROM MEMBER";
		Connection con = MyConnection.openConnection();
		Statement st;
		try {
			st = con.createStatement();
			ResultSet set = st.executeQuery(FETCHMEMBERID);
			while(set.next()) {
				memberId = set.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		memberId = Integer.toString(Integer.parseInt(memberId)+1);
		return memberId;
		
	}


}

