import com.dao.SignUpPage;
import com.dao_impl.SignUpPageImpl;
import com.pojo.Member;
import com.pojo.UserDetails;

public class TestMemberSignUpPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Member m1 = new Member( "1", "name_1", "email_1@gmail.com", "bankAcNo_1", "dmatAcNo_1");
		Member m2 = new Member( "2", "name_2", "email_2@gmail.com", "bankAcNo_2", "dmatAcNo_2");
		Member m3 = new Member( "3", "name_3", "email_3@gmail.com", "bankAcNo_3", "dmatAcNo_3");
		Member m4 = new Member( "4", "name_4", "email_4@gmail.com", "bankAcNo_4", "dmatAcNo_4");
		Member m5 = new Member( "5", "name_5", "email_5@gmail.com", "bankAcNo_5", "dmatAcNo_5");
		
		UserDetails u1 = new UserDetails("email_1@gmail.com", "userPass_1", 1);
		UserDetails u2 = new UserDetails("email_2@gmail.com", "userPass_2", 1);
		UserDetails u3 = new UserDetails("email_3@gmail.com", "userPass_3", 1);
		UserDetails u4 = new UserDetails("email_4@gmail.com", "userPass_4", 1);
		UserDetails u5 = new UserDetails("email_5@gmail.com", "userPass_5", 1);
		
		SignUpPage signUpDao = new SignUpPageImpl();
		signUpDao.registerMember(m1, u1);
		signUpDao.registerMember(m2, u2);
		signUpDao.registerMember(m3, u3);
		signUpDao.registerMember(m4, u4);
		signUpDao.registerMember(m5, u5);
		
//		Member m6 = new Member( "memberId_6", "name_6", "email_6@gmail.com", "bankAcNo_6", "dmatAcNo_6");
//		UserDetails u6 = new UserDetails("email_7@gmail.com", "userPass_6", 1);
//		signUpDao.registerMember(m6, u6);
		
	}

}
