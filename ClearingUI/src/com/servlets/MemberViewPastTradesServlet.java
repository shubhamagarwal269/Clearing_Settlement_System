package com.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CommonFunctionalities;
import com.dao.GenerateMemberReport;
import com.dao_impl.CommonFunctionalitiesImpl;
import com.dao_impl.GenerateMemberReportImpl;
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
		
		
		CommonFunctionalities dao = new CommonFunctionalitiesImpl();
		List<Trade> trades = dao.viewAllTradesByMemberId(1);
		System.out.println(trades);
		request.setAttribute("reps", trades);
		System.out.println("after passing in servlet\n"+trades);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("MemberViewPastTrades.jsp");
		dispatcher.forward(request, response);
	}

}
