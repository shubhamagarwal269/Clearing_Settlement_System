package com.dao;

import java.util.List;

import com.pojo.Member;
import com.pojo.Pair;
import com.pojo.Security;
import com.pojo.Trade;

public interface CommonFunctionalities {
	public float roundToDecimalPlaces(float p,int decimal_places);
	public List<Trade> generateTrade(int noOfTrades);
	public String getNextTradeId();
	public String getNextMemberId();
	public List<Float> getMarketPrice(List<Security> secList);
	public List<Security> viewAllSecurities();
	public Member viewProfile(String memberId);
	public List<Member> viewAllMembers();
	public List<Trade> viewAllTradesByMemberId(String memberId);
	public List<Trade> viewAllTrades();
	public boolean updateDematBalance(String dematAccNo, String ISIN, int changeInQuantity);
	public boolean updateBankBalance(String bankAccNo, float changeInBalance);
	public int viewDematAcBalanceByISIN(String memberId, String ISIN);
	public float viewBankAcBalance(String memberId);
	List<Pair<String,Integer>> viewDematAcBalanceByMemberId(String memberId); 

}
