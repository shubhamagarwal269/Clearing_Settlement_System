import java.util.Date;

import com.dao.AdminDashboard;
import com.dao_impl.AdminDashboardImpl;
import com.pojo.Trade;

public class TestAdminAddNewTrade {
//comment
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Trade trade = new Trade("1","1",1,11.11f, "1", "2", new Date(000), "Unsettled", new Date(000));
		AdminDashboard adminDao = new AdminDashboardImpl();
		adminDao.addNewTrade(trade);
	}

}
