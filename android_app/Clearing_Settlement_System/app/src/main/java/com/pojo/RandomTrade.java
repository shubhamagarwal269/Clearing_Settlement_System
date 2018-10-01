package com.pojo;

public class RandomTrade {
int trade_id;
int Sec_ISIN;
int trade_quantity;
float trade_price;
int Buyer_id;
int Seller_id;
String Trade_date;
String Trade_Status;
String Settlement_date;
static int cnt=0;
public RandomTrade() {
	// TODO Auto-generated constructor stub
	cnt++;
	trade_id=cnt;
}

public RandomTrade(int Sec_ISIN,int quan, float price,int buyer_id,int seller_id, String trade_date) {
	// TODO Auto-generated constructor stub
	cnt++;
	trade_id=cnt;
	this.Sec_ISIN=Sec_ISIN;
	trade_quantity=quan;
	trade_price=price;
	Buyer_id=buyer_id;
	Seller_id=seller_id;
	Trade_date=trade_date;
	
}

public int getTrade_id() {
	return trade_id;
}

public void setTrade_id(int trade_id) {
	this.trade_id = trade_id;
}

public int getSec_ISIN() {
	return Sec_ISIN;
}

public void setSec_ISIN(int sec_ISIN) {
	Sec_ISIN = sec_ISIN;
}

public int getTrade_quantity() {
	return trade_quantity;
}

public void setTrade_quantity(int trade_quantity) {
	this.trade_quantity = trade_quantity;
}

public float getTrade_price() {
	return trade_price;
}

public void setTrade_price(float trade_price) {
	this.trade_price = trade_price;
}

public int getBuyer_id() {
	return Buyer_id;
}

public void setBuyer_id(int buyer_id) {
	Buyer_id = buyer_id;
}

public int getSeller_id() {
	return Seller_id;
}

public void setSeller_id(int seller_id) {
	Seller_id = seller_id;
}

public String getTrade_date() {
	return Trade_date;
}

public void setTrade_date(String trade_date) {
	Trade_date = trade_date;
}

public String getTrade_Status() {
	return Trade_Status;
}

public void setTrade_Status(String trade_Status) {
	Trade_Status = trade_Status;
}

public String getSettlement_date() {
	return Settlement_date;
}

public void setSettlement_date(String settlement_date) {
	Settlement_date = settlement_date;
}

@Override
public String toString() {
	return "RandomTradeGenerator [trade_id=" + trade_id + ", Sec_ISIN=" + Sec_ISIN + ", trade_quantity="
			+ trade_quantity + ", trade_price=" + trade_price + ", Buyer_id=" + Buyer_id + ", Seller_id=" + Seller_id
			+ ", Trade_date=" + Trade_date + ", Trade_Status=" + Trade_Status + ", Settlement_date=" + Settlement_date
			+ "]";
}


}
