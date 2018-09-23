import com.dao.AdminDashboard;
import com.dao_impl.AdminDashboardImpl;

public class TestAdminUpdateMarketPrice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdminDashboard adminDao = new AdminDashboardImpl();
		float newPrice = 44.44f;
		adminDao.updateMarketPrice("1", newPrice);
	}

}
