package com.servlets;

import java.io.IOException;
//import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CommonFunctionalities;
import com.dao.SignInPage;
import com.dao_impl.CommonFunctionalitiesImpl;
import com.dao_impl.SignInPageImpl;
import com.pojo.Member;

/**
 * Servlet implementation class SignInServlet
 */
@WebServlet("/signin")
public class SignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignInServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String option = request.getParameter("options");
		String password = request.getParameter("password");
		boolean message = true;
		String notice = null; 
		//PrintWriter writer = response.getWriter();
		
		SignInPage signindao = new SignInPageImpl();
		if (option.equals("0") ) {
			if(username.equals("cns065918@gmail.com") && password.equals("admin@123")) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("dashAdmin.jsp");
				dispatcher.forward(request, response);
			} 
			else {
				message  = false;
				notice = "wrongCred";
				//String message = "You have entered wrong credentials, Please try again";
				request.setAttribute("alert", message);
				request.setAttribute("type", notice);
				RequestDispatcher dispatcher = request.getRequestDispatcher("signin.jsp");
				dispatcher.forward(request, response);
			}
		}
		else{
			int rowsUpdated = signindao.login(username, password);
			  if (rowsUpdated>0) {
					//writer.println("correct");
					//writer.println(option);
				    CommonFunctionalities c = new CommonFunctionalitiesImpl();
				    List<Member> m = c.viewAllMembers();
				    String name = null;
				    int id =0;
				    for(int i=0;i<m.size();i++)
				    {
				    	if(m.get(i).getMemberEmail().equals(username))
				    	{
				    		name = m.get(i).getMemberName();
				    		id = m.get(i).getMemberId();
				    	}
				    		
				    }
					request.setAttribute("username",name );
					request.setAttribute("memberId", id);
					GenerateMemberReport dao = new GenerateMemberReportImpl();
					List<MemberReport> report = dao.viewAllMembersReports();
					List<Double> obg = new ArrayList<>();
					for(int i=0;i<report.size();i++)
					{
						if(report.get(i).getMemberId() == id)
						{
							obg = report.get(i).getObligation();
						}
				}
				request.setAttribute("report", obg);
//				
//				CommonFunctionalities func = new CommonFunctionalitiesImpl();
//				List<Double> balance = new ArrayList<>();
//				List<Pair<Integer, Integer>> securityList = new ArrayList<Pair<Integer, Integer>>();
//				securityList = func.viewDematAcBalanceByMemberId(id);
//				for(int i=1;i<=5;i++)
//				{
//					balance.add(securityList.get(i).getSecond()-obg.get(i));
//				}
//				request.setAttribute("DABal", securityList);
//				
//				request.setAttribute("SecShort", balance);
//				double bankBal = dao.viewBankAcBalance(id);
//				request.setAttribute("BABal", bankBal);
//				double fundShortage = bankBal - obg.get(6);
//				request.setAttribute("fundShort", fundShortage);
				    RequestDispatcher dispatcher = request.getRequestDispatcher("dashMember.jsp");
					dispatcher.forward(request, response);
			  }  
			  else {
				message  = false;
				notice = "wrongCred";
				//String message = "You have entered wrong credentials, Please try again";
				request.setAttribute("alert", message);
				request.setAttribute("type", notice);
				RequestDispatcher dispatcher = request.getRequestDispatcher("signin.jsp");
				dispatcher.forward(request, response);
			  }	
		}
	}

}
