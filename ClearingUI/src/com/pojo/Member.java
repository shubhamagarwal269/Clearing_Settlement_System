package com.pojo;

public class Member {
	private String memberId;
	private String name;
	private String email;
	private String bankAcNo;
	private String dematAcNo;
	
	/*Default constructor for clearing member*/
	public Member() {
		memberId = "0000000000";
		name = "NULL";
		email = "NULL";
		bankAcNo = "0000000000";
		dematAcNo = "0000000000";
	}
	
	/*Parameterized constructor for clearing member*/
	public Member(String memberId, String name, String email, String bankAcNo, String dematAcNo) {
		this.memberId = memberId;
		this.name = name;
		this.email = email;
		this.bankAcNo = bankAcNo;
		this.dematAcNo = dematAcNo;
	}
	
	/*Getters and Setters for all data members*/
	public String getMemberId() {
		return memberId;
	}

	public void setMemberID(String memberId) {
		this.memberId = memberId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBankAcNo() {
		return bankAcNo;
	}

	public void setBankAcNo(String bankAcNo) {
		this.bankAcNo = bankAcNo;
	}

	public String getDematAcNo() {
		return dematAcNo;
	}

	public void setDematAcNo(String dematAcNo) {
		this.dematAcNo = dematAcNo;
	}


	/*Display all data members*/
	@Override
	public String toString() {
		return "ClearingMember [memberId=" + memberId + ", name=" + name + ", email=" + email + ", bankAcNo=" + bankAcNo
				+ ", dematAcNo=" + dematAcNo + "]";
	}
	
}

