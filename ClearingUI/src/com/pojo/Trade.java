
package com.pojo;

import java.util.Date;

public class Trade {
	private String tradeId;
	private String ISIN;
	private int quantity;
	private float price;
	private String buyerMemberId;
	private String sellerMemberId;
	private Date tradeDate;
	private String status;
	private Date settlementDate;
	
	/*Default constructor for Trade*/
	public Trade() {
		tradeId = "0000000000";
		ISIN = "000000000000";
		quantity = 0;
		price = 0f;
		buyerMemberId = "0000000000";
		sellerMemberId = "0000000000";
		tradeDate = new Date(000);
		status = "NULL";
		settlementDate = new Date(000);
	}

	/*Parameterized constructor*/
	public Trade(String tradeId, String ISIN, int quantity, float price, String buyerMemberId, String sellerMemberId,
			Date tradeDate, String status, Date settlementDate) {
		this.tradeId = tradeId;
		this.ISIN = ISIN;
		this.quantity = quantity;
		this.price = price;
		this.buyerMemberId = buyerMemberId;
		this.sellerMemberId = sellerMemberId;
		this.tradeDate = tradeDate;
		this.status = status;
		this.settlementDate = settlementDate;
	}


	/*Getters and Setters Trade details*/
	public String getTradeId() {
		return tradeId;
	}

	public void setTradeID(String tradeId) {
		this.tradeId = tradeId;
	}

	public String getISIN() {
		return ISIN;
	}

	public void setISIN(String ISIN) {
		this.ISIN = ISIN;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getBuyerMemberId() {
		return buyerMemberId;
	}

	public void setBuyerMemberId(String buyerMemberId) {
		this.buyerMemberId = buyerMemberId;
	}

	public String getSellerMemberId() {
		return sellerMemberId;
	}

	public void setSellerMemberId(String sellerMemberId) {
		this.sellerMemberId = sellerMemberId;
	}

	public Date getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getSettlementDate() {
		return settlementDate;
	}

	public void setSettlementDate(Date settlementDate) {
		this.settlementDate = settlementDate;
	}

	@Override
	public String toString() {
		return "Trade [tradeId=" + tradeId + ", ISIN=" + ISIN + ", quantity=" + quantity + ", price=" + price
				+ ", buyerMemberId=" + buyerMemberId + ", sellerMemberId=" + sellerMemberId + ", tradeDate=" + tradeDate
				+ ", status=" + status + ", settlementDate=" + settlementDate + "]";
	}

	
	
	
	
}
