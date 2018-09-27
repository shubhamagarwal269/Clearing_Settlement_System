package com.dao;

import java.util.List;

import com.pojo.Member;
import com.pojo.ObligationReport;
import com.pojo.Pair;
import com.pojo.Security;
import com.pojo.Trade;

public interface CommonFunctionalities {
	public double roundToDecimalPlaces(double p,int decimal_places);
	public List<Member> viewAllMembers();
	public List<Trade> generateTrade(int noOfTrades, boolean newBatch);
	public int getNextTradeId();
	public int getNextMemberId();
	public int getNextBatchNum();
	public List<Security> viewAllSecurities();
	public List<Trade> viewAllTradesByMemberId(int memberId);
	public int getMemberId(String memberName);
	public List<Trade> viewAllTrades();
	public int updateDematBalance(int memberId, int ISIN, int changeInQuantity);
	public int updateBankBalance(int memberId, double changeInBalance);
	List<Pair<Integer,Integer>> viewDematAcBalanceByMemberId(int memberId); 
	public int getNumOfSecurity();
	public List<Double> fetchMarketPrice();
	public List<Double> fetchBorrowingRate();
	public List<ObligationReport> viewAllObgReports();
}
