import com.dao.AdminDashboard;
import com.dao.CommonFunctionalities;
import com.dao_impl.AdminDashboardImpl;
import com.dao_impl.CommonFunctionalitiesImpl;

public class TestCommonFunctionalities {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdminDashboard admin=new AdminDashboardImpl();
		admin.addRandomTrade(5, true);
		
		
		CommonFunctionalities commonFunc=new CommonFunctionalitiesImpl();
		commonFunc.viewAllTrades();
		commonFunc.settleTrades();
	}

}
