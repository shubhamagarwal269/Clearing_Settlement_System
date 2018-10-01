package com.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;


import com.dao.CommonFunctionalities;
import com.dao_impl.CommonFunctionalitiesImpl;
import com.example.ubuntu.clearing_settlement_system.R;
import com.pojo.Member;
import com.pojo.Trade;

import java.util.List;

public class viewTrades extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_trades);
        init();
    }

    public void init(){

        TableLayout tableLayout = (TableLayout) findViewById(R.id.displayLinear);

        CommonFunctionalities commonFunc = new CommonFunctionalitiesImpl();
        List<Trade> tradeList = commonFunc.viewAllTrades();
        List<Member> memList = commonFunc.viewAllMembers();

        for (int i = 0; i <tradeList.size(); i++) {
            TableRow row= new TableRow(this);
            TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            row.setLayoutParams(layoutParams);
            int ISIN = tradeList.get(i).getTradeId();
            String secName = null;
            if(ISIN==0){
                secName = "Apple";
            }
            else if(ISIN==1){
                secName = "Facebook";
            }
            else if(ISIN==2){
                secName = "GE";
            }
            else if(ISIN==3){
                secName = "LinkedIn";
            }
            else{
                secName = "Walmart";
            }
            int buyerId = tradeList.get(i).getBuyerMemberId();
            String buyerName = memList.get(buyerId).getMemberName();
            int sellerId = tradeList.get(i).getBuyerMemberId();
            String sellerName = memList.get(sellerId).getMemberName();
            int quantity = tradeList.get(i).getQuantity();
            double price = tradeList.get(i).getPrice();
            int batchNum = tradeList.get(i).getBatchNum();
            TextView secNametv = new TextView(this);
            TextView buyerNametv = new TextView(this);
            TextView sellerNametv = new TextView(this);
            TextView quantitytv = new TextView(this);
            TextView pricetv = new TextView(this);
            TextView batchtv = new TextView(this);
            if(i%2==0){
                secNametv.setBackgroundResource(R.color.blue);
                buyerNametv.setBackgroundResource(R.color.blue);
                sellerNametv.setBackgroundResource(R.color.blue);
                quantitytv.setBackgroundResource(R.color.blue);
                pricetv.setBackgroundResource(R.color.blue);
                batchtv.setBackgroundResource(R.color.blue);
            }
            else{
                secNametv.setBackgroundResource(R.color.blue_dark);
                buyerNametv.setBackgroundResource(R.color.blue_dark);
                sellerNametv.setBackgroundResource(R.color.blue_dark);
                quantitytv.setBackgroundResource(R.color.blue_dark);
                pricetv.setBackgroundResource(R.color.blue_dark);
                batchtv.setBackgroundResource(R.color.blue_dark);
            }
            secNametv.setPadding(10,0,10,0);
            buyerNametv.setPadding(10,0,10,0);
            sellerNametv.setPadding(10,0,10,0);
            quantitytv.setPadding(10,0,10,0);
            pricetv.setPadding(10,0,10,0);
            batchtv.setPadding(10,0,10,0);
            secNametv.setText(secName);
            buyerNametv.setText(buyerName);
            sellerNametv.setText(sellerName);
            quantitytv.setText(Integer.toString(quantity));
            pricetv.setText(Double.toString(price));
            batchtv.setText(Integer.toString(batchNum));
            row.addView(secNametv);
            row.addView(buyerNametv);
            row.addView(sellerNametv);
            row.addView(quantitytv);
            row.addView(pricetv);
            row.addView(batchtv);
            tableLayout.addView(row);
        }
    }
}
