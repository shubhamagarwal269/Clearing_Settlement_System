
package com.pojo;

public class Trade {
	private int tradeId;
	private int ISIN;
	private int quantity;
	private double price;
	private int buyerMemberId;
	private int sellerMemberId;
	private int batchNum;
	
	/*Default constructor for Trade*/
	public Trade() {
		tradeId = -1;
		ISIN = 0;
		quantity = 0;
		price = 0d;
		buyerMemberId = 0;
		sellerMemberId = 0;
		batchNum = 0;
	}

	/*Parameterized constructor*/
	public Trade(int tradeId, int ISIN, int quantity, double price, int buyerMemberId, int sellerMemberId, int batchNum) {
		this.tradeId = tradeId;
		this.ISIN = ISIN;
		this.quantity = quantity;
		this.price = price;
		this.buyerMemberId = buyerMemberId;
		this.sellerMemberId = sellerMemberId;
		this.batchNum = batchNum;
	}


	/*Getters and Setters Trade details*/
	public int getTradeId() {
		return tradeId;
	}

	public void setTradeID(int tradeId) {
		this.tradeId = tradeId;
	}

	public int getISIN() {
		return ISIN;
	}

	public void setISIN(int ISIN) {
		this.ISIN = ISIN;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getBuyerMemberId() {
		return buyerMemberId;
	}

	public void setBuyerMemberId(int buyerMemberId) {
		this.buyerMemberId = buyerMemberId;
	}

	public int getSellerMemberId() {
		return sellerMemberId;
	}

	public void setSellerMemberId(int sellerMemberId) {
		this.sellerMemberId = sellerMemberId;
	}

	public int getBatchNum() {
		return batchNum;
	}

	public void setBatchNum(int batchNum) {
		this.batchNum = batchNum;
	}

	@Override
	public String toString() {
		return "Trade [tradeId=" + tradeId + ", ISIN=" + ISIN + ", quantity=" + quantity + ", price=" + price
				+ ", buyerMemberId=" + buyerMemberId + ", sellerMemberId=" + sellerMemberId + ", batchNum=" + batchNum + "]";
	}
	
}
