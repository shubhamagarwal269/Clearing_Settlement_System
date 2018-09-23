import com.dao.AdminDashboard;
import com.dao_impl.AdminDashboardImpl;

public class TestAdminUpdateSecurityInterestRate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdminDashboard adminDao = new AdminDashboardImpl();
		float newPrice = 30f;
		adminDao.updateSecurityInterestRate("1", newPrice);
	}

}
