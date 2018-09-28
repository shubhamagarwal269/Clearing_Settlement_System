package com.servlets;

import java.io.IOException;
import java.util.ArrayList;
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
import com.pojo.Pair;

/**
 * Servlet implementation class balanceServlet
 */
@WebServlet("/balance")
public class balanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public balanceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(); 
		int id = (int)session.getAttribute("memberId");
		request.setAttribute("id", id);
		CommonFunctionalities func = new CommonFunctionalitiesImpl();
		//List<Double> balance = new ArrayList<>();
		List<Pair<Integer, Integer>> securityList = new ArrayList<Pair<Integer, Integer>>();
		securityList = func.viewDematAcBalanceByMemberId(id);
		request.setAttribute("DABal", securityList);
		GenerateMemberReport dao = new GenerateMemberReportImpl();
		
		double bankBal = dao.viewBankAcBalance(id);
		request.setAttribute("BABal", bankBal);
		RequestDispatcher dispatcher = request.getRequestDispatcher("memberBalances.jsp");
		dispatcher.forward(request, response);
	}

}
