import java.sql.Date;

import com.dao.GuestDashboard;

import com.dao_impl.GuestDashboardImpl;
import com.pojo.Trade;

public class TestGuestAddTrade {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        GuestDashboard dao = new GuestDashboardImpl();
		Date date = new Date(000);
		
		
		String tradeID = "2";
		String ISIN = "3";
         int quantity = 500;
		float price = 95f;
		String buyerMemberID = "2";
	    String sellerMemberID = "1";
		Date tradeDate = date;
		String status = "settled";
		Date settlementDate = date;
		
		Trade trade = new Trade(tradeID, ISIN,quantity,price,buyerMemberID,sellerMemberID,tradeDate,status,settlementDate);
		boolean flag = dao.addNewGuestTrade(trade);
		if(flag){
			System.out.println("data inserted");
		}
		else{
			System.out.println("not added");
		}

	}

}
