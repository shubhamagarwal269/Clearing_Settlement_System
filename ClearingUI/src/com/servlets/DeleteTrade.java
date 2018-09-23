package com.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AdminDashboard;
import com.dao.CommonFunctionalities;
import com.dao_impl.AdminDashboardImpl;
import com.dao_impl.CommonFunctionalitiesImpl;
import com.pojo.Trade;

/**
 * Servlet implementation class DeleteTrade
 */
@WebServlet("/delete")
public class DeleteTrade extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTrade() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String tradeId = request.getParameter("tradeId");
		
		AdminDashboard admin = new AdminDashboardImpl();
		
		admin.removeTrade(tradeId);
		
		CommonFunctionalities commFunc = new CommonFunctionalitiesImpl();
		
		List<Trade> trades = commFunc.viewAllTrades();
		request.setAttribute("trades", trades);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("gensetTrades.jsp");
		dispatcher.forward(request, response);
		
		
	}

}
