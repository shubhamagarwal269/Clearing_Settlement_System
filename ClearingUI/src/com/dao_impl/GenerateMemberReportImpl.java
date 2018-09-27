package com.dao_impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.connections.MyConnection;
import com.dao.CommonFunctionalities;
import com.dao.GenerateMemberReport;
import com.pojo.Member;
import com.pojo.MemberReport;
import com.pojo.ObligationReport;
public class GenerateMemberReportImpl implements GenerateMemberReport {
	double fundBorrowingRate = .0125d;

	@Override
	public Member viewProfile(int memberId) {
		
		Member member = new Member();
		
		String VIEWPROFILE = "Select * from MEMBER where memberID = ?";
		Connection con = MyConnection.openConnection();
		try {
			PreparedStatement ps = con.prepareStatement(VIEWPROFILE);
			ps.setInt(1, memberId);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				member.setMemberId(memberId);
				member.setMemberName(rs.getString(2));
				member.setMemberEmail(rs.getString(4));
				member.setBankAcNo(rs.getInt(5));
				member.setDematAcNo(rs.getInt(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return member;
	}
	
	@Override
	public int viewDematAcBalanceByISIN(int memberId, int ISIN) {
		String FETCHDEMATBALANCEBYISIN = "select * from Demat_Details where memberId=? and ISIN=?";
		int quantity = 0;
		try(Connection con=MyConnection.openConnection();)
		{
			PreparedStatement ps = con.prepareStatement(FETCHDEMATBALANCEBYISIN);
			ps.setInt(1, memberId);
			ps.setInt(2, ISIN);
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
	public ObligationReport generateObligationReport(int memberId, int ISIN) {
		ObligationReport obligReport = new ObligationReport();
		CommonFunctionalities commonFunc = new CommonFunctionalitiesImpl();
		int batchNo = commonFunc.getNextBatchNum()-1;
		
		String VIEW_OBLIG_REPORT = "select * from OBG_REPORT where memberId =? and ISIN = ? and batchNum = ?";
		Connection con = MyConnection.openConnection();
		try {
			PreparedStatement ps = con.prepareStatement(VIEW_OBLIG_REPORT);
			ps.setInt(1, memberId);
			ps.setInt(2, ISIN);
			ps.setInt(3, batchNo);			
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				obligReport.setMemberId(rs.getInt("memberId"));
				obligReport.setBatchNum(rs.getInt("batchNum"));
				obligReport.setFundAmt(rs.getDouble("fundAmt"));
				obligReport.setISIN(rs.getInt("ISIN"));
				obligReport.setQuantity(rs.getInt("quantity"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return obligReport;
	}


	@Override
	public double viewBankAcBalance(int memberId) {
		// TODO Auto-generated method stub
		
		String VIEWBANKBALANCE = "select * from BANK_DETAILS where memberId = ?";
		
		double balance = 0d;
		
		try(Connection con=MyConnection.openConnection();)
		{
			PreparedStatement ps = con.prepareStatement(VIEWBANKBALANCE );
			ps.setInt(1, memberId);
			ResultSet set = ps.executeQuery();
			while(set.next()) {
				balance = set.getDouble("balance");
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return balance;
	}

	@Override
	public List<MemberReport> viewAllMembersReports() {
		CommonFunctionalities commonFunc = new CommonFunctionalitiesImpl();
		List<Member> memberList = commonFunc.viewAllMembers();
		List<Integer> memberIdList = new ArrayList<>();
		List<MemberReport> memberReportList = new ArrayList<>();
		
		
		for(int i=0;i<memberList.size();i++)
	    {
			double fundAmt = 0;
			double fundAmtTemp = 0;
			ObligationReport obligReport = new ObligationReport();
			int memberId = memberList.get(i).getMemberId();
			memberIdList.add(memberId);
			String memberName = memberList.get(i).getMemberName();	
			MemberReport memReport = new MemberReport();
			memReport.setMemberId(memberId);
			memReport.setMemberName(memberName);
			
			List<Double> obligReportList = new ArrayList<>();
			
			
			for(int j=0;j<commonFunc.getNumOfSecurity();j++){
				Integer ISIN = j;
				obligReport = generateObligationReport(memberId, ISIN);
				
				obligReportList.add((double)obligReport.getQuantity());
				fundAmtTemp = obligReport.getFundAmt();
				if(fundAmtTemp != 0)fundAmt = fundAmtTemp; 
			}
			obligReportList.add(fundAmt);
			memReport.setObligation(obligReportList);;
			
			List<Double> currentBalanceList = new ArrayList<>();
			
			double quantity = 0;
			double balance = 0;
			
			for(int j=0;j<commonFunc.getNumOfSecurity();j++)
			{
				Integer ISIN = j;
				quantity = (double) viewDematAcBalanceByISIN(memberId, ISIN);
				currentBalanceList.add(quantity);
				balance = viewBankAcBalance(memberId);
			}
			
			currentBalanceList.add(balance);
			memReport.setCurrentBalance(currentBalanceList);
			
			List<Double> shortageList = new ArrayList<>();
			shortageList = shortage(obligReportList, currentBalanceList);
			memReport.setShortage(shortageList);
			
			List<Double> marketPriceList = commonFunc.fetchMarketPrice();
			List<Double> borrowingRateList = commonFunc.fetchBorrowingRate();
			List<Double> settlementCostList = new ArrayList<>();
			settlementCostList= settlementCost(shortageList, marketPriceList, borrowingRateList);
			
			memReport.setSettlementCost(settlementCostList);
			memReport.setBorrowingRateList(borrowingRateList);
			memReport.setMarketPriceList(marketPriceList);
			memberReportList.add(i,memReport);
	    }
		    
		return memberReportList;
	}

	public List<Double> settlementCost(List<Double> shortageList, List<Double> marketPriceList, List<Double> borrowingRateList) {
		
				List<Double> settCostList = new ArrayList<>();
				Double settCost = 0d;
				int i=0;
				CommonFunctionalities daotemp = new CommonFunctionalitiesImpl();
				for(i=0;i<shortageList.size()-1;i++)
				{
					settCost = (double)( (marketPriceList.get(i)*shortageList.get(i)+(marketPriceList.get(i)*shortageList.get(i))*borrowingRateList.get(i)*5.0d/36500.0d));
					settCost = daotemp.roundToDecimalPlaces(settCost, 4);
					settCostList.add(settCost);
				}
				settCost = (double)(shortageList.get(i)+(shortageList.get(i)*fundBorrowingRate*5.0d/365.0d));
				settCost = daotemp.roundToDecimalPlaces(settCost, 4);
				settCostList.add(settCost);
				
				return settCostList;
		
	}

	public List<Double> shortage(List<Double> oRList, List<Double> currentBalanceList) {
		
		List<Double> shortageList = new ArrayList<>();
		for(int i=0;i<oRList.size();i++)
		{	
			Double sum = oRList.get(i) + currentBalanceList.get(i);
			if(sum<0){
				shortageList.add(i, (-1)*sum);
			}
			else {
				shortageList.add(i, 0d);
			}
		}
		return shortageList;
		
	}

}
