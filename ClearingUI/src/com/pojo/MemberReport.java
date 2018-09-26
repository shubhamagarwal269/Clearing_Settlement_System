package com.pojo;

import java.util.ArrayList;
import java.util.List;

public class MemberReport {
	
	private int memberId;
	private String memberName;
	private List<Double> obligation;
	private List<Double> currentBalance;
	private List<Double> shortage;
	private List<Double> settlementCost;
	private List<Double> marketPriceList;
	private List<Double> borrowingRateList;
	
	public MemberReport() {
		memberId = -2;
		memberName = "NULL";
		obligation = new ArrayList<>();
		currentBalance = new ArrayList<>();
		shortage = new ArrayList<>();
		this.settlementCost = new ArrayList<>();
		this.marketPriceList = new ArrayList<>();
		this.borrowingRateList = new ArrayList<>();
	}
	

	public MemberReport(int memberId, String memberName, List<Double> obligation, List<Double> currentBalance,
			List<Double> shortage, List<Double> settlementCost, List<Double> marketPriceList,
			List<Double> borrowingRateList) {
		this.memberId = memberId;
		this.memberName = memberName;
		this.obligation = obligation;
		this.currentBalance = currentBalance;
		this.shortage = shortage;
		this.settlementCost = settlementCost;
		this.marketPriceList = marketPriceList;
		this.borrowingRateList = borrowingRateList;
	}


	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public List<Double> getObligation() {
		return obligation;
	}

	public void setObligation(List<Double> obligation) {
		this.obligation = obligation;
	}

	public List<Double> getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(List<Double> currentBalance) {
		this.currentBalance = currentBalance;
	}

	public List<Double> getShortage() {
		return shortage;
	}

	public void setShortage(List<Double> shortage) {
		this.shortage = shortage;
	}

	public List<Double> getSettlementCost() {
		return settlementCost;
	}

	public void setSettlementCost(List<Double> settlementCost) {
		this.settlementCost = settlementCost;
	}

	public List<Double> getMarketPriceList() {
		return marketPriceList;
	}

	public void setMarketPriceList(List<Double> marketPriceList) {
		this.marketPriceList = marketPriceList;
	}

	public List<Double> getBorrowingRateList() {
		return borrowingRateList;
	}

	public void setBorrowingRateList(List<Double> borrowingRateList) {
		this.borrowingRateList = borrowingRateList;
	}

	@Override
	public String toString() {
		return "MembersReports [memberId=" + memberId + ", memberName=" + memberName + ", obligation=" + obligation
				+ ", currentBalance=" + currentBalance + ", shortage=" + shortage + ", settlementCost=" + settlementCost
				+ ", marketPriceList=" + marketPriceList + ", borrowingRateList=" + borrowingRateList + "]";
	}


	
	


}
