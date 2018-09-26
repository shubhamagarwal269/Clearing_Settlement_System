package com.dao;

import java.util.List;

import com.pojo.Member;
import com.pojo.MemberReport;
import com.pojo.ObligationReport;

public interface GenerateMemberReport {
	public List<MemberReport> viewAllMembersReports();
	public Member viewProfile(int memberId);
	public int viewDematAcBalanceByISIN(int memberId, int ISIN);
	ObligationReport generateObligationReport(int memberId, int ISIN);
	public double viewBankAcBalance(int memberId);
	public List<Double> shortage(List<Double> oRList, List<Double> currentBalanceList);
	public List<Double> settlementCost(List<Double> shortageList, List<Double> marketPriceList, List<Double> borrowingRateList);

}
