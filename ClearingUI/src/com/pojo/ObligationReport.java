package com.pojo;


public class ObligationReport {

	private int memberId;
	private int batchNum;
	private int ISIN;
	private int quantity;
	private double fundAmt;
	
	public ObligationReport() {
		memberId = 0;
		ISIN = 0;
		batchNum = 0;
		fundAmt = 0;
		quantity = 0;
	}

	public ObligationReport(int memberId, int batchNum, int ISIN, int quantity, double fundAmt) {
		this.memberId = memberId;
		this.batchNum = batchNum;
		this.ISIN = ISIN;
		this.quantity = quantity;
		this.fundAmt = fundAmt;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public int getBatchNum() {
		return batchNum;
	}

	public void setBatchNum(int batchNum) {
		this.batchNum = batchNum;
	}

	public int getISIN() {
		return ISIN;
	}

	public void setISIN(int iSIN) {
		ISIN = iSIN;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getFundAmt() {
		return fundAmt;
	}

	public void setFundAmt(double fundAmt) {
		this.fundAmt = fundAmt;
	}

	@Override
	public String toString() {
		return "ObligationReport [memberId=" + memberId + ", batchNum=" + batchNum + ", ISIN=" + ISIN + ", quantity="
				+ quantity + ", fundAmt=" + fundAmt + "]";
	}

	
	
}
