package com.pojo;

public class Security {
	private int ISIN;
	private String securityName;
	private double marketPrice;
	private double borrowingRate;
	
	/*Default constructor for Security*/
	public Security() {
		ISIN = -1;
		securityName = "NULL";
		marketPrice = 0d;
		borrowingRate = 0d;
	}

	public Security(int ISIN, String securityName, double marketPrice, double borrowingRate) {
		super();
		this.ISIN = ISIN;
		this.securityName = securityName;
		this.marketPrice = marketPrice;
		this.borrowingRate = borrowingRate;
	}

	public int getISIN() {
		return ISIN;
	}

	public void setISIN(int ISIN) {
		this.ISIN = ISIN;
	}

	public String getSecurityName() {
		return securityName;
	}

	public void setSecurityName(String securityName) {
		this.securityName = securityName;
	}

	public double getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(double marketPrice) {
		this.marketPrice = marketPrice;
	}

	public double getBorrowingRate() {
		return borrowingRate;
	}

	public void setBorrowingRate(double borrowingRate) {
		this.borrowingRate = borrowingRate;
	}

	@Override
	public String toString() {
		return "Security [ISIN=" + ISIN + ", securityName=" + securityName + ", marketPrice=" + marketPrice
				+ ", borrowingRate=" + borrowingRate + "]";
	}
	
}
