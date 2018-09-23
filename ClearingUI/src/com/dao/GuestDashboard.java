package com.dao;


import java.util.List;

import com.pojo.Trade;

public interface GuestDashboard {
	boolean addNewGuestTrade(Trade trade);
	boolean removeGuestTrade(String tradeId);
	boolean addRandomGuestTrade(int noOfTrades);
	boolean applyNettingGuest(List<Trade> tradeList);
	List<Trade> viewAllGuestTrades();
	List<Trade> viewAllGuestTradesByMemberName(String memberName);
}
