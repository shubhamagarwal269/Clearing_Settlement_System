import java.util.List;
import com.dao.CommonFunctionalities;
import com.dao_impl.CommonFunctionalitiesImpl;
import com.pojo.Security;

public class TestGuestViewSecurities {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CommonFunctionalities commonFunc = new CommonFunctionalitiesImpl();
		List<Security> secs=commonFunc.viewAllSecurities();
		System.out.println(secs);
		
	}

}
