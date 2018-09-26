import java.util.List;

import com.dao.GenerateMemberReport;
import com.dao_impl.GenerateMemberReportImpl;
import com.pojo.Member;
import com.pojo.MemberReport;
import com.pojo.ObligationReport;

public class TestGenMemReport {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GenerateMemberReport dao = new GenerateMemberReportImpl();
		/*Member mem = dao.viewProfile(1);
		System.out.println(mem);
		
		
		int bal = dao.viewDematAcBalanceByISIN(1, 2);
		System.out.println(bal);
		
		ObligationReport or = dao.generateObligationReport(2, 3);
		System.out.println(or);
		
		double bbal = dao.viewBankAcBalance(2);
		System.out.println(bbal);
		*/
		List<MemberReport> li = dao.viewAllMembersReports();
		for(int i=0; i<li.size(); i++) {
	    System.out.println(li.get(i));
	}
		
	//	System.out.println(li.size());
		
		
		

	}

}
