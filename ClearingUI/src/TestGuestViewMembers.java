import java.util.List;

import com.dao.CommonFunctionalities;
import com.dao_impl.CommonFunctionalitiesImpl;
import com.pojo.Member;

public class TestGuestViewMembers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CommonFunctionalities commonFunc = new CommonFunctionalitiesImpl();
		List<Member> mems = commonFunc.viewAllMembers();
		System.out.println(mems);
	}

}
