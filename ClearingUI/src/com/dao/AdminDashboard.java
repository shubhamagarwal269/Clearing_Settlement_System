package com.dao;

import java.util.List;
import com.pojo.Trade;

public interface AdminDashboard {
	int applyNetting(List<Trade> tradeList);
	int addNewTrade(Trade trade, boolean newBatch);
	int removeTrade(int tradeId);
	int addRandomTrade(int noOfTrade, boolean newBatch);
	int updateMarketPrice(int ISIN, double newPrice);
	int updateBorrowingRate(int ISIN, double newRate);
	int updateFundBorrowingRate(double newRate);
}
