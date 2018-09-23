import com.dao.MemberDashboard;
import com.dao_impl.MemberDashboardImpl;
import com.pojo.Member;
//comment
public class TestMemberUpdateProfile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Member m1 = new Member( "memberId_1", "name_11", "email_11@gmail.com", "bankAcNo11", "dmatAcNo11");
		String memberId =  "memberId_1";
		MemberDashboard signUpDao = new MemberDashboardImpl();
		signUpDao.updateProfile(memberId, m1);
	}

}
