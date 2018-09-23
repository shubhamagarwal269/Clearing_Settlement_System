package com.dao;

import com.pojo.Member;
import com.pojo.ObligationReport;
import com.pojo.Pair;
import java.sql.Date;
import java.util.List;

import com.pojo.Security;
import com.pojo.SettlementReport;
import com.pojo.Trade;

public interface MemberDashboard {
	boolean updateProfile(String memberId, Member member);
	ObligationReport viewObligationReport(String memberId, Date tradeDate);
	SettlementReport viewSettlementReport(String memberId, Date tradeDate);
}
