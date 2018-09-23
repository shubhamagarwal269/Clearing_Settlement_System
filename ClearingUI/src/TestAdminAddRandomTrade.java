import com.dao.AdminDashboard;
import com.dao_impl.AdminDashboardImpl;

public class TestAdminAddRandomTrade {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdminDashboard adminDao = new AdminDashboardImpl();
		adminDao.addRandomTrade(5);
	}
}
