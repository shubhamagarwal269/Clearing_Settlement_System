package com.pojo;

public class Member {
	private int memberId;
	private String memberName;
	private String memberPassword;
	private String memberEmail;
	private int bankAcNo;
	private int dematAcNo;
	
	/*Default constructor for clearing member*/
	public Member() {
		memberId = -2;
		memberName = "NULL";
		memberPassword = "NULL";
		memberEmail = "NULL";
		bankAcNo = 0;
		dematAcNo = 0;
	}

	public Member(int memberId, String memberName, String memberPassword, String memberEmail, int bankAcNo,
			int dematAcNo) {
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberPassword = memberPassword;
		this.memberEmail = memberEmail;
		this.bankAcNo = bankAcNo;
		this.dematAcNo = dematAcNo;
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

	public String getMemberPassword() {
		return memberPassword;
	}

	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public int getBankAcNo() {
		return bankAcNo;
	}

	public void setBankAcNo(int bankAcNo) {
		this.bankAcNo = bankAcNo;
	}

	public int getDematAcNo() {
		return dematAcNo;
	}

	public void setDematAcNo(int dematAcNo) {
		this.dematAcNo = dematAcNo;
	}

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberName=" + memberName + ", memberPassword=" + memberPassword
				+ ", memberEmail=" + memberEmail + ", bankAcNo=" + bankAcNo + ", dematAcNo=" + dematAcNo + "]";
	}

	

}

