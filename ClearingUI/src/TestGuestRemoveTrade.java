import com.dao.GuestDashboard;
import com.dao_impl.GuestDashboardImpl;

public class TestGuestRemoveTrade {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GuestDashboard dao = new GuestDashboardImpl();
		boolean flag= dao.removeGuestTrade("2");
		System.out.println(flag);
	}

}
