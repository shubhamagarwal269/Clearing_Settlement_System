import java.util.List;

import com.dao.GuestDashboard;
import com.dao_impl.GuestDashboardImpl;
import com.pojo.Trade;

public class TestGuestViewAllTradesByName {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GuestDashboard dao = new GuestDashboardImpl();
		
		List<Trade> list = dao.viewAllGuestTradesByMemberName("Citi");
		System.out.println(list);
	}

}
