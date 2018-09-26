package com.dao;

import com.pojo.Member;
import com.pojo.ObligationReport;

public interface MemberDashboard {
	int updateProfile(int memberId, Member member);
	ObligationReport viewObligationReport(int memberId);
}
