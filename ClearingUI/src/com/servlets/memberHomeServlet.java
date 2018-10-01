package com.servlets;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.NumberFormatter;

import com.dao.CommonFunctionalities;
import com.dao.GenerateMemberReport;
import com.dao_impl.CommonFunctionalitiesImpl;
import com.dao_impl.GenerateMemberReportImpl;
import com.pojo.Member;
import com.pojo.MemberReport;
import com.pojo.ObligationReport;
import com.pojo.Pair;

/**
 * Servlet implementation class memberHomeServlet
 */
@WebServlet("/memberHome")
public class memberHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public memberHomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(); 
		int memberId = (int)session.getAttribute("memberId");
		
		CommonFunctionalities dao = new CommonFunctionalitiesImpl();
		List<Member> members = dao.viewAllMembers();

		request.setAttribute("members", members);
		
		GenerateMemberReport dao1 = new GenerateMemberReportImpl();
		List<MemberReport> report = dao1.viewAllMembersReports();
		List<Double> obg = new ArrayList<>();
		for(int i=0;i<report.size();i++)
		{
			if(report.get(i).getMemberId() == memberId)
			{
				obg = report.get(i).getObligation();
			}
		}
		
		request.setAttribute("report", obg);
		double fundObligation = obg.get(5);
		request.setAttribute("report1", new BigDecimal(fundObligation).setScale(2, BigDecimal.ROUND_HALF_EVEN));
	CommonFunctionalities func = new CommonFunctionalitiesImpl();
	List<Double> balance = new ArrayList<>();
	List<Pair<Integer, Integer>> securityList = new ArrayList<Pair<Integer, Integer>>();
	securityList = func.viewDematAcBalanceByMemberId(memberId);
	double sec = 0d;
	for(int i=0;i<5;i++)
	{
		Double sum = obg.get(i) + securityList.get(i).getSecond();
		if(sum<0){
			sec = sum;
			System.out.println(sec);
		}
		else {
			sec = 0d;
		}
		balance.add(sec);
	}
	request.setAttribute("DABal", securityList);
	
	request.setAttribute("SecShort", balance);
	double bankBal = dao1.viewBankAcBalance(memberId);
	request.setAttribute("BABal", bankBal);
	
	
		double fundShortage = obg.get(5) + bankBal;
		if(fundShortage<0){
			fundShortage = fundShortage;
			System.out.println(sec);
		}
		else {
			fundShortage = 0d;
		}
	

	
	MathContext m = new MathContext(10);
	
	request.setAttribute("fundShort", new BigDecimal(fundShortage).setScale(2, BigDecimal.ROUND_HALF_EVEN));
    RequestDispatcher dispatcher = request.getRequestDispatcher("dashMember.jsp");
	dispatcher.forward(request, response);
	}
}
