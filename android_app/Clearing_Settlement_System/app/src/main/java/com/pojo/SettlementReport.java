package com.pojo;

import java.sql.Date;

public class SettlementReport {
	private String reportId;
	private String memberId;
	private String memberName;
	private String securityName;
	private int quantity;
	private Date dueDate;
	
	public SettlementReport() {
		// TODO Auto-generated constructor stub
		reportId = "0000000000";
		memberId = "0000000000";
		memberName = "NULL";
		securityName = "NULL";
		this.quantity = 0;
		this.dueDate = new Date(000);
	}

	public SettlementReport(String reportId, String memberId, String memberName, String securityName, int quantity,
			Date dueDate) {
		this.reportId = reportId;
		this.memberId = memberId;
		this.memberName = memberName;
		this.securityName = securityName;
		this.quantity = quantity;
		this.dueDate = dueDate;
	}

	public String getReportId() {
		return reportId;
	}

	public void setReportId(String reportId) {
		this.reportId = reportId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getSecurityName() {
		return securityName;
	}

	public void setSecurityName(String securityName) {
		this.securityName = securityName;
	}

	@Override
	public String toString() {
		return "SettlementReport [reportId=" + reportId + ", memberId=" + memberId + ", memberName=" + memberName
				+ ", securityName=" + securityName + ", quantity=" + quantity + ", dueDate=" + dueDate + "]";
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	
	
}
