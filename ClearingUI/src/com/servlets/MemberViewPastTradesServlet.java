package com.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.CommonFunctionalities;
import com.dao.GenerateMemberReport;
import com.dao_impl.CommonFunctionalitiesImpl;
import com.dao_impl.GenerateMemberReportImpl;
import com.pojo.Member;
import com.pojo.MemberReport;
import com.pojo.Trade;

/**
 * Servlet implementation class MemberViewPastTradesServlet
 */
@WebServlet("/viewMemberTrades")
public class MemberViewPastTradesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberViewPastTradesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session2 = request.getSession(); //everytime u do get, a new session will be provided if an old one doesnt already exist, or else the old active session is returned
		int memberId = (int)session2.getAttribute("memberId");
		
		CommonFunctionalities dao = new CommonFunctionalitiesImpl();
		List<Member> members = dao.viewAllMembers();
		request.setAttribute("members", members);
		List<Trade> trades = dao.viewAllTradesByMemberId(memberId);
		System.out.println(trades);
		request.setAttribute("reps", trades);
		System.out.println("after passing in servlet\n"+trades);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("MemberViewPastTrades.jsp");
		dispatcher.forward(request, response);
	}

}
