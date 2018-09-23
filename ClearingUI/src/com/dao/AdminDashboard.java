package com.dao;

import java.sql.Date;
import java.util.List;

import com.pojo.Member;
import com.pojo.ObligationReport;
import com.pojo.SettlementReport;
import com.pojo.Trade;

public interface AdminDashboard {
	boolean applyNetting(List<Trade> tradeList);
	boolean addNewTrade(Trade trade);
	boolean removeTrade(String tradeId);
	boolean addRandomTrade(int noOfTrade);
	ObligationReport generateObligationReport(int memberId, Date tradeDate);
	SettlementReport generateSettlementReport(int memberId, Date tradeDate);
	boolean updateMarketPrice(String ISIN, float newPrice);
	boolean updateSecurityInterestRate(String ISIN, float newRate);
	boolean updateFundInterestRate(float newPrice);
}
